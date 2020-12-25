"use strict";

(function () {
  window.addEventListener(
    "load",
    function () {
      var forms = document.getElementsByClassName("needs-validation");
      var validation = Array.prototype.filter.call(forms, function (form) {
        form.addEventListener(
          "submit",
          function (event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add("was-validated");
          },
          false
        );
      });
    },
    false
  );
})();

function deleteProblem(problemId, problemNo) {
  if (confirm(`${problemNo}번 문제를 삭제하시겠습니까?`)) {
    $.ajax({
      url: "/problem/" + problemId,
      method: "DELETE",
      success: function (response) {
        location.href = "http://localhost:8081";
        console.log(
          "==================================================" + response
        );
      },
      error: function (response) {
        console.log(response);
        alert("fail!");
      },
    });
  }
}
