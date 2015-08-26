$(function() {
    $('.animate, .nav-controller').on('click', function(event) {
        $('animate').toggleClass('focus');
    });
    $('.animate, .nav-controller').on('mouseover', function(event) {
        $('.animate').addClass('focus');
    }).on('mouseout', function(event) {
        $('.animate').removeClass('focus');
    })
})