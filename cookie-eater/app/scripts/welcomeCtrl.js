(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .controller('WelcomeCtrl', WelcomeCtrl);

    function WelcomeCtrl($scope, $resource) {

        var CookieService = $resource('http://localhost:8080/cookie/');
        $scope.sweetCookies = CookieService.query();
        console.log($scope.sweetCookies);
    }

})();
