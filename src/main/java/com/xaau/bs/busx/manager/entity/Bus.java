package com.xaau.bs.busx.manager.entity;

import java.sql.Time;

/**
 * description:
 * 
 * @author Mr.Tsang
 * @date 2019/3/23
 */
public class Bus {
  private int busID;
  private String busName;
  private String busCity;
  private int busPrice;
  private Time busStart;
  private Time busEnd;

  public int getBudID() {
    return busID;
  }

  public void setBudID(int busID) {
    this.busID = busID;
  }

  public String getBusName() {
    return busName;
  }

  public void setBusName(String busName) {
    this.busName = busName;
  }

  public String getBusCity() {
    return busCity;
  }

  public void setBusCity(String busCity) {
    this.busCity = busCity;
  }

  public int getBusPrice() {
    return busPrice;
  }

  public void setBusPrice(int busPrice) {
    this.busPrice = busPrice;
  }

  public Time getBusStart() {
    return busStart;
  }

  public void setBusStart(Time busStart) {
    this.busStart = busStart;
  }

  public Time getBusEnd() {
    return busEnd;
  }

  public void setBusEnd(Time busEnd) {
    this.busEnd = busEnd;
  }
}
