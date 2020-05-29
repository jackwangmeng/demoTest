package com.mobvoi.demo.mapper;

import com.mobvoi.demo.entiry.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Mapper
public interface AccountMapper {

  public  Account selectByPrimaryKey(Integer id);

  /*只返回金额
  public List<BigDecimal> getAccountFromType(Integer type);*/

  public List<Account> getAccountFromType(Integer type);

  public Account permitValidator(String accountName, String password);

  public Collection<Account> findAllUser(Integer id);

    int updateAccount(Account account);
}