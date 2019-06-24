package com.miaoshaproject.error;

/**
 * Created by lbk on 2019/6/17,19:48
 */
public interface CommonError {
    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);

}
