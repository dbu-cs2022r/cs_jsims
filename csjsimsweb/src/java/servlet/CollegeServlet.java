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
import java.util.logging.Level;
import java.util.logging.Logger;
import service.CollegeService;
import service.ICollegeService;

@WebServlet(name = "CollegeServlet", urlPatterns = {"/CollegeServlet"})
public class CollegeServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("CollegeServlet on init");
    }

    public void service() {
        System.out.println("CollegeServlet on service");
    }

    @Override
    public void destroy() {
        System.out.println("CollegeServlet on destroy");
    }

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
                /* TODO List available colleges */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>College List Servlet - J-Sims</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div><h1 style=\"text-align:center;\">CS J-Sims</h1></div>");
                out.println(" <hr/>");
                out.println("<h2 style=\"color:green;\">List of available Colleges</h2>");
                out.print("<hr/>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>No.</th>");
                out.println("<th align=\"center\">College</th>");
                out.println("</tr>");
                int i = 1;
                for (College college : colleges) {
                    out.println("<tr>");
                    out.println("<td>" + i + "</td>");
                    out.println("<td>" + college.getName() + "</td>");
                    out.println(" </tr>");
                    i++;
                }

                out.println("</table>");
                out.print("<hr/>");
                out.print("<a href=\"index.html\">Back to home</a>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CollegeServlet.class.getName()).log(Level.SEVERE, ex.getMessage());
            response.getWriter().println("Sorry, try again. Something went wrong." + ex.getMessage());
        }
    }

    private void addCollege(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
