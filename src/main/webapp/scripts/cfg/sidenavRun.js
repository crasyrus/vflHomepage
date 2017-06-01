app.run(function (sidenavServ, Team, $location, $mdSidenav, userServ) {
  createDefaultNav();
  createAdminNav();

  function createDefaultNav() {
    var itemSetName = "Default";
    var teamNames = Team.getTeamNames(function () {
      angular.forEach(teamNames, function (teamName) {
        sidenavServ.addItemToSet(itemSetName, teamName[0], function () {
          openTeam(teamName[1]);
        });
      });
      sidenavServ.addDividerToSet(itemSetName);
      sidenavServ.addItemToSet(itemSetName, "Trainingszeiten", function () {
        openTrainingtime();
      });
      sidenavServ.addItemToSet(itemSetName, "Jugendvorstand", function () {
        openManagement();
      });

      sidenavServ.addItemToSet(itemSetName, "Download", function () {
        openDownload();
      });

      sidenavServ.setTitleToSet("Default", "VfL Grafenwald Jugend");
      sidenavServ.setItemset("Default");
    });

    openTeam = function  openTeam(team) {
      $location.path("/team/" + team);
      $mdSidenav('mainMenu').close();
    };

    function openTrainingtime() {
      $location.path("/trainingszeiten");
      $mdSidenav('mainMenu').close();
    }

    function openManagement() {
      $location.path("/vorstand");
      $mdSidenav('mainMenu').close();
    }

    function openDownload() {
      $location.path("/download");
      $mdSidenav('mainMenu').close();
    }
  }

  function createAdminNav() {
    var itemSetName = "Admin";

    sidenavServ.setTitleToSet("Admin", "VfL Grafenwald Jugend - Admin");
    sidenavServ.addItemToSet(itemSetName, "News", function () {
      $location.path("/admin/" + userServ.getTeams()[0][1] + "/news");
    });

    sidenavServ.addItemToSet(itemSetName, "Upload", function () {
      $location.path("/admin/" + userServ.getTeams()[0][1] + "/upload");
    });

  }
});