package com.bank.web.serviceimpls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService{

	private List<AccountBean> acc;
	public AccountServiceImpl() {
		acc = new ArrayList<AccountBean>();
		
	}
	
	@Override
	public void createAccount(int money) {
		AccountBean temp = new AccountBean();
		temp.setMoney(String.valueOf(money));
		temp.setAccountNum(createAccountNum());
		temp.setTime(findDate());
		
		acc.add(temp);
		
		
		
	}

	@Override
	public String createAccountNum() {
		Random rd = new Random();
		String n1 = "",n2 = "";
		for(int i = 0 ; i< 4; i++) {
			n1 += rd.nextInt(9) + "";
			n2 += rd.nextInt(9) + "";
			
		}
		
		
		return n1 + "-"+ n2;
	}

	@Override
	public List<AccountBean> findAll() {
		// TODO Auto-generated method stub
		return acc;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean result = new AccountBean();
		
		if(existAccountNum(accountNum)) {
			for(AccountBean a : acc) {
				if(accountNum.equals(a.getAccountNum())) {
					result = a;
				}
			}
		}
		return result;
	}

	@Override
	public int countAccounts() {
		// TODO Auto-generated method stub
		return acc.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean isExist = false;
		for(AccountBean ac : acc) {
			if(accountNum.equals(ac.getAccountNum())) {
				isExist = true;
			}
		}
		return isExist;
	}

	@Override
	public String findDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return sdf.format(new Date());
		
	}

	@Override
	public void depositMoney(AccountBean param) {
		
		if(existAccountNum(param.getAccountNum())) {
			int depo = Integer.parseInt(param.getMoney());
			
			int index = acc.indexOf(param);
			int bal = Integer.parseInt(acc.get(index).getMoney());
			String re = String.valueOf(bal+ depo);
			acc.get(index).setMoney(re);
		}
	}

	@Override
	public void withdrawMoney(AccountBean param) {

		if(existAccountNum(param.getAccountNum())) {
			int depo = Integer.parseInt(param.getMoney());
			
			int index = acc.indexOf(param);
			int bal = Integer.parseInt(acc.get(index).getMoney());
			String re = String.valueOf(bal - depo);
			acc.get(index).setMoney(re);
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		AccountBean ab = findByAccountNum(accountNum);
		
		if(existAccountNum(accountNum)) {
			acc.remove(ab);
		}
		
	}

}
