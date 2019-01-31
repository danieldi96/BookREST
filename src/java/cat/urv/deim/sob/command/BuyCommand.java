package cat.urv.deim.sob.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import BookREST.entities.Purchase;
import BookREST.entities.BookList;
import BookREST.entities.Book;

public class BuyCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        BookList booklist = new BookList();
        booklist.setBooks((List<Book>) sesion.getAttribute("carrito"));
        Integer id= Integer.parseInt((String) sesion.getAttribute("id"));
             
        booklist.getBooks().stream().map((Book) -> {
            Purchase purchase=new Purchase();
            //purchase.setIdComanda(Book.getPrice());
            //purchase.setIdClient(id);
            //purchase.setIdBook(Book.getId());
            return purchase;
        }).forEachOrdered((comanda) -> {
            javax.ws.rs.client.Client client = ClientBuilder.newClient();
            
            client.target("http://localhost:8080/BookREST/rest/api/v1/purchase")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(comanda), String.class);
        });
        float totalPrice=0;
        
        for(Book Book: booklist.getBooks())
            totalPrice+=Book.getPrice();
        
        BookList BookList=new BookList();
        sesion.setAttribute("carrito", BookList.getBooks());
        
        request.setAttribute("totalPrice", totalPrice);
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/recibo.jsp").forward(request, response);
    }
}
