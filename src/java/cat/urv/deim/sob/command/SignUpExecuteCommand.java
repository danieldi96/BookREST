package cat.urv.deim.sob.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import BookREST.entities.CustomerList;
import BookREST.entities.Customer;
import BookREST.entities.BookList;

public class SignUpExecuteCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String username=request.getParameter("user");
        
        Customer cli=new Customer();
        cli.setName(name);
        cli.setPassword(password);
        cli.setUser(username);
        
        CustomerList list=auxiliarLogin.llistaClients();
    
        List<Customer> custom= list.getCustomers().stream().filter(c->c.getUser().equals(username)).collect(Collectors.toList());
        
        if(custom.isEmpty()){
            AuxiliarSignUp.llistaCustomers(cli);
        
            HttpSession sesion = request.getSession();
            sesion.setAttribute("username", username);
            BookList booklist=new BookList();
            sesion.setAttribute("books", booklist.getBooks());
            ServletContext context = request.getSession().getServletContext();
            context.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else{
            Boolean existe=true;
            request.setAttribute("existe", existe);
            ServletContext context = request.getSession().getServletContext();
            context.getRequestDispatcher("/register.jsp").forward(request, response);
        }    
        
    }
}