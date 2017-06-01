app.factory('News', function ($resource) {
  return $resource('/news/:id', {id: '@id'}, 
  {'getNews': {
      method: "GET",
      url: "/news/team/:shortName",
      isArray: true
    }});
});
