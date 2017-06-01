app.controller('ManagementCtrl',
        function ($scope, Management) {
          $scope.management = Management.query();
        }
);

