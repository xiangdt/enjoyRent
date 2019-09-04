package com.newer.mapper;

import com.newer.domain.CarType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CarTypeMapper {

    @Select("select * from cartype where typeid=#{typeId}")
    CarType findByNo(@Param("typeId")int typeid);

}
