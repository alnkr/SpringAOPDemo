package com.nura.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nura.aopdemo.bean.Account;
import com.nura.aopdemo.dao.IAccountDAO;
import com.nura.aopdemo.dao.IMembershipDAO;
import com.nura.aopdemo.service.ITrafficFortuneService;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(IAccountDAO accountDao, IMembershipDAO membershipDao,
			ITrafficFortuneService tfs) {
		return runner -> {

			// demoTheBeforeAdvice(accountDao, membershipDao);
			// demoTheAfterReturningAdvice(accountDao);
			// demoTheAfterThrowingAdvice(accountDao);
			// demoTheAfterAdvice(accountDao);
			// demoTheAroundAdvice(tfs);
			demoTheAroundAdviceHandleException(tfs);
		};
	}

	private void demoTheAroundAdviceHandleException(ITrafficFortuneService tfs) {

		System.out.println("\n\n Main Program: demoTheAround Advice");
		System.out.println("------");

		System.out.println("\n\nMy Fortune: " + tfs.getFortune(true));

		System.out.println("-----Finished----");

	}

	private void demoTheAroundAdvice(ITrafficFortuneService tfs) {

		System.out.println("\n\n Main Program: demoTheAround Advice");
		System.out.println("------");

		System.out.println("\n\nMy Fortune: " + tfs.getFortune());

		System.out.println("-----Finished----");

	}

	private void demoTheAfterAdvice(IAccountDAO accountDao) {

		List<Account> accounts = null;

		try {
			boolean tripWire = false;
			accounts = accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Caught Exception: " + e);
		}

		System.out.println("\n\n Main Program: demoTheAfter (finally)Advice");
		System.out.println("------");

		System.out.println(accounts);

		System.out.println("End of Program");

	}

	private void demoTheAfterThrowingAdvice(IAccountDAO accountDao) {

		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Caught Exception: " + e);
		}

		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("------");

		System.out.println(accounts);

		System.out.println("End of Program");

	}

	private void demoTheAfterReturningAdvice(IAccountDAO accountDao) {
		List<Account> accounts = accountDao.findAccounts();

		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("------");

		System.out.println(accounts);

		System.out.println("End of Program");

	}

	private void demoTheBeforeAdvice(IAccountDAO accountDao, IMembershipDAO membershipDao) {
		accountDao.addAccount();
		accountDao.addAccount(new Account("Savings", "Platinum"));

		accountDao.doWork("Deposit");

		accountDao.setName("foobar");
		accountDao.setServiceNo("silver");
		accountDao.getName();
		accountDao.getServiceNo();

		membershipDao.addAccount();

		membershipDao.goToSleep();

	}

}
