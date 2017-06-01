app.controller('LandingCtrl',
        function ($scope, $mdMedia ) {
          $scope.$mdMedia = $mdMedia;
          
          console.log($mdMedia('gt-md'));
          console.log($mdMedia('gt-xs'));
          console.log(($mdMedia('gt-xs') && !$mdMedia('gt-md')));
        }
);

