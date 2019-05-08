package com.gangbin.store.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gangbin.store.bean.Account;
import com.gangbin.store.dao.AccountMapper;

public class AccountService {
	
	@Autowired
	AccountMapper accountMapper;
	
	public Account getAccount(int accountId){
		return accountMapper.selectByPrimaryKey(accountId);
	}
	
}
