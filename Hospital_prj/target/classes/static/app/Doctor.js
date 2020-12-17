
var app = angular.module("DoctorManagement", []);

// Controller Part
app.controller("DoctorController", function ($scope, $http) {
  $scope.doctors = [];
  $scope.doctor = {
    name: "",
    idcard: "",
    birthday: "",
    address: "",
    expertise: "",
    seniority: "",
	literacy: "",
	joblv: ""
  };
  var _id;
  _refreshDoctorData();
$scope.create = function() {
        $http({
            method: "POST",
            url: '/api/doctors/create',
            data: JSON.stringify($scope.doctor),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  $scope.delete = function (doctor) {
    $http({
      method: 'DELETE',
      url: '/api/doctors/delete/' + doctor.id
    }).then(_success, _error);
  };


  $scope.submit = function() {
       $http({
            method: "PUT",
            url: '/api/doctors/update/' + _id,
            data: JSON.stringify($scope.doctor),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  // In case of edit
  $scope.edit = function (doctor) {
    _id = doctor.id;
    $scope.doctor.name = doctor.name;
    $scope.doctor.idcard = doctor.idcard;
    //$scope.doctor.birthday = doctor.birthday;
    $scope.doctor.address = doctor.address;
    $scope.doctor.expertise = doctor.expertise;
    $scope.doctor.seniority = doctor.seniority;
	$scope.doctor.literacy = doctor.literacy;
	$scope.doctor.joblv = doctor.joblv;
  };

  function _refreshDoctorData() {
    $http({
      method: 'GET',
      url: '/api/doctors/getAll'
    }).then(
      function (res) { // success
        $scope.doctors = res.data;
      },
      function (res) { // error
        console.log("Error: " + res.status + " : " + res.data);
      }
    );
  }

  function _success(res) {
        _refreshDoctorData();
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
        $scope.doctor.name = "";
        $scope.doctor.idcard = "";
        $scope.doctor.address = "";
        $scope.doctor.birthday = "";
        $scope.doctor.expertise = "";
        $scope.doctor.seniority = "";
		$scope.doctor.literacy = "";
		$scope.doctor.joblv = "";
    };
});