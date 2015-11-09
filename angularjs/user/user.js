'use strict';

angular.module('resteasy', [])
  .controller('UserCtrl', function($scope, $http) {
    var urlSrv = 'http://localhost:8080/service/user';

    $scope.users = [];
    $scope.user = {};
    $scope.showForm = false;

    $scope.newUser = function() {
      $scope.user = {};
      $scope.showForm = true;
    };

    $scope.saveUser = function(user) {
      if ((user.userBean.id === undefined) || (user.userBean.id === null)) {
        add(user);
      } else {
        update(user);
      }
      $scope.showForm = false;
    };

    $scope.cancelUser = function() {
      $scope.showForm = false;
    };

    $scope.updateUser = function(user) {
      $scope.showForm = true;
      $scope.user = {
        userBean : {
          'id' : user.userBean.id,
          'name' : user.userBean.name,
          'age' : user.userBean.age,
          'email' : user.userBean.email
        }
      };
    };

    $scope.deleteUser = function(user) {
      del(user);
    };

    function findAll() {
      $http.get(urlSrv).then(function(evt) {
        $scope.users = evt.data;
      });
    };

    findAll();

    function add(user) {
      var requestParams = {
        method: 'POST',
        url: urlSrv,
        headers: { 'Content-Type': 'application/json' },
        data: user
      };

      $http(requestParams).then(function(evt) {
        $scope.users.push(evt.data);
      });
    };

    function update(user) {
      var requestParams = {
        method: 'PUT',
        url: urlSrv,
        headers: { 'Content-Type': 'application/json' },
        data: user
      };

      $http(requestParams).then(function(evt) {
        for (var i = 0; i < $scope.users.length; i++) {
          if ($scope.users[i].userBean.id == user.userBean.id) {
            $scope.users[i] = user;
          }
        }
      });
    };

    function del(user) {
      var requestParams = {
        method: 'DELETE',
        url: urlSrv,
        headers: { 'Content-Type': 'application/json' },
        data: user
      };

      $http(requestParams).then(function(evt) {
        $scope.users.splice($scope.users.indexOf(user), 1);
      });
    };
  });
