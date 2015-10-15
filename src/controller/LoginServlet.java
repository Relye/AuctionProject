package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String whiteList = "[^0-9A-Za-z]";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = (String) request.getParameter("user");
		String password = (String) request.getParameter("password");

		if (!checkUserInput(username) || !checkUserInput(password)) {
			response.sendRedirect("/AuctionProject/Login.jsp");
		}

		else {
			if (checkLogin(username, password)) {
				Cookie loginCookie = new Cookie("user", username);
				loginCookie.setMaxAge(30 * 60);
				response.addCookie(loginCookie);
				response.sendRedirect("/AuctionProject/index.jsp");
			} else {
				response.sendRedirect("/AuctionProject/Login.jsp");
			}
		}
	}

	private boolean checkLogin(String username, String password) {
		//save all usernames from database in a list, check if username-input exists in list
		
		ArrayList<Object> userList = new ArrayList<Object>() /* Get all users from database, save as objects to reduce risk of sql-injection */;
		
		if(userList.contains(username)) {
			/* Get password of specific user */
		}
		
		
		
		if(password.equals(/*CHANGE THIS*/password/*CHANGE THIS*/)) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean checkUserInput(String inputText) {
		// check if string contains chars that is not whitelisted
		if (inputText.matches(whiteList)) {
			return true;
		} else {
			return false;
		}
	}
}
