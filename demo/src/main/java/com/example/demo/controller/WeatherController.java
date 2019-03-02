package com.example.demo.controller;

import com.example.demo.entity.Weather;
import com.example.demo.service.WeatherService;
import com.example.demo.util.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RequestMapping("/weather")
@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    /**
     * fetch the weather Details with the city name
     * @param cityName
     * @return
     */
    @RequestMapping("/getWeather/{cityName}")
    public Weather getWeather(@PathVariable("cityName") final String cityName) {
        return weatherService.getWeatherDetails(cityName);
    }

    /**
     * To fetch weather details Data from Database on the behalf of Data range
     * @param startDate
     * @param endDate
     * @return list of Weather object
     * @throws ParseException
     */
    @RequestMapping("/getFilterByDate/{startDate}/{endDate}")
    public List <Weather> getWeatherDetailsByDate(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate) throws ParseException {
        return weatherService.getWeatherDetailsByDate(startDate, endDate);
    }


    /**
     * To generate Pdf of Weather reports
     * @return stream
     * @throws IOException
     */
    @RequestMapping(value = "/pdfReport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generateWeatherPdfReports() throws IOException {

        List<Weather> weather = weatherService.dowloadWeatherPDF();
        ByteArrayInputStream bis = GeneratePdfReport.weatherReport(weather);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=weatherReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
