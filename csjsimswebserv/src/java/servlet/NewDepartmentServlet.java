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

@WebServlet(name = "NewDepartmentServlet", urlPatterns = {"/NewDepartmentServlet"})
public class NewDepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getCollegesRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int collegeId = Integer.parseInt(request.getParameter("college"));
            String name = request.getParameter("department");
            Department department = new Department();
            IDepartmentService service = new DepartmentService();
            department.setName(name);
            department.setCollegeId(collegeId);
            var saved = service.register(department);
            if (saved) {
                getDepartmentsRequest(request, response);
            }
            getCollegesRequest(request, response);
        } catch (SQLException ex) {
            response.getWriter().println("Sorry, try again. Something went wrong." + ex.getMessage());
        }
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
                out.println("<title>Department Servlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("""
                        <div><h1 style="text-align:center;">CS J-Sims</h1></div>
                        <hr/>
                        <h2>Register New Department</h2>
                        <hr/>
                         <form action="NewDepartmentServlet" method="post">
                        College:
                        <select name="college" id="college" required>
                        """);
                for (College college : colleges) {
                    out.print("<option value=" + college.getId() + ">" + college.getName() + "</option>");
                }
                out.print("</select>");
                out.println("""
                       <br><br>
                                 Department: 
                        <input type="text" name="department" required>
                        <input type="submit" value="Submit">
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
                          <a href="NewDepartmentServlet">Create another</a>
                        """);
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException | NumberFormatException ex) {
            response.getWriter().println("Sorry, try again. Something went wrong." + ex.getMessage());
        }
    }

}
