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
import Factor.UserFactorImp;
import Person.AdminAttr;
import Person.PersonAttr;
import Person.UserAttr;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		String vcode = (String)session.getAttribute("vcode");
		String veri = request.getParameter("verify");
		UserFactorImp userFactor = new UserFactorImp();
		AdministratorFactorImp adminFactor = new AdministratorFactorImp();
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String re = request.getParameter("regist");
		if(re!=null&&re.equals("reg")){
			String login_ = "register.jsp";
			response.sendRedirect(login_);
			return ;
		}
		PersonAttr person = userFactor.SearchPerson(username);
		ArrayList<UserAttr> userList = userFactor.ShowAllUser();
		System.out.println(vcode+" "+veri);
		if(person!=null){
			if(pwd.equals(person.GetPassword())){
				if((person.GetPermission() == '1')&& (vcode.equals(veri))){
					//session.setAttribute("admin", );
					ArrayList<ConferenceAttr> confList = adminFactor.ShowAllConf();
					String admin_login_suc = "index_admin.jsp";
					response.sendRedirect(admin_login_suc);
					session.setAttribute("confList", confList);
					session.setAttribute("userList", userList);
					return ;	
				}
				else if(vcode.equals(veri)){
					UserAttr user = userFactor.SearchUser(username);
				//	System.out.println("Ç°¶Ë"+user.GetUID());
					ArrayList<ConferenceAttr> confList = userFactor.ShowAllConf(user.GetUID());
					session.setAttribute("user", user);
					String user_login_suc = "index_user.jsp";
					response.sendRedirect(user_login_suc);
					session.setAttribute("confList", confList);
					session.setAttribute("userList", userList);
					return ;
				}
				
			}
		}
		String login_fail = "login.jsp";
		response.sendRedirect(login_fail);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
