package com.mobvoi.demo.controller;

import com.mobvoi.demo.entiry.Account;
import com.mobvoi.demo.service.impl.PointAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Slf4j
public class LoginController {
    @Autowired
    @Qualifier("pointAccountService")
    private PointAccountService pointAccountService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session, Model model){

        Account result = pointAccountService.permitValidator(username,password);
        log.info(""+result);
        if(result != null){
            session.setAttribute("loginUser","账号："+username);
            session.setAttribute("loginType",result.getType());
            session.setAttribute("loginUserId",result.getId());
            model.addAttribute("loginAmount","，账户余额："+result.getAmount());
            return "dashboard";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }
    }

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String login(String e){
       return "login";
    }
}
