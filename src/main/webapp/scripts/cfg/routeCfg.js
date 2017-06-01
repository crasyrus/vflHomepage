app.config(function ($locationProvider, $routeProvider) {
//  $locationProvider.hashPrefix('!');

  $routeProvider.when("/", {
    templateUrl: "views/landing/landing.html",
    controller: "LandingCtrl"
  }).when("/team/:team", {
    templateUrl: "views/team/team.html",
    controller: "TeamCtrl"
  }).when("/trainingszeiten", {
    templateUrl: "views/trainingtime/trainingtime.html",
    controller: "TrainingtimeCtrl"
  }).when("/trainer/:id", {
    templateUrl: "views/trainer/contact.html",
    controller: "ContactTrainerCtrl"
  }).when("/impressum", {
    templateUrl: "views/impressum/impressum.html"
  }).when("/login", {
    templateUrl: "views/login/login.html",
    controller: "LoginCtrl"
  }).when("/vorstand", {
    templateUrl: "views/managment/managment.html",
    controller: "ManagementCtrl"
  }).when("/vorstand/:id", {
    templateUrl: "views/managment/contact.html",
    controller: "ContactManagementCtrl"
  }).when("/download", {
    templateUrl: "views/download/download.html",
    controller:'DownloadCtrl'
  }).otherwise({
    redirectTo: "/"
  });
});

