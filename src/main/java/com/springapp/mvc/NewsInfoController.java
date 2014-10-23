package com.springapp.mvc;

import com.springapp.dao.NewsInfoDao;
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

    @Resource
    private NewsInfoDao newsInfoDao;

    @RequestMapping(value = "/getNewsInfo.do",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserList(){
        Collection<NewsInfo> userInfoList = newsInfoDao.doquery();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("data", userInfoList);
        modelMap.put("success", true);
        return modelMap;
    }
}
