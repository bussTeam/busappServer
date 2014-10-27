package com.springapp.mvc;

import com.springapp.dao.NewsInfoMapper;
import com.springapp.pojo.NewsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bin.zhang on 2014/7/18.
 */
@Controller
public class NewsInfoResource extends BaseResource{

    @Resource
    NewsInfoMapper newsInfoMapper;

    @RequestMapping(value = "/getNewsInfo.do",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllNews(String callback){
        try {
            List<NewsInfo> newsInfoList = newsInfoMapper.listAllNews();
            setSuccess(true);
            setData(newsInfoList);
        }catch (Exception e){
            setERROR(e.getMessage());
        }
        return toJsonString();
    }
}
