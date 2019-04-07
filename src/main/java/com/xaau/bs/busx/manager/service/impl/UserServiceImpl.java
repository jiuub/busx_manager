package com.xaau.bs.busx.manager.service.impl;

import com.xaau.bs.busx.manager.entity.User;
import com.xaau.bs.busx.manager.mapper.UserMapper;
import com.xaau.bs.busx.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserService")
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;
  @Override
  public int addUser(String userName, String password) {
    return userMapper.addUser(userName, password);
  }
  @Override
  public int updateUser(String userName, String password, int userID) {
    return userMapper.updateUser(userName, password, userID);
  }
  @Override
  public int deleteUser(int userID) {
    return userMapper.deleteUser(userID);
  }
  @Override
  public User findUser(int id) {
    return userMapper.findUser(id);
  }
  @Override
  public List<User> findUserList() {
    return userMapper.findUserList();
  }

}
