package com.example.demo.service;

import com.example.demo.entity.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherService {


    Weather getWeatherDetails(String cityName);
    List<Weather> dowloadWeatherPDF();
    List <Weather> getWeatherDetailsByDate(Date startDate, Date EndDate) ;
}


