
var app = angular.module("NurseManagement", []);

// Controller Part
app.controller("NurseController", function ($scope, $http) {
  $scope.nurses = [];
  $scope.nurse = {
    name: "",
    idcard: "",
    birthday: "",
    address: "",
    phone: "",
    seniority: "",
    literacy: ""
  };
  var _id;
  _refreshNurseData();
$scope.create = function() {
        $http({
            method: "POST",
            url: '/api/nurses/create',
            data: JSON.stringify($scope.nurse),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  $scope.delete = function (nurse) {
    $http({
      method: 'DELETE',
      url: '/api/nurses/delete/' + nurse.id
    }).then(_success, _error);
  };


  $scope.submit = function() {
       $http({
            method: "PUT",
            url: '/api/nurses/update/' + _id,
            data: JSON.stringify($scope.nurse),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  // In case of edit
  $scope.edit = function (nurse) {
    _id = nurse.id;
    $scope.nurse.name = nurse.name;
    $scope.nurse.idcard = nurse.idcard;
    //$scope.nurse.birthday = nurse.birthday;
    $scope.nurse.address = nurse.address;
    $scope.nurse.phone = nurse.phone;
    $scope.nurse.seniority = nurse.seniority;
    $scope.nurse.literacy = nurse.literacy;
  };

  function _refreshNurseData() {
    $http({
      method: 'GET',
      url: '/api/nurses/getAll'
    }).then(
      function (res) { // success
        $scope.nurses = res.data;
      },
      function (res) { // error
        console.log("Error: " + res.status + " : " + res.data);
      }
    );
  }

  function _success(res) {
        _refreshNurseData();
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
        $scope.nurse.name = "";
        $scope.nurse.idcard = "";
        $scope.nurse.address = "";
        $scope.nurse.birthday = "";
        $scope.nurse.phone = "";
        $scope.nurse.seniority = "";
        $scope.nurse.literacy = "";
    };
});