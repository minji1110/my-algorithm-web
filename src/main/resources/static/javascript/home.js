"use strict";

$("#all-problem").DataTable({
  paging: true,
  lengthChange: false,
  pageLength: 8,
  searching: false,
  order: [4, "desc"],
});

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
