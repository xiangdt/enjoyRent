package com.newer.service;

import com.newer.domain.Car;
import com.newer.mapper.CarMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CarService {

    private SqlSession sqlSession;
    private CarMapper carMapper;

    private void init(){
        sqlSession = SqlSessionUtil.getSqlSession();
        carMapper = sqlSession.getMapper(CarMapper.class);
    }
    public List<Car> find(){
        init();
        List<Car> list = carMapper.findAll();
        SqlSessionUtil.close(sqlSession);
        return list;
    }

}
