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

@WebServlet(name = "DepartmentServlet", urlPatterns = {"/DepartmentServlet"})
public class DepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getCollegesRequest(request, response);
    }

    protected void getCollegesRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            ICollegeService service = new CollegeService();
            var colleges = service.getAll();

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>College Servlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("""
                        <div><h1 style="text-align:center;">CS J-Sims</h1></div>
                        <hr/>
                        <h2>List of Departments</h2>
                        <hr/>
                         <form action="SearchDepartmentServlet" method="get">
                        College:
                        <select name="college" id="college" required>
                        """);
                for (College college : colleges) {
                    out.print("<option value=" + college.getId() + ">" + college.getName() + "</option>");
                }
                out.print("</select>");
                out.println("""
                            &nbsp;
                        <input type="submit" value="Search">
                        </form>
                        """);
                out.print("<hr/>");
                out.print("<a href=\"index.html\">Back to home</a>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException ex) {
            response.getWriter().println("Sorry, try again. Something went wrong." + ex.getMessage());
        }
    }

}
