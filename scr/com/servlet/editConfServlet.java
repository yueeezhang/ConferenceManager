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
import Person.UserAttr;

/**
 * Servlet implementation class editConfServlet
 */
@WebServlet("/editConfServlet")
public class editConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editConfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("123");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		AdministratorFactorImp adminFactor = new AdministratorFactorImp();
		
		ConferenceAttr conf_old = (ConferenceAttr)session.getAttribute("conf");
		
		String CName = request.getParameter("Cname");
		String StartTime = request.getParameter("Starttime");
		String EndTime = request.getParameter("Endtime");
		int MemLimit = Integer.parseInt(request.getParameter("Memlimit"));
		String City = request.getParameter("city");
		String Organizer = request.getParameter("Organizer");
		String Tel = request.getParameter("tel");
		String Email = request.getParameter("Emails");
		String Inf = request.getParameter("information");
		String Addr = request.getParameter("address");
		String Category = request.getParameter("category");
		String save = request.getParameter("save");
		String backid = request.getParameter("backid");
		String del = request.getParameter("del");
		int CID = -1;
		if(conf_old!=null)
			CID = conf_old.GetCID();
		if(save != null){
			ConferenceAttr conf = new ConferenceAttr(CID,CName,StartTime,City,0,EndTime
				,Tel,Email,Organizer,Addr,Inf,'0',MemLimit);
			conf.SetCategory(Category);
			adminFactor.EditConf(conf);
			ArrayList<ConferenceAttr> confList = adminFactor.ShowAllConf();
			
			session.setAttribute("confList", confList);
			response.sendRedirect("Menu1/index.jsp");
			return;
		}
		if(backid != null){
			ArrayList<ConferenceAttr> confList = adminFactor.ShowAllConf();
			session.setAttribute("confList", confList);
			response.sendRedirect("Menu1/index.jsp");
			return;
		}
		if(del != null){
			adminFactor.DelConf(CID);
			ArrayList<ConferenceAttr> confList = adminFactor.ShowAllConf();
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
