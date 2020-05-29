package com.mobvoi.demo.controller;


import com.mobvoi.demo.entiry.Account;
import com.mobvoi.demo.entiry.CommonResult;
import com.mobvoi.demo.service.AccountService;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class AccountController {

  @Autowired
  @Qualifier("crashAccountService")
  private AccountService crashAccountService;

  @Autowired
  @Qualifier("pointAccountService")
  private AccountService pointAccountService;

  @GetMapping("/seleteById/{id}")
  @ResponseBody
  public CommonResult<Account> selectByPrimaryKey(@PathVariable("id") Integer id){
    BigDecimal result = crashAccountService.selectByPrimaryKey(id);
    log.info("查询结果："+result);
    if (result!=null){
      return new CommonResult(200,"查询成功:",result);
    }else {
      return new CommonResult(444,"查询失败，没有对应记录",null);
    }
  }

  @GetMapping("/account/{type}")
  public CommonResult<Account> getAccount(@PathVariable("type") Integer type){
    //TODO: 根据不用类型，返回不同类型的账户余额
    List<Account> result = crashAccountService.getAccountFromType(type);
    log.info("查询结果："+result);
    if (result.size() != 0){
      return new CommonResult(200,"查询成功:",result);
    }else {
      return new CommonResult(444,"查询失败，没有对应记录",null);
    }
  }

  //TODO： 定义接口，实现根据账户名以及账户类型进行转账操作.比如账户A向账户B转账现金10元
  //查询所有员工返回列表页面
  @GetMapping("/pointToAccount")
  public String  list(Model model, HttpServletRequest request){
     Object object = request.getSession().getAttribute("loginUserId");
    Collection<Account> accounts = pointAccountService.findAllUser((Integer) object);

    //放在请求域中
    model.addAttribute("accounts",accounts);
    return "emp/list";
  }

 /* TODO： 定义接口，实现根据账户名以及账户类型进行转账操作.比如账户A向账户B转账现金10元
  来到转账页面*/
  @GetMapping("/transferAccounts/{id}")
  public String toAddPage(@PathVariable("id") Integer id, Model model){
    Account account = pointAccountService.findOne(id);
    model.addAttribute("account",account);
    return "emp/transfer";
  }

  @PostMapping("/transferAccount")
  public String transfer(Integer id,BigDecimal amount,HttpServletRequest request,Model model){
    Object object = request.getSession().getAttribute("loginUserId");
    Account accountFrom = pointAccountService.findOne((Integer) object);
    Account accountTo = pointAccountService.findOne(id);
    if (accountFrom.getAmount().compareTo(amount) == -1) {
      //账户余额不足
      String str = "您的余额不足，请及时充值";
        model.addAttribute("msg",str);
       return "error/error";
    }else {
     /* //进行转账，应该用单线程加锁，这样能避免，自己账户余额已经减少，但是钱没转成功
      accountFrom.setAmount(accountFrom.getAmount().subtract(amount));
      accountFrom.setUpdatedAt(new Date());
      pointAccountService.updateAccount(accountFrom);
      accountTo.setAmount(accountTo.getAmount().add(amount));
      accountTo.setUpdatedAt(new Date());
      pointAccountService.updateAccount(accountTo);*/

      pointAccountService.translate(accountFrom,accountTo,amount);
    }
    return "emp/list";
  }
}
