package com.xaau.bs.busx.manager.service;

import com.xaau.bs.busx.manager.entity.Bus;

import java.sql.Time;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
public interface BusService {
  List<Bus> buses();
  Bus getBusById(int id);
  int insertBus(String name, String city, int price, Time start, Time end);
  int delBusById(int id);
  int updBusById(String name, String city, int price, Time start, Time end, int id);

}
