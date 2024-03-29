package cat.urv.deim.sob.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import BookREST.entities.Customer;
import BookREST.entities.CustomerList;
import BookREST.entities.BookList;

public class LoginExecuteCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Boolean loginfail=true;
        
        // 1. process the request
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        
        
        CustomerList list = auxiliarLogin.llistaClients();
                        
        List<Customer> cli = null;
        Customer selected = null;
        if (list != null){
            cli = list.getCustomers().stream().filter(c->c.getUser().equals(username)).collect(Collectors.toList());
            
            if(!cli.isEmpty()){
                for (Customer c: cli){
                    if(c.getPassword().equals(password)){
                        selected = c;
                        loginfail=false;
                    }
                }
            }
        }
        
        
        if(!loginfail){
            
            HttpSession sesion = request.getSession();
            sesion.setAttribute("username", username);
            sesion.setAttribute("customerId", selected.getCustomerId().toString());
            BookList books=new BookList();
            sesion.setAttribute("books", books.getBooks());
            ServletContext context = request.getSession().getServletContext();
            context.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            request.setAttribute("login", loginfail);
            ServletContext context = request.getSession().getServletContext();
            context.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
        
    }

}
