package com.xaau.bs.busx.manager.service;

import com.xaau.bs.busx.manager.entity.User;

import java.util.List;

public interface UserService {
  int addUser(String userName, String password);
  int updateUser(String userName, String password, int userID);
  int deleteUser(int userID);
  User findUser(int id);
  List<User> findUserList();
}
