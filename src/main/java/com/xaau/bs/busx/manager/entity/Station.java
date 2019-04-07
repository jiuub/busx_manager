package com.xaau.bs.busx.manager.entity;

import java.math.BigDecimal;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/14
 */
public class Station {
  private int stationID;
  private String sta_Name;
  private String sta_City;
  private BigDecimal sta_Lng;
  private BigDecimal sta_Lat;

  public int getStationID() {
    return stationID;
  }

  public void setStationID(int stationID) {
    this.stationID = stationID;
  }

  public String getSta_Name() {
    return sta_Name;
  }

  public void setSta_Name(String sta_Name) {
    this.sta_Name = sta_Name;
  }

  public String getSta_City() {
    return sta_City;
  }

  public void setSta_City(String sta_City) {
    this.sta_City = sta_City;
  }

  public BigDecimal getSta_Lng() {
    return sta_Lng;
  }

  public void setSta_Lng(BigDecimal sta_Lng) {
    this.sta_Lng = sta_Lng;
  }

  public BigDecimal getSta_Lat() {
    return sta_Lat;
  }

  public void setSta_Lat(BigDecimal sta_Lat) {
    this.sta_Lat = sta_Lat;
  }
}
