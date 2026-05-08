package cn.edu.guet.demo2.service.impl;

import cn.edu.guet.demo2.entity.Role;
import cn.edu.guet.demo2.entity.User;
import cn.edu.guet.demo2.mapper.UserMapper;
import cn.edu.guet.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> getUserInfoPage(){
        return userMapper.getUserInfoPage();
    }
}
