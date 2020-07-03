$(document).ready(function() {

    $('.method').on('click', function() {
        $('.method').removeClass('blue-border');
        $(this).addClass('blue-border');
    });

})
$(document).ready(function() {

    $('.delivery-panel').on('click', function() {
        $('.delivery-panel').removeClass('checkbox-input');
        $(this).addClass('checkbox-input');
    });

})

var $cardInput = $('.input-fields input');

$('.next-btn').on('click', function(e) {

    $cardInput.removeClass('warning');

    $cardInput.each(function() {
        var $this = $(this);
        if (!$this.val()) {
            $this.addClass('warning');
        }
    })
});