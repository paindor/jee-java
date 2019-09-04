package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =null;
		String jspName = "";
		System.out.println(request.getParameter("action"));
		switch(request.getParameter("action")) {
		case "move":
		//	System.out.println(String.format(Constants.VIEW_PATH , "customer", 
		//					request.getParameterValues("dest")));
			request.getRequestDispatcher(
					String.format(Constants.VIEW_PATH , "customer", 
							request.getParameter("dest"))).
			forward(request, response);
			break;
			
		
		case "login":
			break;
		case "join":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			CustomerBean param = new CustomerBean();
			param.setCredit(credit);
			param.setId(id);
			param.setPw(pw);
			param.setName(name);
			param.setSsn(ssn);
			//System.out.println("회원정보:" + param.toString());
			MemberService service = new MemberServiceImpl();
			//service.join(param);
			System.out.println(request.getParameter("action"));
			request.getRequestDispatcher(String.format(Constants.VIEW_PATH , "customer", 
							request.getParameter("dest"))).
			forward(request, response);
			
			
				break;
		}
		
		System.out.println("맥락이 맞아서 도착234");
		
		
		
		/**
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
