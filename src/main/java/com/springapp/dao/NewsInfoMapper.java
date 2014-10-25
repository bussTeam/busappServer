package com.springapp.dao;

import com.springapp.pojo.NewsInfo;

import javax.lang.model.element.NestingKind;
import java.util.List;

public interface NewsInfoMapper {

    List<NewsInfo> listAllNews();

    int deleteByPrimaryKey(Integer id);

    int insert(NewsInfo record);

    int insertSelective(NewsInfo record);

    NewsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsInfo record);

    int updateByPrimaryKeyWithBLOBs(NewsInfo record);

    int updateByPrimaryKey(NewsInfo record);
}