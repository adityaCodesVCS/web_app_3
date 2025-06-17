package com.web_app_3.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.web_app_3.service.AddNumbers;

@WebServlet("/addController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    public AddController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Num1 = Integer.parseInt(request.getParameter("num1"));
		int Num2 = Integer.parseInt(request.getParameter("num2"));
		//'Controller' takes the data(num1, num2) from 'View' after 'View' calls the 'Controller'.
		
		AddNumbers a = new AddNumbers(); //
		int result = a.add(Num1, Num2); 
		//'Controller' call 'Model' & give data to it & result of addition that done in 'Model' get back to 'Controller' as 'result'.
		
		request.setAttribute("result", result); //Before I submit 'request' object to View(.jsp), I'll create variable as "result" in 'request' object and store 'result' in that variable.
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp"); //Here 'rd' pointing to .jsp page.
		rd.forward(request, response); //Now it will load our .jsp page & request and response object addresses given to implict object of JSP.
		//View take that Data('result') from Controller and shown on webPage.
		
		//doGet(request, response);
	}
}
