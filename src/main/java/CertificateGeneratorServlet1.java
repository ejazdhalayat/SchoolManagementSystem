import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CertificateGeneratorServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String certificateType = request.getParameter("certificateType");
        String certificateContent = generateCertificate(certificateType);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(certificateContent);
    }

    private String generateCertificate(String certificateType) {
        String certificateContent = "";

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testsms?useSSL=false", "root", "root");

            // Prepare the SQL statement
            String sql = "SELECT ucertificate_type FROM certificates WHERE certificate_type = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, certificateType);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if a row is found
            if (resultSet.next()) {
                // Retrieve the data_column value
                String dataColumn = resultSet.getString("ucertificate_type");

                // Use the data_column value in the certificate generation logic
                certificateContent = "<h1>" + certificateType.toUpperCase() + " Certificate</h1>";
                certificateContent += "<p>" + dataColumn + "</p>";
            }

            // Close the database resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return certificateContent;
    }
}
