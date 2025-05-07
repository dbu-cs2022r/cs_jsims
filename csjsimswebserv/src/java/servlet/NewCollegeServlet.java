package servlet;

import domain.College;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import service.CollegeService;
import service.ICollegeService;

@WebServlet(name = "NewCollegeServlet", urlPatterns = {"/NewCollegeServlet"})
public class NewCollegeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getNewCollegePage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            College college = new College();
            ICollegeService service = new CollegeService();
            college.setName(name);
            var isSaved = service.register(college);
            if (isSaved) {
                request.setAttribute("college", name);
                getSuccessPage(request, response);
            }
            getNewCollegePage(request, response);
        } catch (SQLException ex) {
            response.getWriter().println("Sorry, try again. Something went wrong." + ex.getMessage());
        }
    }

    private void getNewCollegePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO generate create new college registration page */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>New College Registration - J-Sims</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div><h1 style=\"text-align:center;\">CS J-Sims</h1></div>");
            out.println("<hr/>");
            out.println("<h2>Register New College</h2>");
            out.println("<hr/>");
            out.println("<form action=\"NewCollegeServlet\" method=\"post\">");
            out.println("College: <input type=\"text\" name=\"name\" required >");
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
            out.println("<hr/>");
            out.println("<a href=\"index.html\">Back to home</a>");
            out.println("</body>");
            out.println("</html> ");
        }
    }

    private void getSuccessPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO generate success message page */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>New College Registration</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(" <div><h1 style=\"text-align:center;\">CS J-Sims</h1></div>");
            out.println(" <hr/>");
            out.println("<h2>" + request.getAttribute("college") + "</h2>");
            out.println("<h2 style=\"color:green;\">College record saved successfully.</h2>");
            out.println(" <hr/>");
            out.println("""
                     <a href="index.html">Back to home</a> | 
                     <a href="NewCollegeServlet">Create another</a>
           """);
            out.println("</body>");
            out.println("</html> ");
        }
    }

}
