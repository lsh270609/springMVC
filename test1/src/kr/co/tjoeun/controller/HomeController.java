package kr.co.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tjoeun.model.Test2Service;

@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUid = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController");
		System.out.println(request.getRequestURI());
		String viewName = "/WEB-INF/main.jsp";
		
		if(request.getRequestURI().contains("main.mvc")) {
			System.out.println("메인 요청");
		} else if(request.getRequestURI().contains("test1.mvc")) {
			System.out.println("test1 요청");
			viewName = "/WEB-INF/test1.jsp";
		} else if(request.getRequestURI().contains("test2.mvc")) {
			System.out.println("test2 요청");
			viewName = "/WEB-INF/test2.jsp";
		}
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		if(num1!=null && num2!=null) {
//			int sum = Integer.parseInt(num1)+Integer.parseInt(num2);
//			request.setAttribute("sum", sum);
			Test2Service tService = new Test2Service();
			int sum = tService.sum(request);
			System.out.println(sum);
			request.setAttribute("sum", sum);

		}
		
		
		
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}