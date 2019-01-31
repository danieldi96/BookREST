package cat.urv.deim.sob.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import BookREST.entities.BookList;

public class SearchCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 1. process the request
        String name=request.getParameter("name");
        
        Client customer= ClientBuilder.newClient();
        String ll=customer.target("http://localhost:8080/BookREST/rest/api/v1/book?sort=price").
                        request().
                        get(String.class);
        
        BookList list=this.stringtoXML(ll);
        
        
        BookList searched=new BookList();
        searched.setBooks(list.getBooks().stream().filter(x->{
            String str=x.getTitle().toUpperCase();
            if(str.indexOf(name.toUpperCase())!=-1)
                return true;
            else
                return false;
                }).collect(Collectors.toList()));// 2. produce the view with the web result
        
        
        
            request.setAttribute("books", searched);
            ServletContext context = request.getSession().getServletContext();
            context.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    private BookList stringtoXML(String str){
        JAXBContext jaxbcontext;
        BookList list=null;
        try {
            jaxbcontext = JAXBContext.newInstance(BookList.class);
            Unmarshaller jaxbunmarshaller=jaxbcontext.createUnmarshaller();
            list=(BookList) jaxbunmarshaller.unmarshal(new StringReader(str));
            
        } catch (JAXBException ex) {
            Logger.getLogger(SearchCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
