app.controller('UploadCtrl', function ($scope, $routeParams,$filter, fileUpload, Team) {
    var team = Team.get({shortName: $routeParams.team});
    
    $scope.uploadFile = function () {
      var file = $scope.myFile;
      var name = team.name;
      var date = $filter('date')(new Date(), 'yyyy-MM-dd');
      console.log('file is ' + JSON.stringify(file));
      var uploadUrl = "/archive/upload";
      fileUpload.uploadFileToUrl(uploadUrl, file, name, date);
    };
  });

app.controller('ArchiveCtrl', function ($scope, $http) {
  $scope.search = function (name, date) {
    $http.get("/archive/documents", {
      params: {
        person: name,
        date: date
      }
    }).success(function (response) {
      $scope.metadataList = response;
    });
  };
});
