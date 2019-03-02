package com.example.demo.repository;

import com.example.demo.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findAllBycreatedAtBetween(Date startDate, Date endDate);

}
