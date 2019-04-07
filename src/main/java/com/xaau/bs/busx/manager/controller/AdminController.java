package com.xaau.bs.busx.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xaau.bs.busx.manager.entity.Admin;
import com.xaau.bs.busx.manager.service.AdminService;
import com.xaau.bs.busx.manager.tools.AdminTools;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/4/6
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
  @Resource(name = "AdminService")
  private AdminService adminService;

  @RequestMapping(value = "list",method = RequestMethod.GET)
  public String getAdmins(ModelMap model,
                          @RequestParam(required=true,defaultValue="1") int page,
                          @RequestParam(required=false,defaultValue="5") int size){
    PageHelper.startPage(page,size);
    List<Admin> admins=adminService.adminList();
    PageInfo<Admin> pageInfo=new PageInfo<Admin>(admins);
    model.addAttribute("admins",admins);
    model.addAttribute("page",pageInfo);
    model.addAttribute("currentAdmin",AdminTools.getPrincipal());
    return "admin/list";
  }

  @RequestMapping(value = "",method = RequestMethod.POST)
  @ResponseBody
  public String insAdmin(@RequestParam(value = "username",required = true) String username,
                         @RequestParam(value = "password",required = true) String password){
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    int t=0;
    try{
      t=adminService.insertAdmin(username,encoder.encode(password),"ADMIN");
    }catch (Exception e){
      System.out.println("insAdmin: "+e.getMessage());
    }
    if (t==1){
      return "success";
    }else {
      return "fail";
    }
  }

  @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
  public String delAdmin(@PathVariable(value = "id") int id){
    int t=adminService.deleteAdmin(id);
    if (t==1){
      return "redirect:/admin/list";
    }else {
      return "redirect:/error";
    }
  }

}
