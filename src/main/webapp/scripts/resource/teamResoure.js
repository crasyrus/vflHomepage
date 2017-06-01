app.factory('Team', function ($resource) {
  var teamRes = $resource('/team/:shortName', {shortName: '@teamShortName'},
          {'get': {
              method: 'GET',
              transformResponse: transformTeam},
            'query': {
              method: 'GET',
              isArray: true,
              transformResponse: transformTeamArray},
            'getTeamNames': {
              method: "GET",
              url: "/team/names",
              isArray: true
            }
          });

  function transformTeam(data, headersGetter, status) {
    var team = angular.fromJson(data);

//@todo muss auch irgendwie von jackson möglich sein
    if (team.trainingtimeList) {
      for (var i = 0; i < team.trainingtimeList.length; i++) {
        team.trainingtimeList[i].startTime = moment(team.trainingtimeList[i].startTime, "HH:mm").toDate();
        team.trainingtimeList[i].endTime = moment(team.trainingtimeList[i].endTime, "HH:mm").toDate();
      }
    }

    return team;
  }

  function transformTeamArray(data, headersGetter, status) {
    var result = angular.fromJson(data);
    angular.forEach(result, function (team) {
      for (var i = 0; i < team.trainingtimeList.length; i++) {
        team.trainingtimeList[i].startTime = moment(team.trainingtimeList[i].startTime, "HH:mm").toDate();
        team.trainingtimeList[i].endTime = moment(team.trainingtimeList[i].endTime, "HH:mm").toDate();
      }
    });

    return result;
  }

//  var cache = teamRes.query();
//  teamRes.getCachedTeams = function () {
//    return cache;
//  };
//
//  teamRes.getTeamToShortName = function (shortName) {
//    return cache.find(function (value) {
//      return shortName === value.shortName;
//    });
//  };

  return teamRes;
});

