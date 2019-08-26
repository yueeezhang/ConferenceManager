package com.servlet;
/*
 * 管理员修改用户信息界面
 */
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
import Factor.UserFactor;
import Factor.UserFactorImp;
import Person.UserAttr;

/**
 * Servlet implementation class editUserServlet
 */
@WebServlet("/editUserServlet")
public class editUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUserServlet() {
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
		UserFactorImp userFactor = new UserFactorImp();
		UserAttr user_old = (UserAttr)session.getAttribute("user");
		
		int UID = user_old.GetUID();
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String Age = request.getParameter("age");
		int age = 0;
		if(Age != null){
			age = Integer.parseInt(Age);
		}
		String tel = request.getParameter("Tel");
		String Email = request.getParameter("email");
		String truename = request.getParameter("realname");
		String Sex = request.getParameter("sex");
		char sex = Sex.toCharArray()[0];
		String save = request.getParameter("save");
		String backid = request.getParameter("backid");
		String del = request.getParameter("del");
		if(save != null){
			UserAttr user = new UserAttr(UID,username,truename,tel,
					sex,age,Email,pwd);
			userFactor.EditPersonalData(user);
			ArrayList<UserAttr> userList = adminFactor.ShowAllUser();
			session.setAttribute("userList", userList);
			response.sendRedirect("User1/index.jsp");
			return;
		}
		if(backid != null){

			ArrayList<UserAttr> userList = adminFactor.ShowAllUser();
			session.setAttribute("userList", userList);
			response.sendRedirect("User1/index.jsp");
			return;
		}
		if(del != null){
			adminFactor.DelUser(user_old);
			ArrayList<UserAttr> userList = adminFactor.ShowAllUser();
			session.setAttribute("userList", userList);
			response.sendRedirect("User1/index.jsp");
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
