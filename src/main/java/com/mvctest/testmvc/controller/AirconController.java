package com.mvctest.testmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvctest.testmvc.entity.Aircon;
import com.mvctest.testmvc.exception.NoDataException;
import com.mvctest.testmvc.repository.AirconRepository;


@RequestMapping(path = "/api")
@Controller
public class AirconController {

  @Autowired
  private AirconRepository airconRepository;


  @PostMapping(path = "/add")
  public @ResponseBody ResponseEntity<ApiResponse<Aircon>>  addNewAircon (
  @RequestParam String brand,
  @RequestParam Float market_price,
  @RequestParam Integer ac_usage,
  @RequestParam Integer coolingCap 
  ){
    try {
      Aircon n = new Aircon();
      n.setBrand(brand);
      n.setMarket_price(market_price);
      n.setUsage(ac_usage);
      n.setCoolingCap(coolingCap);
      airconRepository.save(n);

      ApiResponse<Aircon> res = new ApiResponse<Aircon>("New Aircon Added", n);

      return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    } catch (Exception e) {
      ApiResponse<Aircon> res = new ApiResponse<Aircon>(e.getMessage());
      return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(path = "/all")
  public @ResponseBody ResponseEntity<ApiResponse<Iterable<Aircon>>> getAllAircon(){
    try {
      Iterable<Aircon> airconIterable = airconRepository.findAll();

    ApiResponse<Iterable<Aircon>> res = new ApiResponse<Iterable<Aircon>>("Fetched", airconIterable);
    return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    } catch (Exception e) {
      ApiResponse<Iterable<Aircon>> res = new ApiResponse<Iterable<Aircon>>(e.getMessage());
      return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(path = "/update/{id}")
  public ResponseEntity<ApiResponse<Aircon>> updateAircon(
    @PathVariable("id") Integer id,
    @RequestParam String brand,
    @RequestParam Float market_price,
    @RequestParam Integer ac_usage,
    @RequestParam Integer coolingCap 
  ){
    try {
      Aircon n =  airconRepository.findById(id).orElseThrow(()-> new NoDataException("Air Conditioner Not Found")) ;

      n.setBrand(brand);
      n.setCoolingCap(coolingCap);
      n.setMarket_price(market_price);
      n.setUsage(ac_usage);

      Aircon responseAircon = airconRepository.save(n);
      ApiResponse<Aircon> res = new ApiResponse<Aircon>("Berhasil Ubah Data", responseAircon);

      return new ResponseEntity<>(res, HttpStatus.OK);

    } catch (NoDataException e) {
      ApiResponse<Aircon> res = new ApiResponse<Aircon>(e.getMessage());
      return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }catch (Exception e) {
      ApiResponse<Aircon> res = new ApiResponse<Aircon>(e.getMessage());
      return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }
  }





}
