package com.xaau.bs.busx.manager.mapper;

import com.xaau.bs.busx.manager.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/4/6
 */
@Repository
public interface AdminMapper {
  /**
   * 根据用户名查询返回信息
   * @param username
   * @return
   */
  @Select("select * from admin where username = #{username}")
  Admin selectAdmin(@Param("username") String username);

  /**
   * 获取管理员列表
   * @return
   */
  @Select("select * from admin")
  List<Admin> adminList();

  /**
   * 添加管理员
   * @param username
   * @param password
   * @param role
   * @return
   */
  @Insert("insert into admin(username, password, role) values(#{username}, #{password}, #{role})")
  int insertAdmin(@Param("username") String username,
                  @Param("password") String password,
                  @Param("role") String role);

  /**
   * 删除管理员
   * @param id
   * @return
   */
  @Delete("delete from admin where id = #{id}")
  int deleteAdmin(int id);
}
