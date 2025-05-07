package servelet;

import domain.College;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.CollegeService;
import service.ICollegeService;

@WebServlet(name = "CollegeServlet", urlPatterns = {"/CollegeServlet"})
public class CollegeServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getColleges(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        addCollege(request, response);
    }

      protected void getColleges(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ICollegeService service = new CollegeService();
            var colleges = service.getAll();

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet CollegeServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 style=\"color:green;\">List of Available Colleges</h1>");

                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Code</th>");
                out.println("<th>College</th>");
                out.println("</tr>");

                for (College college : colleges) {
                    out.println("<tr>");
                    out.println("<td>" + college.getId() + "<td>");
                    out.println("<td>" + college.getName() + "<td>");
                    out.println(" </tr>");
                }

                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CollegeServlet.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }

    private void addCollege(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
