package servlet;

import domain.College;
import domain.Department;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import service.CollegeService;
import service.DepartmentService;
import service.ICollegeService;
import service.IDepartmentService;

/**
 *
 * @author ChalewT
 */
@WebServlet(name = "SearchDepartmentServlet", urlPatterns = {"/SearchDepartmentServlet"})
public class SearchDepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getDepartmentsRequest(request, response);
    }

    private void getDepartmentsRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            ICollegeService service = new CollegeService();
            IDepartmentService deptService = new DepartmentService();
            var colleges = service.getAll();
            int collegeId = Integer.parseInt(request.getParameter("college"));
            var college = new College();
            for (College c : colleges) {
                if (collegeId == c.getId()) {
                    college.setId(collegeId);
                    college.setName(c.getName());
                    break;
                }
            }
            var departments = deptService.getByCollegeId(collegeId);
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Department Servlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("""
                        <div><h1 style="text-align:center;">CS J-Sims</h1></div>
                        <hr/>
                         """);
                out.print("<h2>Departments in <strong>" + college.getName() + "</strong></h2>");
                out.println("<hr/>");
                out.println("<ol>");
                for (Department department : departments) {
                    out.print("<li>" + department.getName() + "</li>");
                }
                out.print("</ol>");
                out.print("<hr/>");
                out.print("""
                          <a href="index.html">Back to home</a> | 
                          <a href="DepartmentServlet">Search another</a>""");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException | NumberFormatException ex) {
            response.getWriter().println("Sorry, try again. Something went wrong." + ex.getMessage());
        }
    }

}
