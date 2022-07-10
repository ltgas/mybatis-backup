package com.ltg.mapper;

import com.ltg.pojo.Basicdata;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicdataMapper {
    List<Basicdata> queryAll();
    Basicdata queryById(Integer id);
    List<Basicdata> queryByName(String name);
    List<Basicdata> queryByNearName(@Param("columnName") String columnName,@Param("columnValue") String columnValue);
}
