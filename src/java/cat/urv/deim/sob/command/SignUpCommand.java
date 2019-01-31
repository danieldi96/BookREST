package cat.urv.deim.sob.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import BookREST.entities.Customer;

public class SignUpCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        
        Boolean existe=false;
        request.setAttribute("existe", existe);
        
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
