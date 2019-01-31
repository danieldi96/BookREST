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

public class AddCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String img = request.getParameter("img");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer assessment = Integer.parseInt(request.getParameter("assessment"));
    

        Book book = new Book();
        book.setBookId(id);
        book.setAuthor(author);
        book.setDescription(description);
        book.setImg(img);
        book.setPrice(price);
        book.setAssessment(assessment);
        book.setTitle(title);
        
        HttpSession sesion = request.getSession();

        if (sesion.getAttribute("usuario") != null) {
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
            context.getRequestDispatcher("/book.jsp").forward(request, response);
        }

        
    }
}
