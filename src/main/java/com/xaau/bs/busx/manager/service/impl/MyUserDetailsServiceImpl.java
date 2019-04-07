package com.xaau.bs.busx.manager.service.impl;

import com.xaau.bs.busx.manager.entity.Admin;
import com.xaau.bs.busx.manager.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Mr.Tsang
 * @date 2019/4/6
 */
public class MyUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private AdminMapper adminMapper;
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Admin admin=adminMapper.selectAdmin(s);
    if (admin!=null) {
      return admin;
    }else {
      throw new UsernameNotFoundException("UserNotFound");
    }
  }
}
