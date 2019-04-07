package com.xaau.bs.busx.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xaau.bs.busx.manager.entity.Station;
import com.xaau.bs.busx.manager.service.StationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/20
 */
@Controller
@RequestMapping("/station")
public class StationController {
  @Resource(name = "StationService")
  private StationService stationService;

  @RequestMapping(value = "list",method = RequestMethod.GET)
  public String getStations(ModelMap model,
                            @RequestParam(required=true,defaultValue="1") int page,
                            @RequestParam(required=false,defaultValue="10") int size){
    PageHelper.startPage(page,size);
    List<Station> stationList=stationService.getStations();
    PageInfo<Station> pageInfo=new PageInfo<Station>(stationList);
    model.addAttribute("stations",stationList);
    model.addAttribute("page",pageInfo);
    return "station/list";
  }

  @RequestMapping(value = "/{stationID}",method = RequestMethod.DELETE)
  public String deleteSta(@PathVariable(value = "stationID") int stationID){
    int t=stationService.deleteById(stationID);
    if (t==1){
      return "redirect:/station/list";
    }else {
      return "fail";
    }
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  @ResponseBody
  public String addSta(@RequestParam(value = "sta_Name",required = true) String name,
                       @RequestParam(value = "sta_City",required = true) String city,
                       @RequestParam(value = "sta_Lng") BigDecimal lng,
                       @RequestParam(value = "sta_Lat") BigDecimal lat){
    int t=0;
    try {
      t=stationService.add(name,city,lng,lat);
    }catch (Exception e){
      System.out.println("addSta:"+e.getMessage());
    }
    if (t==1){
      return "success";
    }else {
      return "fail";
    }
  }

  @RequestMapping(value = "upd",method = RequestMethod.PUT)
  @ResponseBody
  public String updSta(@RequestParam(value = "stationID") int stationID,
                       @RequestParam(value = "sta_Name",required = true) String name,
                       @RequestParam(value = "sta_City",required = true) String city,
                       @RequestParam(value = "sta_Lng",required = false) BigDecimal lng,
                       @RequestParam(value = "sta_Lat",required = false) BigDecimal lat){
    int t=0;
    try {
      t=stationService.updateById(name,city,lng,lat,stationID);
    }catch (Exception e){
      System.out.println("updSta:"+e.getMessage());
    }
    if (t==1){
      return "success";
    }else {
      return "fail";
    }
  }

  @RequestMapping(value = "/{stationID}", method = RequestMethod.POST)
  public String getOneSta(@PathVariable(value = "stationID") int stationID, ModelMap model){
    Station station=stationService.getStationById(stationID);
    model.addAttribute("oneStation",station);
    return "station/update";
  }
}
