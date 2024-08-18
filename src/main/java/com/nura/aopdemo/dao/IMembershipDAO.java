package com.nura.aopdemo.dao;

public interface IMembershipDAO {

	void addAccount();
	void addAccount(int accountId);
	void addAccount(int accountId, String accountBranch);
	void goToSleep();
}
