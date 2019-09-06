package com.newer.service;

import com.newer.domain.Park;
import com.newer.mapper.ParkMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ParkService {
    private SqlSession sqlSession;
    private ParkMapper parkMapper;
    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        parkMapper=sqlSession.getMapper(ParkMapper.class);
    }
    public List<Park> findAll(){
        init();
        List<Park> list=parkMapper.findAll();
        SqlSessionUtil.close(sqlSession);
        return list;
    }
    public int addP(Park park){
        init();
        int rows=parkMapper.addP(park);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return rows;
    }
    public int updateP(Park park){
        init();
        int rows=parkMapper.updateP(park);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return rows;
    }
}
