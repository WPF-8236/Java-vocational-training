package com.pro.controller;

import com.pro.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ParamController {
    /*@RequestMapping("/param1")
    public String param1(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(user+"------");
        return "param1";
    }*/

    @RequestMapping("/param1")
    @ResponseBody
    public User param1(User user){
        System.out.println(user+"------");
        return user;//想不去页面了。想给你数据，仅仅是json数据
    }

    @RequestMapping("/param")   //去param页面
    public String param(){
        return "param";
    }

    @RequestMapping("/param2")
    @ResponseBody
    public String param2(int userId,String userName,String password){
        System.out.println(userId+"------"+userName+","+password);
        return userId+"------"+userName+"------"+password;
    }

    @RequestMapping("/param3")
    @ResponseBody
    public String param3(int userId, @RequestParam(value = "userName") String username, String password){
        System.out.println(userId+"------"+username+","+password);
        return userId+"------"+username+"------"+password;
    }
    @RequestMapping("/param4")
    @ResponseBody
    public User param4(User user,String [] ah){
        System.out.println("ah: "+ah);
        return user;
    }
    //list集合形参，是否可以接收到数据

    //，将ah作为User的属性，是否可以直接在user对象中接收到
}
