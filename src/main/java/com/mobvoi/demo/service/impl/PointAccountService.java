package com.mobvoi.demo.service.impl;

import com.mobvoi.demo.entiry.Account;
import com.mobvoi.demo.mapper.AccountMapper;
import com.mobvoi.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PointAccountService implements AccountService {

  @Autowired
  private AccountMapper accountMapper;

  @Override
  public List<Account> getAccountFromType(Integer type) {
    //TODO：希望实现

    return null;
  }

  @Override
  public BigDecimal selectByPrimaryKey(Integer id) {
    return null;
  }

  @Override
  public Account findOne(Integer id) {
    return accountMapper.selectByPrimaryKey(id);
  }

  @Override
  public Account permitValidator(String accountName, String password) {
    return accountMapper.permitValidator(accountName,password);
  }

  @Override
  public Collection<Account> findAllUser(Integer id) {
    return accountMapper.findAllUser(id);
  }

  @Override
  public int updateAccount(Account account) {
    return accountMapper.updateAccount(account);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void translate(Account accountFrom, Account accountTo, BigDecimal amount) {

    try {
      accountFrom.setAmount(accountFrom.getAmount().subtract(amount));
      accountFrom.setUpdatedAt(new Date());
      accountMapper.updateAccount(accountFrom);
      /*测试使用
      int i = 1 / 0;*/
      accountTo.setAmount(accountTo.getAmount().add(amount));
      accountTo.setUpdatedAt(new Date());
      accountMapper.updateAccount(accountTo);
    } catch (Exception e) {
      throw new RuntimeException("操作失败");
    }
  }
}
