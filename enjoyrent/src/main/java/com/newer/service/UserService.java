package com.newer.service;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class UserService {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        userMapper=sqlSession.getMapper(UserMapper.class);
    }
    public int addUser(User user){
        init();
        Date date=new Date();
        user.setJointime(date);
        int rows=userMapper.addUser(user);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return rows;
    }
   public List<User> findAll(){
        init();
        List<User> list=userMapper.findAll();
        SqlSessionUtil.close(sqlSession);

        return  list;

   }
}
