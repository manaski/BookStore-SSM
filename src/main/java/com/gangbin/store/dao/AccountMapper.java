package com.gangbin.store.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gangbin.store.bean.Account;
import com.gangbin.store.bean.AccountExample;

public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);
    
    Account selectByPrimaryKey(int accountId);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);
}