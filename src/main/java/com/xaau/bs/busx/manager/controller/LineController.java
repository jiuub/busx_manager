package com.xaau.bs.busx.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xaau.bs.busx.manager.entity.Bus;
import com.xaau.bs.busx.manager.entity.BusStation;
import com.xaau.bs.busx.manager.service.BusService;
import com.xaau.bs.busx.manager.service.LineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
@Controller
@RequestMapping("line")
public class LineController {
  @Resource(name = "LineService")
  private LineService lineService;

  @Resource(name = "BusService")
  private BusService busService;

//  @RequestMapping(value = "stations",method = RequestMethod.GET)
//  @ResponseBody
//  public List<Station> getAllStations(){
//    return lineService.stations();
//  }

  @RequestMapping(value = "list",method = RequestMethod.GET)
  public String getBusLine(ModelMap modelMap,
                           @RequestParam(required = true,defaultValue = "1") int page,
                           @RequestParam(required = false,defaultValue = "8") int size){
    PageHelper.startPage(page,size);
    List<Bus> busList=busService.buses();
    PageInfo<Bus> pageInfo=new PageInfo<Bus>(busList);
    modelMap.addAttribute("lineList",busList);
    modelMap.addAttribute("page",pageInfo);
    return "line/list";
  }

  @RequestMapping(value = "details",method = RequestMethod.POST)
  public String getBusStation(@RequestParam(value = "busID" ,required = true) int busID,
                              @RequestParam(value = "direction",required = true) String direction,
                              ModelMap modelMap){
    Bus bus=busService.getBusById(busID);
    modelMap.addAttribute("busMsg",bus);

    modelMap.addAttribute("dir",direction);

    List<BusStation> busStations=lineService.getLineByIdDir(busID,direction);
    modelMap.addAttribute("busStations",busStations);
    return "line/details";
  }

  @RequestMapping(value = "details/ins",method = RequestMethod.POST)
  @ResponseBody
  public String insertLine(@RequestParam(value = "busID",required = true) int busID,
                           @RequestParam(value = "sta_Name",required = true) String staName,
                           @RequestParam(value = "direction",required = true) String direction,
                           @RequestParam(value = "sta_No",required = true)  int staNo){
    Integer integer=lineService.getStaId(staName,lineService.getBusCity(busID));
    int t=0;
    if (integer!=null){
      t=lineService.insertLine(busID, integer,direction,staNo);
    }
    if (t==1){
      return "success";
    }else {
      return "fail";
    }
  }

  @RequestMapping(value = "details/del",method = RequestMethod.DELETE)
  @ResponseBody
  public String deleteLine(@RequestParam(value = "busID",required = true) int busID,
                           @RequestParam(value = "staNo",required = true) int staNo,
                           @RequestParam(value = "direction",required = true) String direction){
    int t=lineService.delBusStation(busID,staNo,direction);
    if (t==1){
      return "success";
    }else {
      return "fail";
    }
  }
}
