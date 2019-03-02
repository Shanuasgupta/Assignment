
var module = angular.module('demo.controllers', []);
module.controller("WeatherController", ["$scope", "WeatherService",
    function($scope, WeatherService) {


        $scope.getDetailsByCityName = function(cityName){
            if(cityName){
                WeatherService.fetchWeatherDetails(cityName).then(function(value) {
                console.log(value.data);
                $scope.weatherData =value ;
                console.log($scope.weatherData);
               }, function(reason) {
                console.log("error occured");
             }, function(value) {
                 console.log("no callback");
            });
            }
            else{
                console.log("Select City Name");
            }
        }


        $scope.getFilteredByDate = function(startDate, endDate){
            if(startDate && endDate ){
                WeatherService.fetchWeatherDetailsByDate(new Date(startDate), new Date(startDate)).then(function(value) {
                    console.log(value.data);
                    $scope.weatherData =value ;
                    console.log($scope.weatherData);
                   }, function(reason) {
                    console.log("error occured");
                 }, function(value) {
                     console.log("no callback");
                });
            }
            else{
                console.log("Select Date First");
            }
        }

        $scope.generatePdf = function() {
            WeatherService.generatePdf().then(function(value) {
                 console.log(value);
                var contentDisposition = value.headers('Content-Disposition');
                var filename = contentDisposition.split(';')[1].split('filename')[1].split('=')[1].trim();
                var blob = new Blob([value.data], {type: 'application/pdf'});
                var downloadUrl = URL.createObjectURL(blob);
                var a = document.createElement("a");
                a.href = downloadUrl;
                a.download = filename;
                document.body.appendChild(a);
                a.click();
            }, function(reason) {
                  console.log("error occured");
              }, function(value) {
                  console.log("no callback");
                 });
        }
    }

]);