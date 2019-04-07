package com.xaau.bs.busx.manager.service.impl;

import com.xaau.bs.busx.manager.entity.Station;
import com.xaau.bs.busx.manager.mapper.StationMapper;
import com.xaau.bs.busx.manager.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/20
 */
@Service("StationService")
public class StationServiceImpl implements StationService {
  @Autowired
  private StationMapper stationMapper;
  @Override
  public List<Station> getStations() {
    return stationMapper.stationList();
  }

  @Override
  public int add(String name, String city, BigDecimal lng, BigDecimal lat) {
    return stationMapper.addStation(name,city,lng,lat);
  }

  @Override
  public int updateById(String name, String city, BigDecimal lng, BigDecimal lat, int id) {
    return stationMapper.updateStation(name,city,lng,lat,id);
  }

  @Override
  public int deleteById(int id) {
    return stationMapper.deleteStation(id);
  }

  @Override
  public Station getStationById(int id){
    return stationMapper.selectStation(id);
  }
}
