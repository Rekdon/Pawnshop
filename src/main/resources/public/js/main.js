var app = angular.module("Start",[]);


app.controller("FirstController", function ($scope,$http) {
    $scope.goods = [];
    $http.get('/api/goods').then(function (response){
        $scope.goods=response.data;
        console.log(response);
    });
});
