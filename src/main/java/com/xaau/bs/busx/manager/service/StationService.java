package com.xaau.bs.busx.manager.service;

import com.xaau.bs.busx.manager.entity.Station;

import java.math.BigDecimal;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/20
 */
public interface StationService {
  List<Station> getStations();
  int add(String name, String city, BigDecimal lng, BigDecimal lat);
  int updateById(String name, String city, BigDecimal lng, BigDecimal lat, int id);
  int deleteById(int id);
  Station getStationById(int id);
}
