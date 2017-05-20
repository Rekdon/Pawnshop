var app = angular.module("Start",[]);


app.controller("GoodsController", function ($scope,$http) {
    $scope.goods = [];
    $http.get('/api/goods').then(function (response){
        $scope.goods=response.data;
        console.log(response);
    });
});

app.controller("SellersController", function ($scope,$http) {
    $scope.sellers = [];
    $http.get('/api/sellers').then(function (response){
        $scope.sellers=response.data;
        console.log(response);
    });
});

/* app.controller("ClientController", function ($scope) {
    $scope.client = [{
         id: 1,
         sallary: '10000',
         fullName: 'Ганкевич Влад Владиславович',
         dataOfBirth: '10.07.1998',
         placeOfBirth: 'Чернівці',
         sex: 'Чоловіча',
         identificationCode: '1001',

     }];
 })*/

app.controller("ClientController", function ($scope,$http) {
    $scope.client = [];
    $http.get('/api/client').then(function (response){
        $scope.client=response.data;
        console.log(response);
    });
});

app.controller("ChecksController", function ($scope,$http) {
    $scope.checks = [];
    $http.get('/api/checks').then(function (response){
        $scope.checks=response.data;
        console.log(response);
    });
});