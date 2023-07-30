import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadDataServlet")
public class DownloadDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the username parameter from the request
        String name = request.getParameter("name");
        String certificate_type = request.getParameter("certificate_type");

        // Set up the database connection
        try 
//        (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testsms?useSSL=false","root","root")) 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testsms?useSSL=false","root","root");
            // Execute the SQL query to get the data for the specified user
            String query = "SELECT uname, udob, uemail, mobile, uschool FROM certificates WHERE uname = ?";
            PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, name);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    // Create a StringBuilder to hold the HTML content
                	 StringBuilder content = new StringBuilder();
                	 if (certificate_type == "Leaving Certificate") {
                     content.append("<!DOCTYPE html>");
                     content.append("<html>");
                     content.append("<head>");
                     content.append("<title>Downloaded Data</title>");
                    
                     content.append("<meta charset=\"UTF-8\">");
                     content.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
                     content.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
                     content.append("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
                     content.append("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>");
                     content.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
                     content.append("<script type=\"text/javascript\" src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>");
                     content.append("<script type=\"text/javascript\" src=\"https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>");
                     content.append("<script type=\"text/javascript\">function googleTranslateElementInit() { new google.translate.TranslateElement({pageLanguage: 'en'}, 'google_translate_element'); }</script>");
                     content.append("</head>");
                     content.append("<body>");

                    // Create a form to display the data
                     content.append("<div class=\"container\">");
//                     content.append("<h2>User Information</h2>");
                     content.append("<h1>").append(certificate_type).append("</h1>");
                     content.append("<form>");
                     content.append("<div class=\"form-group\">");
                     content.append("<label for=\"uname\">Name:</label>");
                     content.append("<input type=\"text\" class=\"form-control\" id=\"uname\" name=\"uname\" value=\"" + resultSet.getString("uname") + "\">");
                     content.append("</div>");
                     content.append("<div class=\"form-group\">");
                     content.append("<label for=\"udob\">Date of Birth:</label>");
                     content.append("<input type=\"text\" class=\"form-control\" id=\"udob\" name=\"udob\" value=\"" + resultSet.getString("udob") + "\">");
                     content.append("</div>");
                     content.append("<div class=\"form-group\">");
                     content.append("<label for=\"uemail\">Email:</label>");
                     content.append("<input type=\"text\" class=\"form-control\" id=\"uemail\" name=\"uemail\" value=\"" + resultSet.getString("uemail") + "\">");
                     content.append("</div>");
                     content.append("<div class=\"form-group\">");
                     content.append("<label for=\"mobile\">Mobile:</label>");
                     content.append("<input type=\"text\" class=\"form-control\" id=\"mobile\" name=\"mobile\" value=\"" + resultSet.getString("mobile") + "\">");
                     content.append("</div>");
                     content.append("<div class=\"form-group\">");
                     content.append("<label for=\"uschool\">School name:</label>");
                     content.append("<input type=\"text\" class=\"form-control\" id=\"uschool\" name=\"uschool\" value=\"" + resultSet.getString("uschool") + "\">");
                     content.append("<div id=\"google_translate_element\"></div>");
                     content.append("</div>");
                     content.append("</form>");
                     content.append("</div>");
                     content.append("</body>");
                     content.append("</html>");
} else {
	content.append("<!DOCTYPE html>");
    content.append("<html>");
    content.append("<head>");
    content.append("<title>Downloaded Data</title>");
   
    content.append("<meta charset=\"UTF-8\">");
    content.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
    content.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
    content.append("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
    content.append("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>");
    content.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
    content.append("<script type=\"text/javascript\" src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>");
    content.append("<script type=\"text/javascript\" src=\"https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>");
    content.append("<script type=\"text/javascript\">function googleTranslateElementInit() { new google.translate.TranslateElement({pageLanguage: 'en'}, 'google_translate_element'); }</script>");
    content.append("</head>");
    content.append("<body>");

   // Create a form to display the data
    content.append("<div class=\"container\">");
//    content.append("<h2>User Information</h2>");
    content.append("<h1>").append(certificate_type).append("</h1>");
    content.append("<form>");
    content.append("<div class=\"form-group\">");
    content.append("<label for=\"uname\">Name:</label>");
    content.append("<input type=\"text\" class=\"form-control\" id=\"uname\" name=\"uname\" value=\"Template2\"  >");
    content.append("</div>");
    content.append("<div class=\"form-group\">");
    content.append("<label for=\"udob\">Date of Birth:</label>");
    content.append("<input type=\"text\" class=\"form-control\" id=\"udob\" name=\"udob\" value=\"" + resultSet.getString("udob") + "\">");
    content.append("</div>");
    content.append("<div class=\"form-group\">");
    content.append("<label for=\"uemail\">Email:</label>");
    content.append("<input type=\"text\" class=\"form-control\" id=\"uemail\" name=\"uemail\" value=\"" + resultSet.getString("uemail") + "\">");
    content.append("</div>");
    content.append("<div class=\"form-group\">");
    content.append("<label for=\"mobile\">Mobile:</label>");
    content.append("<input type=\"text\" class=\"form-control\" id=\"mobile\" name=\"mobile\" value=\"" + resultSet.getString("mobile") + "\">");
    content.append("</div>");
    content.append("<div class=\"form-group\">");
    content.append("<label for=\"uschool\">School name:</label>");
    content.append("<input type=\"text\" class=\"form-control\" id=\"uschool\" name=\"uschool\" value=\"" + resultSet.getString("uschool") + "\">");
    content.append("<div id=\"google_translate_element\"></div>");
    content.append("</div>");
    content.append("</form>");
    content.append("</div>");
    content.append("</body>");
    content.append("</html>");
}

                    

                    

                  // Set the response content type and headers
                     
                     response.setContentType("text/html");
                     response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(certificate_type + ".html", StandardCharsets.UTF_8.toString()));
                     response.setContentLength(content.length());
//                     response.setHeader("Content-Disposition", "attachment;filename=downloaded_data.html");
//                     response.setContentLength(content.length());

                    // Write the HTML content to the response output stream
                    OutputStream out = response.getOutputStream();
                    out.write(content.toString().getBytes());
                    out.flush();
                    out.close();
                } else {
                    // User not found in the database
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
                }
            
        } catch (SQLException | ClassNotFoundException e) {
            // Handle any SQL errors
            e.printStackTrace();
        }
    }
}