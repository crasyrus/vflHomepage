app.controller('DownloadCtrl', function ($scope, $http, $window) {
  $http.get("/archive/documents").success(
          function (response) {
            $scope.metadataList = response;
          });

  $scope.download = function (uuid) {
    //document.location.href = '/archive/documents/' + uuid;
    $window.open("/archive/document/" + uuid);
  };
});

