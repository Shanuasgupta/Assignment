package com.example.demo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weather")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)
public class Weather {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String description;
        private Double temperature;
        private Double minTemperature;
        private Double maxTemperature;
        private Double pressure;
        private Double airSpeed;
        private Double humidity;


        @Column(nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        private Date createdAt =new Date();

        @Column(nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @LastModifiedDate
        private Date updatedAt= new Date();

        private boolean isDeleted = false;

        public Weather(String description, Double temperature, Double minTemperature, Double maxTemperature, Double pressure, Double airSpeed, Double humidity) {
                this.description = description;
                this.temperature = temperature;
                this.minTemperature = minTemperature;
                this.maxTemperature = maxTemperature;
                this.pressure = pressure;
                this.airSpeed = airSpeed;
                this.humidity = humidity;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Double getTemperature() {
                return temperature;
        }

        public void setTemperature(Double temperature) {
                this.temperature = temperature;
        }

        public Double getMinTemperature() {
                return minTemperature;
        }

        public void setMinTemperature(Double minTemperature) {
                this.minTemperature = minTemperature;
        }

        public Double getMaxTemperature() {
                return maxTemperature;
        }

        public void setMaxTemperature(Double maxTemperature) {
                this.maxTemperature = maxTemperature;
        }

        public Double getPressure() {
                return pressure;
        }

        public void setPressure(Double pressure) {
                this.pressure = pressure;
        }

        public Double getAirSpeed() {
                return airSpeed;
        }

        public void setAirSpeed(Double airSpeed) {
                this.airSpeed = airSpeed;
        }

        public Double getHumidity() {
                return humidity;
        }

        public void setHumidity(Double humidity) {
                this.humidity = humidity;
        }

        public Date getCreatedAt() {
                return createdAt;
        }

        public Date getUpdatedAt() {
                return updatedAt;
        }

        public  Weather(){}
        // Getters and Setters ... (Omitted for brevity)
    }

