package com.xaau.bs.busx.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.xaau.bs.busx.manager.tools.AdminTools.getPrincipal;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/19
 */
@Controller
public class TemplatesController {
  @GetMapping("/index")
  public String index(ModelMap modelMap){
    modelMap.addAttribute("user",getPrincipal());
    return "index";
  }
  @RequestMapping("/")
  public String welcome(){
    return "welcome";
  }
  @GetMapping("/login")
  public String login(@RequestParam(value = "error",required = false) String error,
                      @RequestParam(value = "logout",required = false) String logout,
                      Model model){
    if (error!=null){
      model.addAttribute("errorMsg","登录失败");
    }else if (logout!=null){
      model.addAttribute("logoutMsg","退出成功");
    }
    return "login";
  }
}
