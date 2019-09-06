package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.command.Transfer;
import com.bank.web.command.Command;
import com.bank.web.command.MoveCommand;
import com.bank.web.command.Order;
import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

/*
 */
@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =null;
		MoveCommand cmd = null;
		
		
		String jspName = "";
		System.out.println(request.getParameter("action"));
		CustomerBean param = new CustomerBean();
		//MemberService ms = new MemberServiceImpl();
		MemberService service = new MemberServiceImpl();
		try {
			cmd = new MoveCommand(request);
			cmd.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		switch(cmd.getAction()) {
		case "move":
		//	System.out.println(String.format(Constants.VIEW_PATH , "customer", 
		//			request.getParameterValues("dest")));
		
			try {
				Transfer.forward(request, response, cmd);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
			
		
		
		case "join":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			//CustomerBean param = new CustomerBean();
			
			param.setCredit(credit);
			param.setId(id);
			param.setPw(pw);
			param.setName(name);
			param.setSsn(ssn);
			//System.out.println("회원정보:" + param.toString());
			
			service.join(param);
			try {
				command.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
				break;
				
		case "login":
			id = request.getParameter("lid");
			pw = request.getParameter("lpw");
			System.out.println("맥락이 맞아서 도착234");
			param.setId(request.getParameter("lid"));
			param.setPw(request.getParameter("lpw"));
			CustomerBean cb = new CustomerBean();
			cb = service.login(param);
			if(cb.getId().equals("lid")) {
				System.out.println("왜이래" +param.getId() + cb.getId());
				
				System.out.println(param.toString());
			
			}
			else {
				request.getRequestDispatcher(String.format(
						Constants.VIEW_PATH , "customer" , "login"))
				.forward(request, response);;
			}
			
			
			//param.setName("김유신");
			
			break;
		case "existId":
			break;
		}
		
		
		
		
		
		/**
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
/*
 * 
 */
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
