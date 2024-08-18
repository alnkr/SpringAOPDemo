package com.nura.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements IMembershipDAO {

	@Override
	public void addAccount() {
		System.out.println(getClass()+": Doing my DB work:Adding membership account!!");
	}
	
	public void addAccount(int accountId) {
		System.out.println(getClass()+": Doing my DB work:Adding membership account id:"+accountId+"!!");
	}

	public void addAccount(int accountId, String accountBranch) {
		System.out.println(getClass()+": Doing my DB work:Adding membership account id:"+accountId+", Branch:"+accountBranch+"!!");
	}

	@Override
	public void goToSleep() {
		System.out.println(getClass()+": membership account. I am going to sleep.!!");		
	}
}
