package lt.viko.eif.neinoris.students.client;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class JettyMainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Student student = searchForStudent("Nikolas");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<p>Student search</p>");
        out.println("<form action=\"pdf\" method=\"POST\">");
        out.println("<input type=\"text\" id=\"fname\" name=\"fname\">");
        out.println("<button type=\"submit\" name=\"button1\">Search</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = searchForStudent("Nikolas");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<p>"+ student.getSurname() +"</p>");
        out.println("<p>"+ student.getSurname() +"</p>");
        out.println("<form action=\"pdf\" method=\"POST\">");
        out.println("<button type=\"submit\" name=\"button1\">Test</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }*/


}
