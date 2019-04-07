package com.xaau.bs.busx.manager.mapper;

import com.xaau.bs.busx.manager.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
  @Insert("insert into user(userName, password) values(#{userName}, #{password})")
  int addUser(@Param("userName") String userName, @Param("password") String password);

  @Update("update user set password = #{password} where userID = #{userID}")
  int updateUser(@Param("userName") String userName, @Param("password") String password, @Param("userID") int  userID);

  @Delete("delete from user where userID = #{userID}")
  int deleteUser(int userID);

  @Select("select userID, userName as userName from user where userID = #{userID}")
  User findUser(@Param("userID") int userID);

  @Select("select userID, userName as userName from user")
  List<User> findUserList();
}
