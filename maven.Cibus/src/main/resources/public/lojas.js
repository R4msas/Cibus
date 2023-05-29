window.addEventListener("load", function() {
    var footer = document.getElementById("footer");
    var scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight);
    if (window.innerHeight >= scrollHeight) {
      footer.classList.add("show-footer");
    } else {
      window.addEventListener("scroll", function() {
        if (window.innerHeight + window.pageYOffset >= scrollHeight) {
          footer.classList.add("show-footer");
        } else {
          footer.classList.remove("show-footer");
        }
      });
    }
  });