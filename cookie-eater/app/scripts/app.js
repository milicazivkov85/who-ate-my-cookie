(function () {

'use strict';

angular
    .module('cookieEaterApp', [
        'ui.router',
        'ngResource'
    ])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise(function ($injector, $location) {
            $location.path('/login');
        });

        $stateProvider
            .state('login', {
                url: '/login',
                controller: 'LoginCtrl'
            }).state('token-receiver', {
                url: '/token-receiver?access_token',
                controller: 'TokenProcessingCtrl'
            })
            .state('welcome', {
                url: '/welcome',
                controller: 'WelcomeCtrl',
                templateUrl: 'views/welcome.html'
            })
    }]);

})();
