package com.bank.web.command;

import java.io.File;
import java.io.IOException;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.pool.Constants;

import lombok.Data;
@Data
public class Command implements Order {

	protected HttpServletRequest request;
	protected String action, domain, page , view;
	
	

	@Override
	public void execute() throws Exception {
		
		setDomain();
		setPage();
		System.out.println("리퀘스트가 가야할길 ::: "+ String.format(Constants.VIEW_PATH,  domain, page));
		this.view = String.format(Constants.VIEW_PATH , domain, page);
	}
	public void setDomain() {
		String path = request.getServletPath();
		System.out.println("서브린패스가 뭐냐 : "+ path);

		domain = path.replace(".do", "");
		domain = domain.substring(1);
		System.out.println(domain);
		
		
	}
	public void setPage() {
		page = request.getParameter("page");
		
	}
	public void setView(String domain, String page) {
		this.view = String.format(Constants.VIEW_PATH , domain, page);
	}



}
