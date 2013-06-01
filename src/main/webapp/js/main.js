(function (window, $, undefined) {
  $(function () {
    $("input, textarea").placeholder();

    $(".slider").unslider({
      dots: true,
      speed: 500
    });
  });
})(window, jQuery);
