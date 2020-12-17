
var app = angular.module("MedicineManagement", []);

// Controller Part
app.controller("MedicineController", function ($scope, $http) {
  $scope.medicines = [];
  $scope.medicine = {
    name: "",
    price: ""
  };
  var _id;
  _refreshMedicineData();
$scope.create = function() {
        $http({
            method: "POST",
            url: '/api/medicines/create',
            data: JSON.stringify($scope.medicine),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  $scope.delete = function (medicine) {
    $http({
      method: 'DELETE',
      url: '/api/medicines/delete/' + medicine.id
    }).then(_success, _error);
  };


  $scope.submit = function() {
       $http({
            method: "PUT",
            url: '/api/medicines/update/' + _id,
            data: JSON.stringify($scope.medicine),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  // In case of edit
  $scope.edit = function (medicine) {
    _id = medicine.id;
    $scope.medicine.name = medicine.name;
    $scope.medicine.price = medicine.price;

  };

  function _refreshMedicineData() {
    $http({
      method: 'GET',
      url: '/api/medicines/getAll'
    }).then(
      function (res) { // success
        $scope.medicines = res.data;
      },
      function (res) { // error
        console.log("Error: " + res.status + " : " + res.data);
      }
    );
  }

  function _success(res) {
        _refreshMedicineData();
        _clearFormData();
    }

  function _error(res) {
    var data = res.data;
    var status = res.status;
    var header = res.header;
    var config = res.config;
    alert("Error: " + status + ":" + data);
  }
  function _clearFormData() {
        $scope.medicine.name = "";
        $scope.medicine.price = "";

    };
});