(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .controller('LoginCtrl', LoginCtrl);

    function LoginCtrl($scope, $window) {
        $window.location = 'http://localhost:8081/oauth/authorize?client_id=cookie-eater-web&response_type=token&scope=read';
    }

})();
