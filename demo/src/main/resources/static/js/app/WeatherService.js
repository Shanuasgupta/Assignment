'use strict'
angular.module('demo.services', []).factory('WeatherService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.fetchWeatherDetails = function(cityName) {
        var url = CONSTANTS.getWeatherDetailsUrl  + cityName ;
        return $http.get(url);
    }
    service.generatePdf = function() {
        return $http.get(CONSTANTS.generatePdfUrl);
    }

    service.fetchWeatherDetailsByDate= function(startDate, EndDate) {
    var url = CONSTANTS.getFilteredByDateUrl  + startDate +"/"+ EndDate  ;
        return $http.get(url);

     }
    return service;
}]);