package com.yff.roomsMng.controller;

import com.alibaba.fastjson.JSONObject;
import com.yff.roomsMng.entitys.User;
import com.yff.roomsMng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: RoomsMng
 * @description:
 * @author: yufeiafn@wondersgroup.com
 * @create: 2019-04-07 15:30
 **/
@Controller
public class loggingController {

    @Autowired
    private IUserService userServiceImpl;
    /**
     * @Author yufeifan@wondersgroup.com
     * @Description //注册
     * @Date 15:40 2019/4/7
     **/
    @ResponseBody
    @RequestMapping("/register")
    public String register(){
        User user = new User();
        userServiceImpl.insetUser(user);
        return "ok";

    }
    @ResponseBody
    @RequestMapping("/getAllUser")
    public String getAllUser(){
        return JSONObject.toJSONString(userServiceImpl.getAllUser());
    }

    @GetMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }
}
