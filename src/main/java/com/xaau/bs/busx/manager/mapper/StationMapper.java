package com.xaau.bs.busx.manager.mapper;

import com.xaau.bs.busx.manager.entity.Station;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**:
 *
 * @author Mr.Tsang
 * @date 2019/3/20
 */
@Repository
public interface StationMapper {
  @Insert("insert into station (sta_Name, sta_City, sta_Lng, sta_Lat) values(#{sta_Name}, #{sta_City}, #{sta_Lng}, #{sta_Lat})")
  int addStation(@Param("sta_Name") String sta_Name, @Param("sta_City") String sta_City, @Param("sta_Lng") BigDecimal sta_Lng, @Param("sta_Lat") BigDecimal sta_Lat);

  @Update("update station set sta_Name = #{sta_Name}, sta_City = #{sta_City}, sta_Lng = #{sta_Lng}, sta_Lat = #{sta_Lat} where stationID = #{stationID}")
  int updateStation(@Param("sta_Name") String sta_Name, @Param("sta_City") String sta_City, @Param("sta_Lng") BigDecimal sta_Lng, @Param("sta_Lat") BigDecimal sta_Lat, @Param("stationID") int stationID);

  @Delete("delete from station where stationID = #{stationID}")
  int deleteStation(int stationID);

  @Select("select * from station")
  List<Station> stationList();

  @Select("select * from station where stationID = #{stationID}")
  Station selectStation(@Param("stationID") int stationID);
}
