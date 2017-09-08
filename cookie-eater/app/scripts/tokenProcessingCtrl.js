(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .controller('TokenProcessingCtrl', TokenProcessingCtrl);

    function TokenProcessingCtrl($scope, $http, $stateParams, $state, tokenStorage) {

        tokenStorage.set($stateParams.access_token);
        $state.go('welcome');
    }

})();
