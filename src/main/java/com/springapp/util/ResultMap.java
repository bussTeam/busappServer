package com.springapp.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by thanks_bin on 2014/10/25.
 */
public class ResultMap {

    private boolean Success;

    private Map<String, Object> data;

    private String ERROR;

    public String toJsonString(String callback, ResultMap resultMap){
        String resultJsonString = JSON.toJSONString(resultMap);
        StringBuilder sb =new StringBuilder();
        sb.append(CallBackContentHolder.getCallBackFuncName());
        sb.append("(");
        sb.append(resultJsonString);
        sb.append(")");
        CallBackContentHolder.clearCallBackFuncName();
        return sb.toString();
    }
    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(String key, Object value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(key,value);
        this.data = map;
    }

    public String getERROR() {
        return ERROR;
    }

    public void setERROR(String ERROR) {
        this.ERROR = ERROR;
    }
}
