package com.xaau.bs.busx.manager.entity;

/**
 * description:
 *
 * @author Mr.Tsang
 * @date 2019/3/23
 */
public class BusStation {
  private int busID ;
  private String busName;
  private int stationID ;
  private String sta_Name;
  private String sta_No;

  public int getBusID() {
    return busID;
  }

  public void setBusID(int busID) {
    this.busID = busID;
  }

  public String getBusName() {
    return busName;
  }

  public void setBusName(String busName) {
    this.busName = busName;
  }

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

  public String getSta_No() {
    return sta_No;
  }

  public void setSta_No(String sta_No) {
    this.sta_No = sta_No;
  }
}
