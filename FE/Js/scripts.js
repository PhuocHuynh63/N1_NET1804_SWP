document.addEventListener("DOMContentLoaded", function () {
  window.addEventListener("scroll", function () {
    if (window.scrollY > 50) {
      document.querySelector("header").classList.add("scrolled");
    } else {
      document.querySelector("header").classList.remove("scrolled");
    }
  });
});
