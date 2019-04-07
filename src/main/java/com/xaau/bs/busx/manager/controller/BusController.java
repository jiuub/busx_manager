package com.xaau.bs.busx.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xaau.bs.busx.manager.entity.Bus;
import com.xaau.bs.busx.manager.service.BusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
@Controller
@RequestMapping("/bus")
public class BusController {
  @Resource(name = "BusService")
  private BusService busService;

  @RequestMapping(value = "list",method = RequestMethod.GET)
  public String getBuses(ModelMap model,
                         @RequestParam(required=true,defaultValue="1") int page,
                         @RequestParam(required=false,defaultValue="5") int size){
    PageHelper.startPage(page,size);
    List<Bus> busList=busService.buses();
    PageInfo<Bus> pageInfo=new PageInfo<Bus>(busList);
    model.addAttribute("buses",busList);
    model.addAttribute("page",pageInfo);
    return "bus/list";
  }

  @RequestMapping(value = "",method = RequestMethod.POST)
  @ResponseBody
  public String insertBus(@RequestParam(value = "busName",required = true) String name,
                          @RequestParam(value = "busCity",required = true) String city,
                          @RequestParam(value = "busPrice",required = true) int price,
                          @RequestParam(value = "busStart",required = false) Time start,
                          @RequestParam(value = "busEnd",required = false) Time end){
    int t=0;
    try {
      t=busService.insertBus(name,city,price,start,end);
    }catch (Exception e){
      System.out.println("insertBusException:"+e.getMessage());
      return "fail";
    }
    if (t==1){
      return "success";
    }else {
      return "fail";
    }
  }

  @RequestMapping(value = "del",method = RequestMethod.DELETE)
  public String delBus(@RequestParam(value = "busID") int busID){
    int t=busService.delBusById(busID);
    if (t==1){
      return "redirect:/bus/list";
    }else {
      return "redirect:/error";
    }
  }

  @RequestMapping(value = "{busID}",method = RequestMethod.POST)
  public String getOneBus(@PathVariable(value = "busID") int busID,ModelMap modelMap){
    Bus bus=busService.getBusById(busID);
    modelMap.addAttribute("bus",bus);
    return "bus/update";
  }

  @RequestMapping(value = "upd",method = RequestMethod.PUT)
  @ResponseBody
  public String updBus(@RequestParam(value = "busName",required = true) String name,
                       @RequestParam(value = "busCity",required = true) String city,
                       @RequestParam(value = "busPrice",required = true) int price,
                       @RequestParam(value = "busStart",required = false) Time start,
                       @RequestParam(value = "busEnd",required = false) Time end,
                       @RequestParam(value = "busID") int id){
    int t=0;
    try {
      t=busService.updBusById(name,city,price,start,end,id);
    }catch (Exception e){
      System.out.println("updBusException:"+e.getMessage());
    }
    if (t==1){
      return "success";
    }else {
      return "fail";
    }
  }
}
