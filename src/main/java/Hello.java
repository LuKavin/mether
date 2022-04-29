import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource dataSource = null;
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/DBmether");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from JOB_TYPE");
			ResultSet resultSet = preparedStatement.executeQuery();
			PrintWriter printWriter = response.getWriter();
			){
			while(resultSet.next()) {
				final String job_typename = resultSet.getString("job_typename");
						printWriter.println(job_typename);
		}
			printWriter.flush();
		}catch (Exception e) {
				e.printStackTrace();
		}
			
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
