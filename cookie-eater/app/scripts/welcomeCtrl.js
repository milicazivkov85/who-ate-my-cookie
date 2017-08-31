(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .controller('WelcomeCtrl', WelcomeCtrl);

    function WelcomeCtrl($scope, $resource, $window) {

        function loadSweets() {
            var CookieService = $resource('http://localhost:8080/cookie/');
            $scope.sweetCookies = CookieService.query();
        }

        function loadEater() {
            $scope.loggedInUser = $resource('http://localhost:8080/eater/').get();
        }

        $scope.logout = function() {
            $window.location = 'http://localhost:8081/logout';
        };

        $scope.eatMe = function(cookie) {
            var cookieResource = $resource('http://localhost:8080/cookie/:cookieId', {cookieId: cookie.id});
            cookieResource.remove(function() {
                loadSweets();
            });
        };

        $scope.eatAll = function() {
            var myCookies = $resource('http://localhost:8080/cookie/');
            myCookies.remove(function() {
                loadSweets();
            });
        };

        loadEater();
        loadSweets();

    }

})();
