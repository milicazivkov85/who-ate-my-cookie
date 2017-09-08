(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .controller('HeaderCtrl', HeaderCtrl);

    function HeaderCtrl($scope, $resource, $window) {

        function loadEater() {
            $scope.loggedInUser = $resource('http://localhost:8080/eater/').get();
        }

        $scope.logout = function() {
            $window.location = 'http://localhost:8081/logout';
        };

        loadEater();

    }

})();
