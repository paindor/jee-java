package com.bank.web.daoimpls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constants;
import com.sun.corba.se.impl.orbutil.closure.Constant;

public class MemberDAOImpl implements MemberDAO {
	
	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File( Constants.FILE_PATH + "member.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(param.toString());
			writer.newLine();
			writer.flush();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertEmplyoee(EmployeeBean param) {
		// TODO Auto-generated method stub
		
	}
	

}
