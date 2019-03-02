package com.example.demo.service;

import com.example.demo.entity.Weather;
import com.example.demo.repository.WeatherRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherServiceImpl implements  WeatherService{

    @Autowired
    WeatherRepository weatherRepository;

    @Override
    public List<Weather> dowloadWeatherPDF() {

        return weatherRepository.findAll();
    }

    @Override
    public Weather getWeatherDetails(String cityName) {
        System.out.println("Inside");
        try {
            final String uri = "https://samples.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=753ab56d63c2f6d8155e917cc23a8777";
            Map data = new HashMap();
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(uri, String.class);
            JSONObject result = new JSONObject(response);
            String description = result.getJSONArray("weather").getJSONObject(0).getString("description");
            Double temperature = result.getJSONObject("main").getDouble("temp");
            Double minTemperature = result.getJSONObject("main").getDouble("temp_min");
            Double maxTemperature = result.getJSONObject("main").getDouble("temp_max");
            Double pressure = result.getJSONObject("main").getDouble("pressure");
            Double airSpeed = result.getJSONObject("wind").getDouble("speed");
            Double humidity = result.getJSONObject("main").getDouble("humidity");

//        String subUrl = String.format (Locale.ROOT, "find/name?q=%s", cityName);
//        JSONObject response = doQuery (subUrl);

            Weather weather  = new Weather(description,temperature,minTemperature,maxTemperature,pressure,airSpeed,humidity);
            weatherRepository.save(weather);
            return weather;
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public List <Weather> getWeatherDetailsByDate(Date startDate, Date endDate) {

        return weatherRepository.findAllBycreatedAtBetween(startDate,endDate);
    }

}