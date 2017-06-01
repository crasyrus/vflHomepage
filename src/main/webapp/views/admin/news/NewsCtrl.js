app.controller('NewsCtrl',
        function ($scope, News, $routeParams, Team, $http, $mdToast, fileUpload) {
          $scope.editNews = new News();
          $scope.editNews.text = "";

          var team = Team.get({shortName: $routeParams.team});

          $scope.news = News.getNews({shortName: $routeParams.team});

          $scope.tinymceOptions = {
            height: 400,
            plugins: [
              'advlist autolink lists link image charmap print preview anchor',
              'searchreplace visualblocks code fullscreen ',
              'insertdatetime media table contextmenu paste code'
            ],
            toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | ibrowser',
            content_css: '//www.tinymce.com/css/codepen.min.css',
            image_description: false,

          };

//          tinymce.init({
//            selector: '#newsEditor',
//            language_url: "/lang/tinymce_de.js",
//            height: 400,
//            plugins: [
//              'advlist autolink lists link image charmap print preview anchor',
//              'searchreplace visualblocks code fullscreen',
//              'insertdatetime media table contextmenu paste code'
//            ],
//            toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
//            content_css: '//www.tinymce.com/css/codepen.min.css'
//          });

          $scope.save = function () {
//            $scope.editNews.text = tinymce.activeEditor.getContent();
            $scope.editNews.insertDate = new Date();
            $scope.editNews.category = team.id;
            $scope.editNews.editor = team.name;
            //$scope.news.$save();
            //@todo /admin/jugend/news -> sonst keine sicherheit
            $http.post("/news", $scope.editNews).then(
                    function () {
                      $mdToast.show($mdToast.simple().theme("green").textContent("News gespeichert"));
                    },
                    function () {
                      $mdToast.show($mdToast.simple().theme("red").textContent("News konnte nicht gespeichert werden"));
                    });
          };

          $scope.delete = function (news) {
            news.$delete().then(function () {
              $scope.news = News.getNews({shortName: $routeParams.team});
              $scope.editNews = new News();
            });
          };
//
//          $scope.$on("$destroy", function () {
//            tinymce.remove();
//          });


          $scope.selectNews = function (toDelete) {
            $scope.editNews = toDelete;
            //$scope.news.remove($scope.news.indexof(toDelete));
          };
        });




