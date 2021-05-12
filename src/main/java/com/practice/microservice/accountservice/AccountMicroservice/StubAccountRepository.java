package com.practice.microservice.accountservice.AccountMicroservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class StubAccountRepository implements AccountRepository {
	
	private static final Logger logger =
			LoggerFactory.getLogger(StubAccountRepository.class);
	
	private Map<String, Account> accountsByNumber = new HashMap<String, Account>();
	
	public StubAccountRepository() {
		Account account = new Account(1000l, "Kunal" , "0402");
		accountsByNumber.put("0402", account);
		account = new Account(2000l, "Mahak" , "1801");
		accountsByNumber.put("1801", account);
		account = new Account(3000l, "Krutika" , "2003");
		accountsByNumber.put("2003", account);
		logger.info("Created StubAccountRepository");
	}
	
	@Override
	public List<Account> getAllAccounts() {
		return new ArrayList<Account>(accountsByNumber.values());
	}

	@Override
	public Account getAccount(String number) {
		return accountsByNumber.get(number);
	}

}
