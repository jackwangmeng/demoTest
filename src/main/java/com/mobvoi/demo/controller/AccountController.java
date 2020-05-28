package com.mobvoi.demo.controller;


import com.mobvoi.demo.entiry.Account;
import com.mobvoi.demo.entiry.CommonResult;
import com.mobvoi.demo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@RestController
@Slf4j
public class AccountController {

  @Autowired
  @Qualifier("crashAccountService")
  private AccountService crashAccountService;

  @Autowired
  @Qualifier("pointAccountService")
  private AccountService pointAccountService;

  @GetMapping("/account/{type}")
  public CommonResult<Account> getAccount(@PathVariable("type") Integer type){
   //TODO: 根据不用类型，返回不同类型的账户余额
    BigDecimal result = crashAccountService.getAccountFromType(type);
    log.info("查询结果："+result);
    if (result!=null){
      return new CommonResult(200,"查询成功:",result);
    }else {
      return new CommonResult(444,"查询失败，没有对应记录",null);
    }
  }

  //TODO： 定义接口，实现根据账户名以及账户类型进行转账操作.比如账户A向账户B转账现金10元
}
