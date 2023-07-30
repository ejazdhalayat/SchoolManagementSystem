import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CertificateGeneratorServlet")
public class CertificateGeneratorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String uemail = request.getParameter("email");
        String umobile = request.getParameter("mobile");
        String school = request.getParameter("school");
        String certificate_type = request.getParameter("certificate_type");

        // Render the certificate based on the certificate type
        String content = "<!DOCTYPE html>";
        content += "<html>";
        content += "<head>";
        content += "<title>" + certificate_type + "</title>";
        content += "</head>";
        content += "<body>";
        content += "<h1>" + certificate_type + "</h1>";
        content += "<p>Name: " + name + "</p>";
        content += "<p>Date of Birth: " + dob + "</p>";
        content += "<p>Email: " + uemail + "</p>";
        content += "<p>Mobile No: " + umobile + "</p>";
        content += "<p>School: " + school + "</p>";
        // Add more details based on the certificate type
        content += "</body>";
        content += "</html>";

        // Set the response content type and headers
        response.setContentType("text/html");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(certificate_type + ".html", StandardCharsets.UTF_8.toString()));
        response.setContentLength(content.length());

        // Write the certificate content to the response output stream
        OutputStream out = response.getOutputStream();
        out.write(content.getBytes());
        out.flush();
        out.close();
    }
}
