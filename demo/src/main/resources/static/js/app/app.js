
var demoApp = angular.module('demo', ['demo.controllers',
    'demo.services'
]);
demoApp.constant("CONSTANTS", {
    getWeatherDetailsUrl: "/weather/getWeather/",
    generatePdfUrl: "/weather/pdfReport",
    getFilteredByDateUrl: "/weather/getFilterByDate/",
});
