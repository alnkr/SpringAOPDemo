package com.nura.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nura.aopdemo.bean.Account;

@Repository
public class AccountDAOImpl implements IAccountDAO {

	private String name;

	private String serviceNo;

	@Override
	public void addAccount() {
		System.out.println(getClass() + ": Doing my DB work:Adding account!!");
	}

	@Override
	public void addAccount(Account account) {
		System.out.println(getClass() + ": Doing my DB work:Adding account:" + account + "!!");
	}

	@Override
	public boolean doWork(String task) {
		System.out.println(getClass() + ": I am working on task: " + task + "!!!");
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	@Override
	public List<Account> findAccounts() {
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripwire) {
		List<Account> myAccounts = null;
		if (tripwire) {
			throw new RuntimeException("No Soup for you!!!");
		}
		myAccounts = new ArrayList<Account>();

		myAccounts.add(new Account("Savings", "platinum"));
		myAccounts.add(new Account("Current", "platinum"));
		myAccounts.add(new Account("Loan", "Diamond"));

		return myAccounts;
	}

}
