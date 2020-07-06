package com.tts.WeatherMap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.WeatherMap.model.Zipcode;

@Repository
public interface ZipcodeRepository extends CrudRepository<Zipcode, Long> {
  public List<Zipcode> findAll();
  public List<Zipcode> findAllByOrderByCreatedAtDesc();
}
