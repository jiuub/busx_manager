package com.xaau.bs.busx.manager.service.impl;

import com.xaau.bs.busx.manager.entity.Bus;
import com.xaau.bs.busx.manager.mapper.BusMapper;
import com.xaau.bs.busx.manager.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
@Service("BusService")
public class BusServiceImpl implements BusService {
  @Autowired
  private BusMapper busMapper;
  @Override
  public List<Bus> buses() {
    return busMapper.busList();
  }

  @Override
  public Bus getBusById(int id) {
    return busMapper.selectBus(id);
  }

  @Override
  public int insertBus(String name, String city, int price, Time start, Time end) {
    return busMapper.insertBus(name,city,price,start,end);
  }

  @Override
  public int delBusById(int id) {
    return busMapper.deleteBus(id);
  }

  @Override
  public int updBusById(String name, String city, int price, Time start, Time end, int id) {
    return busMapper.updateBus(name,city,price,start,end,id);
  }
}
