package com.miaoshaproject.service.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by lbk on 2019/6/17,18:21
 */
public class UserModel {
    private Integer id;

    @NotBlank(message = "名字不能为空")
    private String name;

    @NotNull(message = "性别不能不填")
    private Byte gender;

    @NotNull(message = "性别不能不填")
    @Min(value = 0, message = "年龄要大于0")
    @Max(value = 200,message = "年龄要小于200")
    private Integer age;

    @NotBlank(message = "手机号不能为空")
    private String telphone;

    //    private String registerMode; 是这个地方错了，少写个l
    private String registerModel;
    private String thirdPartyId;

    @NotBlank(message = "密码不能为空")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getRegisterModel() {
        return registerModel;
    }

    public void setRegisterModel(String registerModel) {
        this.registerModel = registerModel;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }
}
