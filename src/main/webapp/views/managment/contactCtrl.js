app.controller('ContactManagementCtrl',
        function ($scope, $routeParams, Management) {
          $scope.mail = {};
          
          $scope.send = function() {
            Management.sendMail($routeParams.id, $scope.mail);
          };
        }
);

