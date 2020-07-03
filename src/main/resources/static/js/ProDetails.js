$(document).ready(function() {

    $('.color-choose input').on('click', function() {
        var LaptopsColor = $(this).attr('data-image');

        $('.active').removeClass('active');
        $('.left-column img[data-image = ' + LaptopsColor + ']').addClass('active');
        $(this).addClass('active');
    });

});