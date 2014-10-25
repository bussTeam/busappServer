package com.springapp.mvc;

import com.alibaba.fastjson.JSON;
import com.springapp.dao.NewsInfoMapper;
import com.springapp.pojo.NewsInfo;
import com.springapp.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by bin.zhang on 2014/7/18.
 */
@Controller
public class NewsInfoResource{

    @Resource
    NewsInfoMapper newsInfoMapper;

    @RequestMapping(value = "/getNewsInfo.do",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllNews(String callback){
        ResultMap resultMap = new ResultMap();
        try {
            List<NewsInfo> newsInfoList = newsInfoMapper.listAllNews();
            resultMap.setSuccess(true);
            resultMap.setData("data",newsInfoList);
        }catch (Exception e){
            resultMap.setERROR(e.getMessage());
        }
        return resultMap.toJsonString(callback,resultMap);
    }
}
