package com.mobvoi.demo.service.impl;

import com.mobvoi.demo.entiry.Account;
import com.mobvoi.demo.mapper.AccountMapper;
import com.mobvoi.demo.service.AccountService;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author baixiangzhu
 * @date 2020-05-27
 */
@Service
public class CrashAccountService implements AccountService {

  @Resource
  private AccountMapper accountMapper;

  @Override
  public List<Account> getAccountFromType(Integer type) {
    //TODO：希望实现
    List<Account> result = accountMapper.getAccountFromType(type);
    if (result.size()!=0) {
      return result;
    }else {
      return null;
    }
  }

  @Override
  public BigDecimal selectByPrimaryKey(Integer id) {
    Account result = accountMapper.selectByPrimaryKey(id); //根据ID查询数据并获得账户金额
    return result!=null ? result.getAmount() : null;
  }

  @Override
  public Account findOne(Integer id) {
    return null;
  }

  @Override
  public Account permitValidator(String accountName, String password) {
    return null;
  }

  @Override
  public Collection<Account> findAllUser(Integer id) {
    return null;
  }

  @Override
  public int updateAccount(Account account) {
    return 0;
  }

  @Override
  public void translate(Account accountFrom, Account accountTo, BigDecimal amount) {

  }
}
