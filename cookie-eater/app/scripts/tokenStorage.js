(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .service('tokenStorage', ["$window", TokenStorage]);

    function TokenStorage($window) {

        this.set = function(token) {
            $window.localStorage.setItem('oauth.token', token);
        }

        this.get = function() {
            return $window.localStorage.getItem('oauth.token');
        }

        this.clear = function() {
            $window.localStorage.removeItem('oauth.token');
        }
    }

})();
