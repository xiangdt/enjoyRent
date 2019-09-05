package com.newer.mapper;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user values(null,#{username},#{password},#{name},#{sex},#{cardid}," +
            "#{mobile},#{email},#{address},#{userstate},#{frontcardimg},#{versocardimg},#{licenseimg},#{licensenum},#{jointime})")
    int addUser(User user);
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where username=#{username}")
    User findByname(@Param("username") String username);

    @Update("update user set username=#{username},password=#{password},name=#{name},cardid=#{cardid},mobile=#{mobile}," +
            "email=#{email},address=#{address},userstate=#{userstate},frontcardimg=#{frontcardimg},versocardimg=#{versocardimg}," +
            "licenseimg=#{licenseimg},licensenum=#{licensenum},jointime=#{jointime} where userid=#{userid}")
    int update(User user);

    @Select("select count(userid) from user where username=#{username}")
    int findByUsername(@Param("username")String username);

}
