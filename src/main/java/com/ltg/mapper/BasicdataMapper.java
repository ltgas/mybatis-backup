package com.ltg.mapper;

import com.ltg.pojo.Basicdata;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BasicdataMapper {
    List<Basicdata> queryAll();
    Basicdata queryById(Integer id);
    List<Basicdata> queryByName(String name);
    List<Basicdata> queryByNearName(@Param("columnName") String columnName,@Param("columnValue") String columnValue);

    // 分页查询1
    List<Basicdata> queryByLimit(Map<String,Integer> map);

    // 分页查询2
    List<Basicdata> queryByRowBounds();

    // 使用注解方式查询
    @Select("select * from basicdata where id = #{id}")
    Basicdata getBasicdataById(@Param("id") int id);

   /* @Insert("insert into basicdata(sid,first_name,last_name,email,gender,age,member,chinese_score,math_score,english_score,political_score,total_score,ip_address,address,contact_phone,join_date)" +
            "values(#{sid},#{firstName},#{lastName},#{eMail},#{gender},#{age},#{member},#{chineseScore},#{mathScore},#{englishScore},#{politicalScore},#{totalScore},#{ipAddress},#{address},#{contactPhone},#{joinDate}")
    Basicdata addBasicdata(Basicdata basicdata);*/

    Integer addBasicdataInfo(Basicdata basicdata);
}
