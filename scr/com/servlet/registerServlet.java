package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Factor.Factor;
import Factor.UserFactor;
import Factor.UserFactorImp;
import Person.PersonAttr;
import Person.UserAttr;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		Factor factor = Factor.GetInstance();
		UserFactorImp userFactor = new UserFactorImp();
		
		
		HttpSession session = request.getSession();
		
		String req = request.getParameter("finish");
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String Age = request.getParameter("age");
		int age = 0;
		if(Age != null){
			age = Integer.parseInt(Age);
		}
		String tel = request.getParameter("tele");
		String Email = request.getParameter("E-mail");
		String Sex = request.getParameter("sex");
		char sex = 'f';
		if(Sex !=null)sex = Sex.toCharArray()[0];
		String truename = request.getParameter("truename");
		int UID = userFactor.GetNowUID()+1;
		if(req.equals("fi")){
			UserAttr user = new UserAttr(UID,username,truename,tel,
					sex,age,Email,pwd);
			userFactor.InsertUser(user);
			String reg = "login.jsp";
			response.sendRedirect(reg);
			return ;
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
