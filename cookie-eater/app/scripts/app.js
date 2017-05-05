(function () {

'use strict';

angular
    .module('cookieEaterApp', [
        'ui.router',
        'ngResource'
    ])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise(function ($injector, $location) {
            $location.path('/welcome');
        });

        $stateProvider
            .state('welcome', {
                url: '/welcome',
                controller: 'WelcomeCtrl',
                templateUrl: 'views/welcome.html'
            })
    }]);

})();
