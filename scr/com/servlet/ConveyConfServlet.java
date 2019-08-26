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
import Factor.UserFactorImp;
import Person.UserAttr;

/**
 * Servlet implementation class ConveyEditConfServlet
 */
@WebServlet("/ConveyEditConfServlet")
public class ConveyConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConveyConfServlet() {
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
		
		String cid = request.getParameter("edit");
		if(cid!=null){
			ConferenceAttr conf = adminFactor.ViewConfDetail(Integer.parseInt(cid));
			session.setAttribute("conf", conf);
			response.sendRedirect("Menu1/edit.jsp");
			return;
		}
		String CID = request.getParameter("viewConf");
		if(CID!=null){
			ConferenceAttr conf = adminFactor.ViewConfDetail(Integer.parseInt(CID));
			session.setAttribute("conf", conf);
			response.sendRedirect("Menu1/see.jsp");
			return;
		}
		String Cid = request.getParameter("viewApply");
		if(Cid!=null){
			
			ArrayList<ApplyDetailAttr> applyList = adminFactor.ViewApplyDetail(Integer.parseInt(Cid));
			session.setAttribute("applyList", applyList);
			ConferenceAttr conf = adminFactor.SearchConf(Integer.parseInt(Cid));
			session.setAttribute("conf", conf);
			response.sendRedirect("Menu1/people.jsp");
			return;
		}
		String _cid = request.getParameter("view1");
		if(_cid != null){
			ConferenceAttr conf = adminFactor.SearchConf(Integer.parseInt(_cid));
			session.setAttribute("conf", conf);
			session.setAttribute("user", session.getAttribute("user"));
			response.sendRedirect("Menu2/see.jsp");
			return;
		}
		String cancle_cid = request.getParameter("view2");
		if(cancle_cid != null){
			UserAttr user = (UserAttr)session.getAttribute("user");
			UserFactorImp userFactor= new UserFactorImp();
			ConferenceAttr conf = adminFactor.SearchConf(Integer.parseInt(cancle_cid));
			userFactor.CancleApply(user.GetUID(), conf.GetCID(),conf);
			
			response.sendRedirect("Attend2/index.jsp");
			return;
		}
		String view_cid = request.getParameter("viewer");
		if(view_cid != null){
			ConferenceAttr conf = adminFactor.SearchConf(Integer.parseInt(view_cid));
			session.setAttribute("conf", conf);
			session.setAttribute("user", session.getAttribute("user"));
			response.sendRedirect("Menu2/viewConf.jsp");
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
