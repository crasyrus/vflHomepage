app.controller('ContactTrainerCtrl',
        function ($scope, $routeParams, Trainer) {
          $scope.mail = {};
          
          var self = this;
          $scope.send = function() {
            Trainer.sendMail($routeParams.id, $scope.mail);
          };
        }
);

