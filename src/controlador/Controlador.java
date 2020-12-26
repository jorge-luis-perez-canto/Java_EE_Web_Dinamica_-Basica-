package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection conexion = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
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

		mensaje.println("Yo voy a recibir la información <br>");
		mensaje.println("El nombre que has enviado es: " + request.getParameter("nombre") + "<br>");
		mensaje.println("El email que has enviado es: " + request.getParameter("email") + "<br>");
		mensaje.println("La fecha que has enviado es: " + request.getParameter("fecha") + "<br>");

		try {
			// Class.forName("org.gjt.mm.mysql.Driver");
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?serverTimezone=UTC",
					"agendausuario", "agendap");
			Statement s = conexion.createStatement();
			s.executeUpdate("INSERT INTO entradas VALUES (null, '" + request.getParameter("nombre") + "', '"
					+ request.getParameter("email") + "', '" + request.getParameter("fecha") + "')");

			mensaje.println("Tu registro se ha guardado correctamente");
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

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
