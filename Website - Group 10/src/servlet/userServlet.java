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
import dao.EachDayDao;
import model.EachDay;
import dao.VietNamProvinceDao;
import model.VietNamProvinces;
import dao.WorldGeneralDao;
import model.WorldGeneral;


@WebServlet("/user/*")
public class userServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private CountryDao countryDao;
	private EachDayDao eachDayDao;
	private VietNamProvinceDao provinceDao;
	private WorldGeneralDao worldGeneralDao;
	
	@Override
	public void init() throws ServletException {
		try {
			countryDao = new CountryDao();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eachDayDao = new EachDayDao();
		provinceDao = new VietNamProvinceDao();
		worldGeneralDao = new WorldGeneralDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doGet(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getPathInfo();
		
		if(action == null || action.isEmpty()) {
			listCountry(request, response);
		}else {
			switch (action) {
			case "/province":
				listVietNamProvinces(request, response);
				break;
			case "/eachday":
				try {
					listEachDay(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/world":
				worldGeneral(request, response);
				break;
			default:
				listCountry(request, response);
				break;
			}
		}
	}

	private void listVietNamProvinces(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<VietNamProvinces> listProvinces = provinceDao.selectAllProvinces();
		request.setAttribute("listProvinces", listProvinces);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user-list-province.jsp");
		dispatcher.forward(request, response);
	}

	private void worldGeneral(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<WorldGeneral> listWorld = worldGeneralDao.getHistoricalWorldGeneral();
		request.setAttribute("listWorld", listWorld);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user-list-world.jsp");
		dispatcher.forward(request, response);
	}

	private void listEachDay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<EachDay> listEachDay = eachDayDao.getAllVietNamDays();
		request.setAttribute("listEachDay", listEachDay);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user-list-each-day.jsp");
		dispatcher.forward(request, response);
	}

	private void listCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Country> listCountries = countryDao.selectAllCountry();
		request.setAttribute("listCountries", listCountries);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/user-list-country.jsp");
		dispatcher.forward(request, response);
	}
}
