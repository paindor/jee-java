package com.bank.web.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import com.bank.web.daoimpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;


public class MemberServiceImpl implements MemberService{

	MemberDAO dao;
	public MemberServiceImpl() {
		dao = new MemberDAOImpl();
		
	}
	
	@Override
	public void join(CustomerBean param) {
		dao.insertCustomer(param);
		
		
	}

	@Override
	public void register(EmployeeBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeBean> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		CustomerBean db = new CustomerBean();
		//boolean result = false;
		
		db = dao.login(param);
		
		
		
		return db;
	}

	@Override
	public int countCustomers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updatePass(MemberBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteMember(MemberBean param) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	
	
	
	
	
	
	
	/*private List<CustomerBean> customers;
	private List<EmployeeBean> employees;
	
	public MemberServiceImpl() {
		customers = new ArrayList<>();
		employees = new ArrayList<>();
	} 

	@Override
	public void join(CustomerBean param) {
		customers.add(param);
	}

	@Override
	public void register(EmployeeBean param) {
		employees.add(param);
		EmployeeBean emplo = new EmployeeBean();
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		return customers;
	}

	@Override
	public List<EmployeeBean> findAllEmployees() {
		return employees;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> members = new ArrayList<>();
		int count = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				count++;
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				count++;
			}
		}
		int j = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				members.add(c);
				j++;
				if(j==count) {
					return members;
				}
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				members.add(e);
				j++;
				if(j == count) {
					break;
				}
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				m = c;
				return m;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		return m;
	}

	@Override
	public MemberBean login(MemberBean param) {
		boolean flag = false;
		MemberBean m = findById(param.getId());
		for(CustomerBean c : customers) {
			if(m.equals(c.getId())) {
				flag = true;
				break;
			}
		}
		for(EmployeeBean e : employees) {
			if(m.equals(e.getId())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public int countCustomers() {
		return customers.size();
	}

	@Override
	public int countEmployees() {
		return employees.size();
	}

	@Override
	public boolean existId(String id) {
		boolean b = false;
		MemberBean m = findById(id);
		if( customers.contains(m)&&  employees.contains(m)) {
		
			b = true;
		}
		
		
		
		return b;
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String oldPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
		MemberBean m = findById(id);
		if(m.getPw().equals(oldPw)) {
			int idx = (employees.contains(m)) 
					? employees.indexOf(m)
						:customers.indexOf(m);
			if(employees.contains(m)) {
				employees.get(idx).setPw(newPw);
			}else {
				customers.get(idx).setPw(newPw);
			}		
		}
			
	}

	@Override
	public boolean deleteMember(MemberBean param) {
		boolean result = false;
		MemberBean m = findById(param.getId());
		
		return (employees.contains(m))? employees.remove(m): customers.remove(m);
		
		
	}*/

}