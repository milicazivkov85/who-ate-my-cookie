(function () {

'use strict';

angular
    .module('cookieEaterApp', [
        'ui.router',
        'ui.bootstrap',
        'ngResource'
    ])
    .config(['$locationProvider', function($locationProvider) {
        $locationProvider.hashPrefix('');
    }])
    .config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise(function ($injector, $location) {
            $location.path('/login');
        });

        $stateProvider
            .state('login', {
                url: '/login',
                controller: 'LoginCtrl'
            })
            .state('token-receiver', {
                url: '/token-receiver?access_token',
                controller: 'TokenProcessingCtrl'
            })
            .state('welcome', {
                url: '/welcome',
                controller: 'WelcomeCtrl',
                templateUrl: 'views/welcome.html'
            })
            .state('profile', {
                url: '/profile',
                controller: 'ProfileCtrl',
                templateUrl: 'views/profile.html'
            })
    }])
    .run(['$rootScope', 'tokenStorage', '$http', function ($rootScope, tokenStorage, $http) {

        $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState) {
            $http.defaults.headers.common.Authorization='Bearer '+ tokenStorage.get();
        });

    }])

})();
