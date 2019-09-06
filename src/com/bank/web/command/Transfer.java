package com.bank.web.command;

import java.io.IOException;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.pool.Constants;

public class Transfer {
	public static void forward(HttpServletRequest request, HttpServletResponse response, MoveCommand cmd)
		{
		try {
			request.getRequestDispatcher(cmd.getView()).forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
