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
        List<Book> carrito=(List<Book>) sesion.getAttribute("carrito");
        booklist.setBooks(carrito);
        
        float totalPrice_aux=0;
        for(Book book: booklist.getBooks())
        {
            totalPrice_aux+= book.getPrice();
        }
        Integer totalPrice = Math.round(totalPrice_aux);
        
        
        sesion.setAttribute("carrito", booklist.getBooks());
        
        request.setAttribute("totalPrice", totalPrice);

        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/recibo.jsp").forward(request, response);
    }
}
