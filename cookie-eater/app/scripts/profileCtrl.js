(function() {

    'use strict';

    angular.module('cookieEaterApp')
        .controller('ProfileCtrl', ProfileCtrl);

    function ProfileCtrl($scope, $resource, uibDateParser) {

        $scope.birthdayPicker = {
            opened: false
        };

        $scope.openBirthdayPicker = function() {
            $scope.birthdayPicker.opened = true;
        };

        $scope.clear = function() {
            $scope.profile.birthday = null;
        };

        $scope.saveProfileChanges = function() {
            $scope.profile.$save();
        };

        function getProfile() {
            var profileResource = $resource('http://localhost:8080/profile/', {},
                {get: {transformResponse: function (data) {
                    var transformedProfile = angular.fromJson(data);
                    transformedProfile.birthday = uibDateParser.parse(transformedProfile.birthday, "yyyy-MM-dd", new Date());
                    return transformedProfile;
                }}});
            $scope.profile = profileResource.get();
        }

        getProfile();
    }

})();
