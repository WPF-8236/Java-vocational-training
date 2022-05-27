package com.pro.controller;

import com.pro.domain.User;
import com.pro.util.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController1 {

    //@RequestMapping(value = "/user" ,method = RequestMethod.POST)
    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/displayUser")
    @ResponseBody
    public List<User> displayUser(){
        /*List<User> userList=new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User(i,"name"+i,"pwd"+i));
        }*/
        return Data.userList;
    }

    @PostMapping("/addUser1")
    public String addUser1(User user){
        Data.userList.add(user);
        return "redirect:displayUser";
    }

    //删除的方法,参数一个id

    //

}
