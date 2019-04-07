package com.xaau.bs.busx.manager;

import com.xaau.bs.busx.manager.mapper.AdminMapper;
import com.xaau.bs.busx.manager.mapper.BusMapper;
import com.xaau.bs.busx.manager.mapper.StationMapper;
import com.xaau.bs.busx.manager.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusxManagerApplicationTests {

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private StationMapper stationMapper;
  @Autowired
  private BusMapper busMapper;
  @Autowired
  private AdminMapper adminMapper;


  @Test
  public void addUserTest() {
    System.out.println(userMapper.addUser("666","666"));
  }
  @Test
  public void updateUserTest() {
    System.out.println(userMapper.updateUser("z@z.cm","22222",10001));
  }
  @Test
  public void deleteUserTest() {
    System.out.println(userMapper.deleteUser(10001));
  }
  @Test
  public void findUserTest() {
    System.out.println(userMapper.findUser(10001).getUserName());
  }
  @Test
  public void findUserListTest() {
    System.out.println(userMapper.findUserList());
  }

  @Test
  public void addSta(){
    System.out.println(stationMapper.addStation("ddd","ddd", null,null));
  }
  @Test
  public void updateSta(){
    stationMapper.updateStation("555","555",null,null,34);
  }
  @Test
  public void delSta(){
    stationMapper.deleteStation(34);
  }

  @Test
  public void selectSta(){
    stationMapper.stationList();
  }

  @Test
  public void addBus(){
    busMapper.insertBus("6d669","ddd",2, Time.valueOf("00:00:00"),null);
  }
}