package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand  extends Command{
	public MoveCommand(HttpServletRequest request) throws Exception {
		
		setRequest(request);
		setDomain(domain);
		setAction(request.getParameter("action"));
		execute();
		
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws Exception{
		super.execute();
		request.setAttribute("page", request.getParameter("page"));
		
	}

}
