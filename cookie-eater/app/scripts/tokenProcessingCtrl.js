(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .controller('TokenProcessingCtrl', TokenProcessingCtrl);

    function TokenProcessingCtrl($scope, $http, $stateParams, $state) {

        $http.defaults.headers.common.Authorization='Bearer '+ $stateParams.access_token;
        $state.go('welcome');
    }

})();
