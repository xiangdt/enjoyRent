package com.newer.mapper;

import com.newer.domain.Car;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarMapper {


    @Results(value = {@Result(property = "carId",column = "carid",id = true),
            @Result(property = "plateNumeber",column = "platenumeber"),
            @Result(property = "fuel",column = "fuel"),
            @Result(property = "state",column = "state"),
            @Result(property = "parkId",column = "parkid"),
            @Result(property = "type",column = "type",javaType = com.newer.domain.CarType.class,
                    one = @One(select = "com.newer.mapper.CarTypeMapper.findByNo"))
    })
    @Select("select * from car")
    List<Car> findAll();
}
