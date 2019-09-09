package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletRequest request , HttpServletResponse response) {
		try {
			System.out.println("센더 의 리시버"+Receiver.cmd.getView());
			//System.out.println("센더" + Receiver.cmd.getView()+ Receiver.cmd.getPage());
			request.getRequestDispatcher(Receiver.cmd.getView())
			.forward(request, response);
			System.out.println("센더 의 리시버"+Receiver.cmd.getView());
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
