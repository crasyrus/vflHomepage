app.controller('AppCtrl',
        function ($scope, $mdSidenav, $location, $mdMedia, swDialogServ,  userServ, sidenavServ) {
   
          $scope.$mdMedia = $mdMedia;
          $scope.userServ = userServ;
          $scope.sidenavServ = sidenavServ;

//          userServ.authenticate();

          $scope.toggleMainMenu = function () {
            $mdSidenav('mainMenu').toggle();
          };

          $scope.openHome = function () {
            $location.path("/");
            sidenavServ.setItemset("Default");
            $mdSidenav('mainMenu').close();
          };

          $scope.openAdmin = function () {
            $location.path("/admin");
            sidenavServ.setItemset("Admin");
            $mdSidenav('mainMenu').close();
          };

          $scope.openLoginDlg = function () {
            swDialogServ.open("Anmelden", "views/login/login.html");
          };
          
          $scope.handleLoginChange = function() {
            if(!userServ.isAuthenticated()){
              $scope.openLoginDlg();
            } else{
              userServ.logout();
            }
              
          }
        }
);