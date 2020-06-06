package servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDao;

@WebServlet("/login/*")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	public void init() throws ServletException {
		userDao = new UserDao();
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
		
		
		switch (action) {
		case "/form":
			login(request, response);
			break;

		case "/check":
			try {
				checkLogin(request, response);
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
		}
	}
	

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/User/login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name = request.getParameter("username");
        String pass = request.getParameter("pass");
        if(isChecked(name, pass)) {
            response.sendRedirect(request.getContextPath()+"/country");
        }else{
        	response.sendRedirect(request.getContextPath()+"/login/form");
        }
	}
	
	private boolean isChecked(String name, String pass) throws SQLException, IOException {
		ArrayList<User> lstUser = userDao.searchUser(name);
		System.out.println(lstUser.toString());
		boolean result = false;
		String passA = null;
		try {
			passA = toHexString(pass);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(User a:lstUser) {
			if(a.getPassword().equalsIgnoreCase(passA)) {
				result = true;
				break;
			}
		}
		
		return result;
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
