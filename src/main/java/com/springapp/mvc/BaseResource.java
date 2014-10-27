package com.springapp.mvc;

import com.alibaba.fastjson.JSON;
import com.springapp.util.CallBackContentHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thanks_bin on 2014/10/25.
 */
public class BaseResource {

    private boolean Success;

    private Object data;

    private String ERROR;

    public String toJsonString(){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success",Success);
        resultMap.put("result", data);
        if (!Success){
            resultMap.put("error",ERROR);
        }
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getERROR() {
        return ERROR;
    }

    public void setERROR(String ERROR) {
        this.ERROR = ERROR;
    }
}
