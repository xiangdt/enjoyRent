package com.newer.mapper;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user values(null,#{username},#{password},#{name},#{sex},#{cardid}," +
            "#{mobile},#{email},#{address},null,#{cardimg},#{licenseimg},#{licensenum},#{jointime})")
    int addUser(User user);
    @Select("select * from user")
    List<User> findAll();

}
