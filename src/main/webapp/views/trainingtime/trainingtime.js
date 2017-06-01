app.controller('TrainingtimeCtrl',
        function ($scope, Team, $locale) {
          $scope.teams = Team.query();
          
          $scope.days = $locale.DATETIME_FORMATS.DAY;
        }
);

