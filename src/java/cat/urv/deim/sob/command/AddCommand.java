package cat.urv.deim.sob.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import BookREST.entities.Book;
import BookREST.entities.BookList;
import BookREST.entities.Purchase;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class AddCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Integer book_id = Integer.parseInt(request.getParameter("bookId"));
        //Integer user_id = Integer.parseInt(request.getParameter("userId"));
        
        Client customer= ClientBuilder.newClient();
        Response c=customer.target("http://localhost:8080/BookREST/rest/api/v1/book/"+book_id).
                        request().
                        get();
        Book book = c.readEntity(Book.class);
  

        HttpSession sesion = request.getSession();

     
        //PurchaseList puchase = new PurchaseList();
        //Response p=customer.target("http://localhost:8080/BookREST/rest/api/v1/purchase/"+user_id).
        //                request().
        //                get();
        //PurchaseList purchase =p.readEntity(PurchaseList.class);
        //System.out.println("Id LIBRO CARRITO: " + book);
        if (sesion.getAttribute("username") != null) {
            BookList books = new BookList();
            List<Book> aux=(List<Book>) sesion.getAttribute("carrito");

            if(aux==null){
                books.setBooks(new ArrayList<>());
                books.getBooks().add(book);
            }else{
                books.setBooks(aux);
                books.getBooks().add(book);
            }

            sesion.setAttribute("carrito", books.getBooks());

            ServletContext context = request.getSession().getServletContext();
            context.getRequestDispatcher("/carrito.jsp").forward(request, response);     
        }else{
            request.setAttribute("book", book);
            ServletContext context = request.getSession().getServletContext();
            context.getRequestDispatcher("/login.jsp").forward(request, response);
        }

       
                
    }
}
