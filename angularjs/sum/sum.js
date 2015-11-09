'use strict';

angular.module('sum', [])
  .controller('sumCtrl', function($scope, $http) {
    $scope.calculate = function(value1, value2) {
      var requestParams = {
        method: 'POST',
        url: 'http://localhost:8080/service/math',
        headers: { 'Content-Type': 'application/json' },
        data: { 'requestBean': { 'value1':value1, 'value2':value2 }}
      };

      $http(requestParams).then(function(evt) {
        $scope.valor = evt.data.responseBean.result;
      });
    };

  });
