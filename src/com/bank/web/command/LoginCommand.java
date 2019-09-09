package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class LoginCommand extends MoveCommand {
	public LoginCommand(HttpServletRequest request) throws Exception{
		super(request);
		
	}
	@Override
	public void execute() throws Exception {
		
		super.execute();
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		
		String id = request.getParameter("lid");
		String pw = request.getParameter("lpw");
		System.out.println("맥락이 맞아서 도착234");
		param.setId(id);
		param.setPw(pw);
		CustomerBean cb = new CustomerBean();
		cb = service.login(param);
		String page = "";
		String domain ="";
		
		if(cb == null) {
			page = "login";
			domain = "customer";
			System.out.println("널널들어옴");
			
		}
		else {
			page = "mypage";
			domain = "customer";
			
		}
		request.setAttribute("customer", cb);
		Receiver.cmd.setView(domain, page);
		System.out.println(Receiver.cmd.getView());
	
	}

}
