package lt.viko.eif.neinoris.students.client;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class JettyAnswerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Student student = searchForStudent(request.getParameter("fname"));
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<p>Student name: "+ student.getName() +"</p>");
        out.println("<p>Student surname: "+ student.getSurname() +"</p>");
        out.println("<p>Student age: "+ student.getAge() +"</p>");
        out.println("<form action=\"pdf\" method=\"POST\">");
        out.println("<button type=\"submit\" name=\"button1\">Test</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().contains("/static")){
            servePdfFile(response);
        }else{
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println(" <a href='/pdf/static' >Test pdf</a>");
            out.println("</body></html>");
        }
    }*/

    public Student searchForStudent(String name){
        StudentsPortService service = new StudentsPortService();
        StudentsPort port = service.getStudentsPortSoap11();
        GetStudentRequest request = new GetStudentRequest();
        request.setName(name);
        GetStudentResponse response = port.getStudent(request);

        Student student = response.getStudent();

        return student;
    }

    private void servePdfFile(HttpServletResponse response) throws IOException {
        String pdfFileName = "sample.pdf";

        File pdfFile = new File(pdfFileName);

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=" + pdfFileName);
        response.setContentLength((int) pdfFile.length());

        FileInputStream fileInputStream = new FileInputStream(pdfFileName);
        OutputStream responseOutputStream = response.getOutputStream();
        int bytes;
        while ((bytes = fileInputStream.read()) != -1){
            responseOutputStream.write(bytes);
        }
    }


}
