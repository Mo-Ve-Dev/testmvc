package com.mvctest.testmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvctest.testmvc.entity.Aircon;
import com.mvctest.testmvc.repository.AirconRepository;


// @RequestMapping(path = "/demo")
@Controller
public class AirconController {

  @Autowired
  private AirconRepository airconRepository;


  @PostMapping(path = "/api/add")
  public @ResponseBody String addNewAircon (
  @RequestParam String brand,
  @RequestParam Float market_price,
  @RequestParam Integer ac_usage,
  @RequestParam Integer coolingCap 
  ){
    Aircon n = new Aircon();
    n.setBrand(brand);
    n.setMarket_price(market_price);
    n.setUsage(ac_usage);
    n.setCoolingCap(coolingCap);
    airconRepository.save(n);

    return "Tersimpan";
  }

  @GetMapping(path = "/api/all")
  public @ResponseBody Iterable<Aircon> getAllAircon(){
    return airconRepository.findAll();
  }

  @GetMapping(path = "/api/aliyah")
  public @ResponseBody String maknjas(){
    return "SAKMADAH";
  }



}
