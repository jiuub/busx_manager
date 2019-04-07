package com.xaau.bs.busx.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xaau.bs.busx.manager.entity.User;
import com.xaau.bs.busx.manager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/17
 */
@Controller
@RequestMapping("/user")
public class UserController {
  @Resource(name = "UserService")
  private UserService userService;

  @RequestMapping(value = "list" , method = RequestMethod.GET)
  public String getUsers(HttpServletRequest request, ModelMap model,
                                 @RequestParam(required=true,defaultValue="1") int page,
                                 @RequestParam(required=false,defaultValue="5") int size) {
    PageHelper.startPage(page,size);
    List<User> userList=userService.findUserList();
    PageInfo<User> pageInfo=new PageInfo<User>(userList);
    model.addAttribute("users",userList);
    model.addAttribute("page",pageInfo);
    return "user/list";
  }

  @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
  public User getUserById(@PathVariable("userID") int userID) {
    return userService.findUser(userID);
  }

  @RequestMapping(value = "/{userID}", method = RequestMethod.PUT)
  public String updateUser(@PathVariable("userID") int userID, @RequestParam(value = "userName", required = true) String userName,
                              @RequestParam(value = "password", required = true) String password) {
    int t= userService.updateUser(userName,password,userID);
    if(t==1) {
      return "redirect:/user/list";
    }else {
      return "fail";
    }

  }

  @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
  public String deleteUser(@PathVariable(value = "userID")int userID) {
    int t= userService.deleteUser(userID);
    if(t==1) {
      return "redirect:/user/list";
    }else {
      return "fail";
    }
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public String postUser(@RequestParam(value = "userName") String userName,
                            @RequestParam(value = "password") String password) {

    int t= userService.addUser(userName,password);
    if(t==1) {
      return "redirect:/user/list";
    }else {
      return "fail";
    }

  }

}
