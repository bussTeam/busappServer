package com.springapp.mvc;

import com.alibaba.fastjson.JSON;
import com.springapp.dao.NewsInfoMapper;
import com.springapp.pojo.NewsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by bin.zhang on 2014/7/18.
 */
@Controller
public class NewsInfoController {

//    @Resource
//    NewsInfoMapper newsInfoMapper;

    @RequestMapping(value = "/getNewsInfo.do",method = RequestMethod.GET)
    @ResponseBody
    public String getUserList(){
//        NewsInfo newsInfo = newsInfoMapper.selectByPrimaryKey(1);
//        return JSON.toJSONString(newsInfo);
        return "";
    }
}
