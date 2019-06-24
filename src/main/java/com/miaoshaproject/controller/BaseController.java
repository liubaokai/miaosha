package com.miaoshaproject.controller;

import com.miaoshaproject.error.BussinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lbk on 2019/6/17,20:34
 */
public class BaseController {
    //定于excephandler解决未被conroller层吸收的exception
    public static final String CONTENT_TYPE_FORMED="application/x-www-form-urlencoded";


//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Object handlerException(HttpServletRequest request, Exception ex) {
//
//        Map<String, Object> reponseData = new HashMap<>();
//        if (ex instanceof BussinessException) {
//            BussinessException bussinessException = (BussinessException) ex;
//            reponseData.put("errCode", bussinessException.getErrCode());
//            reponseData.put("errMsg", bussinessException.getErrMsg());
//        } else {
////            卧槽，我太聪明了，这样可以看出未知的具体异常信息了，只有后端可以看到，但是返回的前端看不到
//            System.out.println(ex);
//
//
//            reponseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
//            reponseData.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
//
//        }
//        return CommonReturnType.create(reponseData, "fail");
//
//    }
}
