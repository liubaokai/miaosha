package com.miaoshaproject.validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lbk on 2019/6/19,10:22
 */
public class ValidationResult {
    //检查结果是否有错
    private boolean hasErrors = false;

    //存放错误信息的map
    private Map<String, String> errMsgMap = new HashMap<>();

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrMsgMap() {
        return errMsgMap;
    }

    public void setErrMsgMap(Map<String, String> errMsgMap) {
        this.errMsgMap = errMsgMap;
    }

    //实现通用的通过格式化字符串信息获取错误结果的msg方法
    public String getErrMsg() {
        return StringUtils.join(errMsgMap.values().toArray(),",");
    }
}
