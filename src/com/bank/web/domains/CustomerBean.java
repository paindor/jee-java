package com.bank.web.domains;

public class CustomerBean extends MemberBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String credit;

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		// TODO Auto-generated msethod stub
		return String.format("회원정보[id:%s"
				+ "pw:%s" 
				+ "이름:%s"
				+ "주민번호:%s"
				+ "신용도:%s", getId(), getPw() , getName(), getSsn(), this.credit);
	}
}
