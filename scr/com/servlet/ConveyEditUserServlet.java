package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Conference.ApplyDetailAttr;
import Conference.ConferenceAttr;
import Factor.AdministratorFactorImp;
import Person.UserAttr;

/**
 * Servlet implementation class ConveyEditUserServlet
 */
@WebServlet("/ConveyEditUserServlet")
public class ConveyEditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConveyEditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		AdministratorFactorImp adminFactor = new AdministratorFactorImp();
		String name = request.getParameter("edit");
		if(name!=null){
			UserAttr user = adminFactor.SearchUser(name);
			System.out.println(user.GetUID());
			session.setAttribute("user", user);
			response.sendRedirect("User1/edit.jsp");
			return;
		}
		String viewApply = request.getParameter("viewApply");
		if(viewApply != null){
			int UID = Integer.parseInt(viewApply);
			ArrayList<ApplyDetailAttr> applyList = adminFactor.ViewUserApply(UID);
			session.setAttribute("ApplyList", applyList);
			response.sendRedirect("User1/people.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
