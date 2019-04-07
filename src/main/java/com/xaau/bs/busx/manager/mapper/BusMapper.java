package com.xaau.bs.busx.manager.mapper;

import com.xaau.bs.busx.manager.entity.Bus;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
@Repository
public interface BusMapper {
  @Select("select * from bus")
  List<Bus> busList();

  @Select("select * from bus where busID = #{busID}")
  Bus selectBus(@Param("busID") int busID);

  @Insert("insert into bus (busName, busCity, busPrice, busStart, busEnd) values (#{busName}, #{busCity}, #{busPrice}, #{busStart}, #{busEnd})")
  int insertBus(@Param("busName") String busName, @Param("busCity") String busCity,
                @Param("busPrice") int busPrice, @Param("busStart")Time busStart, @Param("busEnd")Time busEnd);

  @Delete("delete from bus where busID = #{busID}")
  int deleteBus(int busID);

  @Update("update bus set busName=#{busName}, busCity=#{busCity}, busPrice=#{busPrice}, busStart=#{busStart}, busEnd=#{busEnd} where busID = #{busID}")
  int updateBus(@Param("busName") String busName, @Param("busCity") String busCity,
                @Param("busPrice") int busPrice, @Param("busStart")Time busStart, @Param("busEnd")Time busEnd,
                @Param("busID") int busID);
}
