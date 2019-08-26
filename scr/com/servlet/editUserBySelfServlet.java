package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Factor.AdministratorFactorImp;
import Factor.UserFactorImp;
import Person.UserAttr;

/**
 * Servlet implementation class editUserBySelfServlet
 */
@WebServlet("/editUserBySelfServlet")
public class editUserBySelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUserBySelfServlet() {
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
		System.out.println("hello hello helllo warwearqwaerq");
		HttpSession session = request.getSession();
		AdministratorFactorImp adminFactor = new AdministratorFactorImp();
		UserFactorImp userFactor = new UserFactorImp();
		UserAttr user_old = (UserAttr)session.getAttribute("user");
		
		int UID = user_old.GetUID();
		String username = request.getParameter("Uname");
		String pwd = request.getParameter("password");
		String Age = request.getParameter("Uage");
		int age = 0;
		if(Age != null){
			age = Integer.parseInt(Age);
		}
		String tel = request.getParameter("Tel");
		String Email = request.getParameter("Email");
		String truename = request.getParameter("Rname");
		String Sex = request.getParameter("Usex");
		char sex = Sex.toCharArray()[0];
		String save = request.getParameter("save");
		String backid = request.getParameter("backid");
		String del = request.getParameter("del");
		if(save != null){
			UserAttr user = new UserAttr(UID,username,truename,tel,
					sex,age,Email,pwd);
			userFactor.EditPersonalData(user);
			response.sendRedirect("User2/index.jsp");
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
