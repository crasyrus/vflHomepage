app.config(function ($routeProvider) {
  $routeProvider.when("/admin", {
    templateUrl: "views/admin/index.html",
    controller: "LandingCtrl"
  }).when("/admin/:team/news", {
    templateUrl: "views/admin/news/news.html",
    controller: "NewsCtrl"
  }).when("/admin/:team/upload", {
    templateUrl: "views/admin/upload/upload.html",
    controller: "UploadCtrl"
  }).otherwise({
    redirectTo: "/"
  });
});