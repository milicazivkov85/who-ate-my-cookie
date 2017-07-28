(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .controller('WelcomeCtrl', WelcomeCtrl);

    function WelcomeCtrl($scope, $resource, $window) {

        function loadSweets() {
            var CookieService = $resource('http://localhost:8080/cookie/');
            $scope.sweetCookies = CookieService.query();
        }

        function loadUser() {
            $scope.loggedInUser = $resource('http://localhost:8080/user/').get();
        }

        $scope.logout = function() {
            $window.location = 'http://localhost:8081/logout';
        };

        loadUser();
        loadSweets();

    }

})();
