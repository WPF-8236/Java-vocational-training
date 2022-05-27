package com.pro.util;

import com.pro.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<User> userList=new ArrayList<User>();

    static {
        for (int i = 0; i < 10; i++) {
            userList.add(new User(i,"name"+i,"pwd"+i));
        }
    }
}
