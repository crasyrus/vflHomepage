app.factory('userServ', function ($http, $location, $q, Team, sidenavServ) {
  var roles = [];
  var teams = [];
  var authenticated = false;

//  function authenticate(credentials, callback) {
//
//    var headers = credentials ? {authorization: "Basic "
//              + btoa(credentials.username + ":" + credentials.password)
//    } : {};
//
//    $http.get('user', {headers: headers}).success(function (data) {
//      if (data.name) {
//        roles = [];
//        angular.forEach(data.authorities, function (authority) {
//          roles.push(authority.authority);
//        });
//
//        var teamNames = Team.getTeamNames(function () {
//          angular.forEach(teamNames, function (teamName) {
//            if (hasRole("ROLE_" + teamName[0].toUpperCase())) {
//              teams.push(teamName);
//            }
//          });
//        });
//
//        authenticated = true;
//      } else {
//        authenticated = false;
//      }
//      callback && callback();
//    }).error(function () {
//      authenticated = false;
//      callback && callback();
//    });
//  }

  function login(credentials) {
    var config = {
      headers: {'Content-Type': 'application/x-www-form-urlencoded'},
      transformRequest: function (obj) {
        var str = [];
        for (var p in obj)
          str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
        return str.join("&");
      }
    };

    return $q(function (resolve, reject) {
      $http.post("/login", credentials, config).then(
              function (response) {
                $http.get('user').success(function (data) {
                  if (data.name) {
                    roles = [];
                    teams = [];
                    angular.forEach(data.authorities, function (authority) {
                      roles.push(authority.authority);
                    });

                    var teamNames = Team.getTeamNames(function () {
                      angular.forEach(teamNames, function (teamName) {
                        if (hasRole("ROLE_" + teamName[0].toUpperCase())) {
                          teams.push(teamName);
                        }
                      });
                    });

                    authenticated = true;
                    resolve(response.data);
                  } else {
                    authenticated = false;
                    reject(response);
                  }
                }).error(function () {
                  authenticated = false;
                  reject(response);
                });
              }, function (response) {
        reject(response);
      });
    });
  }

  function logout() {
    $http.get("/logout").then(function () {
      authenticated = false;
      $location.path("/");
      sidenavServ.setItemset("Default");

    });
  }

  function isAuthenticated() {
    return authenticated;
  }

  function hasRole(role) {
    return roles.indexOf(role) >= 0;
  }

  function getTeams() {
    return teams;
  }

  return {
    authenticate: login,
    isAuthenticated: isAuthenticated,
    logout: logout,
    hasRole: hasRole,
    getTeams: getTeams
  };
});

