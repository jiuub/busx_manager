package com.xaau.bs.busx.manager.service;

import com.xaau.bs.busx.manager.entity.BusStation;
import com.xaau.bs.busx.manager.entity.Station;

import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
public interface LineService {
  List<Station> stations();

  /**
   * 通过ic direction 获取线路
   * @param id 车辆ID
   * @param direction 运行方向
   * @return List<BusStation>
   */
  List<BusStation> getLineByIdDir(int id , String direction);

  /**
   * getBusCity
   * @param id
   * @return
   */
  String getBusCity(int id);

  /**
   * 获取staID
   * @param staName
   * @param staCity
   * @return
   */
  Integer getStaId(String staName, String staCity);

  /**
   * 车辆插入站点
   * @param busId
   * @param stationId
   * @param direction
   * @param stationNo
   * @return
   */
  int insertLine(int busId,int stationId,String direction,int stationNo);

  /**
   * 删除车辆站点
   * @param busId
   * @param staNo
   * @param direction
   * @return
   */
  int delBusStation(int busId,int staNo,String direction);
}
