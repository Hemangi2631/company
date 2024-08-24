function toastSuccessMessage(sHeading, sText) {
    $.toast({
    	heading: sHeading,
		text: sText,
		position: 'top-right',
		loaderBg: '#d62027',
		icon: 'info',
		stack: 1,		
        showHideTransition: 'plain',
        hideAfter: 3e3
    });
    return false;
}

function toastErrorMessage(sHeading, sText) {
    $.toast({
    	heading: sHeading,
		text: sText,
		position: 'top-right',
		loaderBg: '#6c757d',
		icon: 'error',
		stack: 1,		
        showHideTransition: 'plain',
        hideAfter: 4000
    });
    return false;
}

function toastMessage(obj) {
    $.toast({
        heading: obj.heading,
        loaderBg: obj.sloaderBg,
        icon: obj.sicon,
        text: obj.message,
        position: "top-right",
        stack: 1,
        showHideTransition: "plain",
        hideAfter: 4000
    });
}

function sweetAlertSuccessMessage(sHeading, sText) {
    Swal.fire({
        title: sHeading,
        text: sText,
        icon: 'success'
    });
}

function sweetAlertErrorMessage(sHeading, sText) {
    Swal.fire({
        icon: 'error',
        title: sHeading,
        text: sText
    });
}

function getFormData($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};
    $.map(unindexed_array, function (n, i) {
        indexed_array[n["name"]] = n["value"];
    });
    return indexed_array;
}