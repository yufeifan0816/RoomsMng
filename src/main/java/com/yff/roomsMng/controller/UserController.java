package com.yff.roomsMng.controller;

import com.github.pagehelper.PageInfo;
import com.yff.roomsMng.entitys.User;
import com.yff.roomsMng.service.IUserService;
import com.yff.roomsMng.utils.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: RoomsMng
 * @description:
 * @author: yufeiafn@wondersgroup.com
 * @create: 2019-04-07 15:30
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private IUserService userServiceImpl;
    /**
     * @Author yufeifan@wondersgroup.com
     * @Description //用户列表
     * @Date 15:40 2019/4/7
     **/
    @RequestMapping()
    public String view(){
        List<User> users = userServiceImpl.getAllUser();
        return "user_manager";
    }
    @ResponseBody
    @RequestMapping("/list")
    public Page getList(){
        List<User> users = userServiceImpl.getAllUser();
        return new Page(users);
    }
}
