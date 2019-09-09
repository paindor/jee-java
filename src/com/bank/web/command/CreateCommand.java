package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class CreateCommand extends MoveCommand{

	public CreateCommand(HttpServletRequest request) throws Exception {
		super(request);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws Exception {
	
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		
		super.execute();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String credit = request.getParameter("credit");
		param.setId(id);
		param.setPw(pw);
		param.setName(name);
		param.setSsn(ssn);
		param.setCredit(credit);
		service.join(param);
		Receiver.cmd.setPage("login");
		
	}
	

}
