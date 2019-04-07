package com.xaau.bs.busx.manager.tools;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/4/4
 */
public class AdminTools {
  public static String getPrincipal(){
    String userName = null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
      userName = ((UserDetails)principal).getUsername();
    } else {
      userName = principal.toString();
    }
    return userName;
  }
}
