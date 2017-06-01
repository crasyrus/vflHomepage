(function () {
  'use strict';

  app.directive('swTeamAge', TeamAgeDirective);

  function TeamAgeDirective() {
    return {
      scope: {
        yearStart: '@',
        yearEnd: '@'
      },
      restrict: 'E',
      template: "<span> {{(yearStart| date: 'yyyy') + (yearStart != yearEnd ? (yearEnd ? (' - ' + (yearEnd | date: 'yyyy')) : ' und jünger') : '')}}</span>"
    };
  }
})();