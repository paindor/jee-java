package com.bank.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
			File file = new File( Constants.FILE_PATH + "dd.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(param.getId() +"/" + param.getPw()+"/" + 
			param.getName() +"/" + param.getSsn()+"/" +
			param.getCredit());
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

	@Override
	public CustomerBean login(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH + "dd.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String para = reader.readLine();
			String[] spl = para.split("/");
			System.out.println(spl[3]);
		//	param.getId() +"/" + param.getPw()+"/" +param.getSsn()+"/" +
		//	param.getCredit())
			param.setId(spl[0]);
			param.setPw(spl[1]);
			param.setName(spl[2]);
			param.setSsn(spl[3]);
			param.setCredit(spl[4]);
		
			
			
			
			
			
			/*File file = new File( Constants.FILE_PATH + "member.txt");
			 * 
			 *
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(param.toString());
			writer.newLine();
			writer.flush();*/
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return param;
	}
	

}
