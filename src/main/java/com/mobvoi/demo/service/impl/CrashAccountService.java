package com.mobvoi.demo.service.impl;

import com.mobvoi.demo.mapper.AccountMapper;
import com.mobvoi.demo.service.AccountService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  public BigDecimal getAccountFromType(Integer type) {
    //TODO：希望实现
    return accountMapper.selectByPrimaryKey(type).getAmount();
  }
}
