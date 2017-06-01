(function () {
  'use strict';

  app
          .factory('swDialogServ', DialogService)
          .controller('swDialogCtrl', DialogCtrl);

  function DialogService($mdDialog) {

//all except title and template should be within options
    function open(title, dlgTemplate, closeable, event, options) {
      return $mdDialog.show({
        controller: 'swDialogCtrl',
        templateUrl: 'components/dialog/dialog.temp.html',
        parent: angular.element(document.body),
        targetEvent: event,
        clickOutsideToClose: closeable || true,
        onComplete: onComplete,
        locals: {
          title: title,
          closeable: closeable,
          dlgTemplate: dlgTemplate,
          options: options
        }
      });

    }

    function onComplete() {
      var dialog = document.getElementsByTagName('md-dialog-content');
      var focus = dialog[0].querySelector('[autofocus]');
      if (focus) {
        focus.focus();
        focus.select();
      }
    }

    return{
      open: open
    };
  }

  function DialogCtrl($scope, $mdDialog, title, closeable, dlgTemplate, options) {

    $scope.closeable = closeable;
    $scope.dlgTemplate = dlgTemplate;
    $scope.actions = {};
    $scope.actionsAvailable = false;
    $scope.options = options || {};
    $scope.title = title;


    $scope.close = function (message) {
      return $mdDialog.hide(message);
    };
  }
})();