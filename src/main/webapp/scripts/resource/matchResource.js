app.factory('Match', function($resource){
    return $resource('/match/:shortName', {shortName:'shortName'}, {
      nextToTeam: {method: 'GET', url: '/match/:shortName/next' },
      prevToTeam: {method: 'GET', url: '/match/:shortName/prev' }
    });
});

