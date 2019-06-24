package com.miaoshaproject.service;

import com.miaoshaproject.error.BussinessException;
import com.miaoshaproject.service.model.UserModel;

/**
 * Created by lbk on 2019/6/17,18:09
 */
public interface UserService {
    // 用过用户id获取用户对象的方法
   UserModel getUserById(Integer id);

    //注册
    void register(UserModel userModel) throws BussinessException;
    UserModel validateLogin(String telphone,String Password) throws BussinessException;


}
