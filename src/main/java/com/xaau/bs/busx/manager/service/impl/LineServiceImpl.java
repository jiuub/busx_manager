package com.xaau.bs.busx.manager.service.impl;

import com.xaau.bs.busx.manager.entity.BusStation;
import com.xaau.bs.busx.manager.entity.Station;
import com.xaau.bs.busx.manager.mapper.LineMapper;
import com.xaau.bs.busx.manager.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
@Service("LineService")
public class LineServiceImpl implements LineService {
  @Autowired
  private LineMapper lineMapper;
  @Override
  public List<Station> stations() {
    return lineMapper.stations();
  }

  @Override
  public List<BusStation> getLineByIdDir(int id, String direction) {
    return lineMapper.busStations(id,direction);
  }

  @Override
  public String getBusCity(int id) {
    return lineMapper.getBusCity(id);
  }

  @Override
  public Integer getStaId(String staName, String staCity) {
    return lineMapper.getStaId(staName,staCity);
  }

  @Override
  public int insertLine(int busId, int stationId, String direction, int stationNo) {
    return lineMapper.insertLine(busId,stationId,direction,stationNo);
  }

  @Override
  public int delBusStation(int busId, int staNo, String direction) {
    return lineMapper.delBusStation(busId,staNo,direction);
  }

}
