package com.weilinyang.controller;

import com.github.pagehelper.PageHelper;
import com.weilinyang.pojo.PageResult;
import com.weilinyang.pojo.Result;
import com.weilinyang.pojo.User;
import com.weilinyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/page")
    public PageResult findPage(int page,int size){
        return userService.findPage(page,size);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody User user){
        try {
            userService.add(user);
            return new Result(true,"添加成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"添加失败！");
        }
    }
    @RequestMapping("/delete")
    public Result add(int id){
        try {
            userService.delete(id);
            return new Result(true,"删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody User user, int page,int size){
        System.out.println(user.getSign());
        System.out.println(user.getUsername());
        return userService.search(user,page,size);
    }

    @RequestMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }

}
