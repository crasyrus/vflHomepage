app.factory('Management', function ($resource, $http, $mdToast) {
  var managementRes = $resource('/management/:id', {id: '@id'});

  managementRes.sendMail = function (id, mail) {
    $http.post('/management/' + id + '/contact', mail).then(
            function () {
              $mdToast.show($mdToast.simple().textContent("Mail wurde erfolgreich versendet"));
            },
            function(){
              $mdToast.show($mdToast.simple().textContent("Mail konnte nicht versendet werden"));
            }
    );
    ;
  };
  return managementRes;
});
