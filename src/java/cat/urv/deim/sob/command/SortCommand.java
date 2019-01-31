package cat.urv.deim.sob.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import BookREST.entities.BookList;

public class SortCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 1. process the request
        String ordenar = request.getParameter("sort");

        Client customer = ClientBuilder.newClient();
        String ll = customer.target("http://localhost:8080/BookREST/rest/api/v1/book?sort=" + ordenar).
                request().
                get(String.class);

        BookList list = this.stringtoXML(ll);

        ServletContext context = request.getSession().getServletContext();
        request.setAttribute("books", list);
        context.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    private BookList stringtoXML(String str) {
        JAXBContext jaxbcontext;
        BookList list = null;
        try {
            jaxbcontext = JAXBContext.newInstance(BookList.class);
            Unmarshaller jaxbunmarshaller = jaxbcontext.createUnmarshaller();
            list = (BookList) jaxbunmarshaller.unmarshal(new StringReader(str));

        } catch (JAXBException ex) {
            Logger.getLogger(SortCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
