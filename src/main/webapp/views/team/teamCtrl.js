app.controller('TeamCtrl',
        function ($scope, $routeParams, $locale, $sce, Team, Match) {
          $scope.team = Team.get({shortName: $routeParams.team});
          $scope.$sce = $sce;
          
          $scope.nextMatch = Match.nextToTeam({shortName: $routeParams.team});
          $scope.prevMatch = Match.prevToTeam({shortName: $routeParams.team});
          $scope.matches = Match.query({shortName: $routeParams.team});
          
          $scope.days = $locale.DATETIME_FORMATS.DAY;
        }
);

