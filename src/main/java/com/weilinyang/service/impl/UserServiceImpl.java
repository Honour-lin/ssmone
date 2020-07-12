package com.weilinyang.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.weilinyang.mapper.UserMapper;
import com.weilinyang.pojo.PageResult;
import com.weilinyang.pojo.Result;
import com.weilinyang.pojo.User;
import com.weilinyang.pojo.UserExample;
import com.weilinyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public PageResult findPage(int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
//        Page<User> pages = (Page<User>) userMapper.selectByExample(null);
        Page<User> pages = (Page<User>) userMapper.selectUsers();
        return new PageResult(pages.getTotal(),pages.getResult());
    }

    public void add(User user) {
        userMapper.insert(user);
    }

    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public PageResult search(User user, int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user != null){
            if(user.getSign() != null && user.getSign().length() > 0){
                criteria.andSignEqualTo(user.getSign());
            }
            if(user.getUsername() != null && user.getUsername().length() > 0){
                criteria.andUsernameLike("%" + user.getUsername() + "%");
            }
        }
        Page<User> pages = (Page<User>) userMapper.selectByExample(example);
        return new PageResult(pages.getTotal(),pages.getResult());
    }

    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }
}
