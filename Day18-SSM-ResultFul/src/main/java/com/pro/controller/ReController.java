package com.pro.controller;

import com.pro.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ReController {

    @RequestMapping("/rest")
    public String rest(){
        return "restfull";
    }

    @PostMapping("/addUser")
    @ResponseBody
    public User add(User user){
        System.out.println("--add--"+user);
        return user;
    }

    /*
    * {
	"userId":9,
	"userName":"丰",
	"password":"567890"
    }
    * */

    @PostMapping("/addUserJson")
    @ResponseBody
    public User addUserJson(@RequestBody User user){
        System.out.println("--add--"+user);
        return user;
    }

    @DeleteMapping("/deleteUser/{userId}")
    @ResponseBody
    public String delete(@PathVariable(value = "userId")int userId){
        System.out.println("--delete--"+userId);
        return userId+"---- delete";
    }

    @PutMapping("/updateUser")
    @ResponseBody
    public User update(User user){
        System.out.println("--update--"+user);
        return user;
    }


    @GetMapping("/selectUser/{userId}")
    @ResponseBody
    public List<User> select(@PathVariable(value = "userId")int userId, Model model){
        System.out.println("--select--"+userId);
        List<User> userList=new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User(i,"name"+i,"pwd"+i));
        }
        model.addAttribute("userList",userList);
        return userList;
    }


}
