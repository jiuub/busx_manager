package com.xaau.bs.busx.manager.mapper;

import com.xaau.bs.busx.manager.entity.BusStation;
import com.xaau.bs.busx.manager.entity.Station;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
@Repository
public interface LineMapper {

  @Select("select sta_Name from station")
  List<Station> stations();

  /**
   * 获取某一车辆的所有站点
   * @param busID 车辆ID
   * @param direction 运行方向
   * @return List<BusStation>
   */
  @Select("select `line`.`busID`,`bus`.`busName`,`line`.`stationID`,`station`.`sta_Name`,`line`.`sta_No` " +
          "from ((`bus` join `line` on((`line`.`busID` = `bus`.`busID`))) " +
          "join `station` on((`line`.`stationID` = `station`.`stationID`))) " +
          "where `line`.`busID` = #{busID} and `line`.`direction` = #{direction}" +
          "order by `line`.`sta_No`")
  List<BusStation> busStations(@Param("busID") int busID, @Param("direction") String direction);

  /**
   * 通过 id 获取车辆city
   * @param busID
   * @return
   */
  @Select("select busCity from bus where busID = #{busID}")
  String getBusCity(@Param("busID") int busID);

  /**
   * 通过name city获取站点id
   * @param staName
   * @param staCity
   * @return
   */
  @Select("select stationID from station where sta_Name = #{sta_Name} and sta_City = #{sta_City}")
  Integer getStaId(@Param("sta_Name") String staName,
               @Param("sta_City") String staCity);

  /**
   * 车辆与站点关联
   * @param busID
   * @param stationID
   * @param direction
   * @param staNo
   * @return
   */
  @Insert("insert into line (busID, stationID,direction,sta_No) values (#{busID}, #{stationID}, #{direction}, #{sta_No})")
  int insertLine(@Param("busID") int busID, @Param("stationID") int stationID,
                 @Param("direction") String direction, @Param("sta_No") int staNo);

  /**
   * 车辆与站点删除关联
   * @param busID
   * @param sta_No
   * @param direction
   * @return
   */
  @Delete("delete from line where busID = #{busID} and sta_No = #{sta_No} and direction = #{direction}")
  int delBusStation(@Param("busID") int busID,
                    @Param("sta_No") int sta_No,
                    @Param("direction") String direction);
}

