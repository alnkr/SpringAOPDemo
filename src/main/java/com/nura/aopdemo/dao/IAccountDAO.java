package com.nura.aopdemo.dao;

import java.util.List;

import com.nura.aopdemo.bean.Account;

public interface IAccountDAO {

	void addAccount();

	void addAccount(Account account);

	List<Account> findAccounts();

	List<Account> findAccounts(boolean tripwire);

	boolean doWork(String task);

	String getName();

	void setName(String name);

	String getServiceNo();

	void setServiceNo(String serviceNo);

}
