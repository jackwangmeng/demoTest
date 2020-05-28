package com.mobvoi.demo.controller;


import com.mobvoi.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  private AccountService cashAccountService;

  @Autowired
  private AccountService pointAccountService;

  @GetMapping("/account")
  public String getAccount(Integer type){
   //TODO: 根据不用类型，返回不同类型的账户余额
    return null;
  }

  //TODO： 定义接口，实现根据账户名以及账户类型进行转账操作.比如账户A向账户B转账现金10元
}
