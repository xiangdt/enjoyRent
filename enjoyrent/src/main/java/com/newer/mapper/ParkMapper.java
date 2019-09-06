package com.newer.mapper;

import com.newer.domain.Park;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ParkMapper {
    @Select("select * from park")
    List<Park> findAll();

    @Update("update park set null,sum=#{sum},site=#{site} where parkid=#{parkid}")
    int updateP(Park park);

    @Insert("insert info park values(null,#{sum},#{site})")
    int addP(Park park);
}
