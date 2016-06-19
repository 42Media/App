/**
 * Created by David on 19.06.16.
 */

$(function() {

    $('body').on('hidden.bs.modal', '.modal', function () {
        $(this).removeData('bs.modal');
    });

});


