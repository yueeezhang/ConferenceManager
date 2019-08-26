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
import Factor.Factor;
import Factor.UserFactorImp;
import Person.UserAttr;

/**
 * Servlet implementation class joinConfServlet
 */
@WebServlet("/joinConfServlet")
public class attendConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public attendConfServlet() {
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
		UserFactorImp userFactor = new UserFactorImp();
		AdministratorFactorImp adminFactor = new AdministratorFactorImp();
		String attend = request.getParameter("apply");
		if(attend == null){
			response.sendRedirect("Menu2/index.jsp");
			return;
		}
		int CID = Integer.parseInt(request.getParameter("CID"));
		int UID = Integer.parseInt(request.getParameter("UID"));
		int TrainNum = Integer.parseInt(request.getParameter("TrainNum"));
		String InvHead = request.getParameter("InvHead");
		String InvCon = request.getParameter("InvCon");
		String Hotel = request.getParameter("Hotel");
		String Remark = request.getParameter("Remark");
		if(attend != null){
			
			if(InvHead == null)InvHead = "нч";
			if(InvCon == null)InvCon = "нч";
			if(Remark == null) Remark = "нч";
			ApplyDetailAttr applyAttr = new ApplyDetailAttr(UID,CID,TrainNum
					,InvHead,InvCon,Hotel,Remark);
			ConferenceAttr conf = adminFactor.SearchConf(CID);
			userFactor.AttendMeeting(applyAttr,conf);
			//ArrayList<ConferenceAttr> confList = userFactor.ShowAllConf(UID);
			//session.setAttribute("confList", confList);
		}
		response.sendRedirect("Menu2/index.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
