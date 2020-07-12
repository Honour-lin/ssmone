package com.weilinyang.service;

import com.weilinyang.pojo.PageResult;
import com.weilinyang.pojo.Result;
import com.weilinyang.pojo.User;

import java.util.List;

public interface UserService {

    PageResult findPage(int pageNum,int size);

    void add(User user);

    void delete(int id);

    PageResult search(User user,int pageNum,int size);

    List<User> findAll();
}
