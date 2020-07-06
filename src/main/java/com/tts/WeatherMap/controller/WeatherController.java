package com.tts.WeatherMap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherMap.request.Request;
import com.tts.WeatherMap.response.Response;
import com.tts.WeatherMap.service.WeatherService;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    
    @GetMapping
    public String getIndex(Model model) {   
      model.addAttribute("request", new Request());
      model.addAttribute("zipcodes", weatherService.getLastTenZips());
      return "index";
    }
    
    @PostMapping
    public String postIndex(Request request, Model model) {
      Response data = weatherService.getWeather(request.getZipCode());
      model.addAttribute("data", data);
      model.addAttribute("zipcodes", weatherService.getLastTenZips());
      return "index";
    }
    
}
