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
 * Servlet implementation class addConfServlet
 */
@WebServlet("/addConfServlet")
public class addConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addConfServlet() {
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
		AdministratorFactorImp adminFactor = new AdministratorFactorImp();
		HttpSession session = request.getSession();
		
		int CID = adminFactor.GetNowCID()+1;
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
		System.out.println(Category);
		String Save = request.getParameter("save");
		String Back = request.getParameter("back");
		ArrayList<ConferenceAttr> confList = adminFactor.ShowAllConf();
		if(Save.equals("save")){
			ConferenceAttr conf = new ConferenceAttr(CID,CName,StartTime,City,0,EndTime
					,Tel,Email,Organizer,Addr,Inf,'0',MemLimit,Category);
			adminFactor.InsertConf(conf);
			session.setAttribute("confList", confList);
			response.sendRedirect("Menu1/index.jsp");
			return;
		}
		if(Back.equals("back")){
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
