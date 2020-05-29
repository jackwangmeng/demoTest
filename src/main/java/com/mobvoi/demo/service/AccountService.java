package com.mobvoi.demo.service;


import com.mobvoi.demo.entiry.Account;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface AccountService {

  List<Account> getAccountFromType(Integer type);

  //根据账户Id获取其金额数目
  BigDecimal  selectByPrimaryKey(Integer id);

  Account findOne(Integer id);

  Account permitValidator(String accountName,String password);

  Collection<Account> findAllUser(Integer id);

    int updateAccount(Account account);

  void translate(Account accountFrom, Account accountTo, BigDecimal amount);
}
