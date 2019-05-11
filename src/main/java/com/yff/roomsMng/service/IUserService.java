package com.yff.roomsMng.service;

import com.yff.roomsMng.entitys.User;

import java.util.List;

/***
 * @Author yufeifan@wondersgroup.com
 * @Description 用户业务接口
 * @Date 15:32 2019/4/7
 **/
public interface IUserService {

    int insetUser(User user);

    List<User> getAllUser();
}
