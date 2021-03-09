package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청주소 가져오기
		System.out.println("Homecontroller");
		String url = request.getRequestURI();
		
		String viewname = null;
		
		
		if(url.contains("main.mvc")) {
			//System.out.println("main요청");
			viewname = "main.jsp";
		}
		else if(url.contains("test2.mvc")) {
			//System.out.println("test2");
			int result = Test2Service.minus(request);
			request.setAttribute("result", result);
			
			viewname = "test2.jsp";
			
		}
		else if(url.contains("test1.mvc")) {
			//System.out.println("test1");

			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			
			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			
			int result = number1 + number2;
			
			request.setAttribute("result", result);
			
			viewname = "test1.jsp";
			
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewname);
		dis.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
