package com.lb.util;

import com.lb.entity.CityEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/2/21
 * @ Description：
 * @ Modified By：
 */
public class QueryUtil {

    public static List<CityEntity> queryCityEntity(int pid) throws SQLException {
        String sql = "select * from city where pid=" + pid;
        MySqlDBUtil mySqlDBUtil = new MySqlDBUtil();
        ResultSet rs = mySqlDBUtil.select(sql);
        List<CityEntity> cityEntityList = new ArrayList<>();
        CityEntity cityEntity;
        while (rs.next()){
            cityEntity = new CityEntity();
            cityEntity.setId(rs.getInt("id"));
            cityEntity.setName(rs.getString("name"));
            cityEntity.setPid(rs.getInt("pid"));
            cityEntity.setIsParent(true);
            cityEntityList.add(cityEntity);
        }
        return cityEntityList;
    }
}
