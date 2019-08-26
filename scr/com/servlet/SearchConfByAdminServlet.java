package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Conference.ConferenceAttr;
import Factor.AdministratorFactorImp;
import Factor.Factor;

/**
 * Servlet implementation class SearchByAdminServlet
 */
@WebServlet("/SearchByAdminServlet")
public class SearchConfByAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchConfByAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("123");
		String req = request.getParameter("req");
		String str = request.getParameter("str");
		AdministratorFactorImp adminFactor = new AdministratorFactorImp();
		System.out.println(req+" "+ str);
		ArrayList<ConferenceAttr> confList = adminFactor.SearchConf(req, str);
		String but = request.getParameter("search");
		
		if(but.equals("search")){
			session.setAttribute("confList", confList);
			response.sendRedirect("Menu1/index.jsp");
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
