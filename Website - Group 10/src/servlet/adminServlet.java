package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CountryDao;
import model.Country;

@WebServlet("/admin")
public class adminServlet extends HttpServlet{
	private CountryDao countryDao;
	public void init() {
		try {
			countryDao = new CountryDao();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getServletPath();
		
	}
	private void listCountries(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Country> listCountry = countryDao.selectAllCountry();
		request.setAttribute("listCountry", listCountry);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/admin-homepage.jsp");
		dispatcher.forward(request, response);
	}
}
