document.getElementById("profilePic").onchange = function (event) {
  var reader = new FileReader();
  reader.onload = function () {
    var output = document.querySelector(".profile-form img");
    output.src = reader.result;
  };
  reader.readAsDataURL(event.target.files[0]);
};

document.addEventListener("DOMContentLoaded", function () {
  document.querySelector(".main-menu").addEventListener("click", function () {
    var submenu = document.querySelector(".submenu");
    submenu.style.display = submenu.style.display === "none" ? "block" : "none";
  });
});
