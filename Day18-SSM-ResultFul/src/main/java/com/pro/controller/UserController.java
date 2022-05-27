package com.pro.controller;

import com.pro.domain.User;
import com.pro.util.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    //去首页
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("userList", Data.userList);
        return "index";
    }

    //删除，根据id
    @RequestMapping("/delete")
    public String delete(int userId){
        for (int i = 0; i < Data.userList.size(); i++) {
            if(userId==Data.userList.get(i).getUserId()){
                Data.userList.remove(i);
                break;
            }
        }
        return "redirect:/";   //这是重定向到index
    }

    //去添加用户的页面
    @RequestMapping("/toadd")
    public String toadd(){
        return "add";
    }

    //添加用户
    @RequestMapping("/add")
    public String add(User user){
        Data.userList.add(user);
        return "redirect:/";
    }

    //下面部分大家来实现：
    //1 去修改的页面toupdate 的方法, 注意，这里的1，2，3中的2是要准备回显的数据

    //2 修改用户的方法，参考add方法
}
