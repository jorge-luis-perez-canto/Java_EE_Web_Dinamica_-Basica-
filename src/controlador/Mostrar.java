package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class Mostrar
 */
@WebServlet("/Mostrar")
public class Mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection conexion = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Mostrar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter mensaje = response.getWriter();

		mensaje.println("<!DOCTYPE html>" 
				+ "<html>" 
				+ "<head>"
				+ "<style> \r\n"
				+ "	body {\r\n"
				+ "		background: grey;\r\n"
				+ "	}\r\n"
				+ "	table {\r\n"
				+ "		background: white;\r\n"
				+ "	}\r\n"
				+ "</style>" 
				+ "</head>" 
				+ "<body>");

		mensaje.println("<table border=1>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?serverTimezone=UTC",
					"agendausuario", "agendap");
			Statement s = conexion.createStatement();
			ResultSet resultado = s.executeQuery("SELECT * FROM entradas");

			while (resultado.next()) {
				mensaje.println("<tr> <td>" + resultado.getObject("identrada") + "</td> <td>"
						+ resultado.getObject("nombre") + "</td> <td>" + resultado.getObject("email") + "</td> <td>"
						+ resultado.getObject("fecha") + "</td> </tr>");
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		mensaje.println("</table>"
				+ "</body>"
				+ "</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
