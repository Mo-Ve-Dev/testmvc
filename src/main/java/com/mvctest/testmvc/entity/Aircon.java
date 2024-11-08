package com.mvctest.testmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aircon {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id_aircon;
  private String brand;
  private Float market_price;
  private Integer ac_usage;
  private Integer coolingCap;

  public Integer getId_aircon() {
    return id_aircon;
  }
  public String getBrand() {
    return brand;
  }
  public Float getMarket_price() {
    return market_price;
  }
  public Integer getUsage() {
    return ac_usage;
  }
  public Integer getCoolingCap() {
    return coolingCap;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setCoolingCap(Integer coolingCap) {
    this.coolingCap = coolingCap;
  }
  public void setId_aircon(Integer id_aircon) {
    this.id_aircon = id_aircon;
  }
  public void setMarket_price(Float market_price) {
    this.market_price = market_price;
  }
  public void setUsage(Integer ac_usage) {
    this.ac_usage = ac_usage;
  }
}
