package com.springapp.dao;

import com.springapp.pojo.NewsInfo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by bin.zhang on 2014/7/18.
 */
@Service
public class NewsInfoDao extends SimpleJdbcDaoSupport{

        public Collection<NewsInfo> doquery() {
            String sql = "select userName,`passWord` from userinfo";
            return super.getJdbcTemplate().query(sql,new RowMapper<NewsInfo>() {
                @Override
                public NewsInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                    NewsInfo newsInfo = new NewsInfo();
                    newsInfo.setId(Integer.valueOf(resultSet.getString("id")));
                    newsInfo.setTitle(resultSet.getString("title"));
                    newsInfo.setContent(resultSet.getString("content"));
                    newsInfo.setImage(resultSet.getString("image"));
                    return newsInfo;
                }
            });
        }
}
