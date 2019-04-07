package com.xaau.bs.busx.manager.service.impl;

import com.xaau.bs.busx.manager.entity.Admin;
import com.xaau.bs.busx.manager.mapper.AdminMapper;
import com.xaau.bs.busx.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/4/6
 */
@Service("AdminService")
public class AdminServiceImpl implements AdminService {
  @Autowired
  private AdminMapper adminMapper;


  @Override
  public List<Admin> adminList() {
    return adminMapper.adminList();
  }

  @Override
  public int insertAdmin(String name, String pwd, String role) {
    return adminMapper.insertAdmin(name,pwd,role);
  }

  @Override
  public int deleteAdmin(int id) {
    return adminMapper.deleteAdmin(id);
  }
}
