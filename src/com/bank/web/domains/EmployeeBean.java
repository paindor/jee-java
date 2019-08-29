package com.bank.web.domains;

public class EmployeeBean extends MemberBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String num;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("회원정보[id:%s"
				+ "pw:%s" 
				+ "이름:%s"
				+ "주민번호:%s"
				+ "사번:%s", getId(), getPw() , getName(), getSsn(), this.num);
	}
}
