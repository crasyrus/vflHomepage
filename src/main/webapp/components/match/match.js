(function () {
  'use strict';

  app.directive('swMatch', MatchDirective);

  function MatchDirective() {
    return {
      scope: {
        title: '@',
        match: '='
      },
      restrict: 'E',
      templateUrl: 'components/match/match.temp.html'
    };
  }
})();