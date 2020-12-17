
var app = angular.module("PatientManagement", []);

// Controller Part
app.controller("PatientController", function ($scope, $http) {
  $scope.patients = [];
  $scope.patient = {
    name: "",
    idcard: "",
    birthday: "",
    address: "",
    phone: ""
  };
  var _id;
  _refreshPatientData();
$scope.create = function() {
        $http({
            method: "POST",
            url: '/api/patients/create',
            data: JSON.stringify($scope.patient),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  $scope.delete = function (patient) {
    $http({
      method: 'DELETE',
      url: '/api/patients/delete/' + patient.id
    }).then(_success, _error);
  };


  $scope.submit = function() {
       $http({
            method: "PUT",
            url: '/api/patients/update/' + _id,
            data: JSON.stringify($scope.patient),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  // In case of edit
  $scope.edit = function (patient) {
    _id = patient.id;
    $scope.patient.name = patient.name;
    $scope.patient.idcard = patient.idcard;
    //$scope.patient.birthday = patient.birthday;
    $scope.patient.address = patient.address;
    $scope.patient.phone = patient.phone;

  };

  function _refreshPatientData() {
    $http({
      method: 'GET',
      url: '/api/patients/getAll'
    }).then(
      function (res) { // success
        $scope.patients = res.data;
      },
      function (res) { // error
        console.log("Error: " + res.status + " : " + res.data);
      }
    );
  }

  function _success(res) {
        _refreshPatientData();
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
        $scope.patient.name = "";
        $scope.patient.idcard = "";
        $scope.patient.address = "";
        $scope.patient.birthday = "";
        $scope.patient.phone = "";
    };
});