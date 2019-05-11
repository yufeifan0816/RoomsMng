package com.yff.roomsMng.service.impl;

import com.yff.roomsMng.dao.UserMapper;
import com.yff.roomsMng.entitys.User;
import com.yff.roomsMng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: RoomsMng
 * @description: impl
 * @author: yufeiafn@wondersgroup.com
 * @create: 2019-04-07 15:34
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insetUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }
}
