package servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/manageaccount/*")
public class accountServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dao.UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getPathInfo();

		if(action == null || action.isEmpty()) {
			try {
				listUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				switch (action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertUser(request, response);
					break;
				case "/delete":
					deleteUser(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateUser(request, response);
					break;
				default:
					listUser(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDao.getAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-list-account.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-account-newform.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.getUserByID(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/ad-account-editform.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = null;
		try {
			password = toHexString(request.getParameter("password"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int age = Integer.parseInt(request.getParameter("age"));
		String dob = request.getParameter("dob");
		userDao.createUser(username, email, password, age, dob);
		response.sendRedirect("manageaccount");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = null;
		try {
			password = toHexString(request.getParameter("password"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int age = Integer.parseInt(request.getParameter("age"));
		String dob = request.getParameter("dob");
		userDao.updateUser(id,username, email, password, age, dob);
		response.sendRedirect("manageaccount");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("manageaccount");

	}
	
	/**
    *
    * @param s
    * @effects
    * @return hash-265 pass
    * @throws NoSuchAlgorithmException
    */
   private String toHexString(String s) throws NoSuchAlgorithmException {
       // Static getInstance method is called with hashing SHA
       MessageDigest md = MessageDigest.getInstance("SHA-256");
       byte[] hash = md.digest(s.getBytes(StandardCharsets.UTF_8));
       // Convert byte array into signum representation
       BigInteger number = new BigInteger(1, hash);
       // Convert message digest into hex value
       StringBuilder hexString = new StringBuilder(number.toString(16));
       // Pad with leading zeros
       while (hexString.length() < 32)
       {
           hexString.insert(0, '0');
       }
       return hexString.toString();
   }
}
