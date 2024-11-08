package com.mvctest.testmvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.mvctest.testmvc.entity.Aircon;

public interface AirconRepository extends CrudRepository<Aircon, Integer> {
  
}
