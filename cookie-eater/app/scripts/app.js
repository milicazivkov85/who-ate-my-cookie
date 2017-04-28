(function () {

'use strict';

angular
    .module('cookieEaterApp', [
        'ui.router'
    ])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise(function ($injector, $location) {
            $location.path('/welcome');
        });

        $stateProvider
            .state('welcome', {
                url: '/welcome',
                templateUrl: 'views/welcome.html'
            })
    }]);

})();
