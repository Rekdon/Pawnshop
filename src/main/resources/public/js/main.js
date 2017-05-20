var app = angular.module("Start",[]);

app.controller("FirstController", function ($scope) {
    $scope.goods = [{
        id: '1',
        codeGoods: '2',
        nameGoods: 'Пилосос',
        firstPrice:'5000',
        goodsDescription:'Потужний пилосос'
    }];
});
