package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BussinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


/**
 * Created by lbk on 2019/6/17,18:06
 */
@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/getotp", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telphone") String telphone) {
        //按照一定规则生成OTP验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

        //将OTP验证同对应用户的手机号关联，使用HTTP session的方式绑定(redis非常适用）
        httpServletRequest.getSession().setAttribute(telphone, otpCode);

        //将OTP验证码通过短信通道发送给用户，省略
        System.out.println("telphone = " + telphone + "&optCode=" + otpCode);
        return CommonReturnType.create(null);
    }

    //用户登陆接口
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType login(@RequestParam(name="telphone")String telphone,
                                  @RequestParam(name="password")String password) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //参数校验
        if(org.apache.commons.lang3.StringUtils.isEmpty(telphone)|| org.apache.commons.lang3.StringUtils.isEmpty(password)){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //用户登陆服务，用来校验用户登陆是否合法
        UserModel userModel =userService.validateLogin(telphone,this.enCodeByMD5(password));

        //将登陆凭证加入到用户登陆成功的session中
        UserVO userVo = convertFromModel(userModel);
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userModel);

        System.out.println(this.httpServletRequest.getSession().getAttribute("IS_LOGIN"));

        return CommonReturnType.create(null);
    }





    @Transactional
    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "telphone") String telphone,
                                     @RequestParam(name = "otpCode") String otpCode,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "gender") Integer gender,
                                     @RequestParam(name = "age") Integer age,
                                     @RequestParam(name = "password") String password) throws BussinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
//        if (!com.alibaba.druid.util.StringUtils.equals(otpCode, inSessionOtpCode)) {
//            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不符合");
//        }
        //用户注册流程
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(new Byte(String.valueOf(gender.intValue())));
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setRegisterModel("byphone");
        userModel.setPassword(this.enCodeByMD5(password));

        userService.register(userModel);


        return CommonReturnType.create(null);

    }


    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BussinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);
        //若获取的对应用户信息不存在
        if (userModel == null) {
            throw new BussinessException(EmBusinessError.USER_NOT_EXIST);
        }


        //转换为可供UI使用的
        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }

    public String enCodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        // 加密字符串
        String newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }

    private UserVO convertFromModel(UserModel uesrModel) {
        if (uesrModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(uesrModel, userVO);
        return userVO;
    }


}
