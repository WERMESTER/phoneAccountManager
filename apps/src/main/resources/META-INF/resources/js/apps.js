angular.module('phoneManager',['ui.bootstrap'])
.controller('accountsController', ['$scope', '$http', function($scope, $http){
    $scope.accounts =[]
    $http.get('/services/accounts').
      success(function(data) {
        $scope.accounts = data;
      }).
      error(function(data, status, headers, config) {
        $scope.error = "Fail on fetch accounts"
      });
      $scope.selected
      $scope.view = function(account){
        $scope.selected =account;
      }
      $scope.unView = function(account){
         $scope.selected = null;
      }
}])
