package com.xaau.bs.busx.manager.service;

import com.xaau.bs.busx.manager.entity.Admin;

import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/4/6
 */
public interface AdminService {
  List<Admin> adminList();
  int insertAdmin(String name, String pwd, String role);
  int deleteAdmin(int id);
}
