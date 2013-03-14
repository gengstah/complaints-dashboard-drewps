$(document).ready(function(){
	$( "div#loginDialog" ).dialog({
		buttons: {
			Login: function() {
				$( this ).dialog( "close" );
				$('form#loginForm').submit();
			}
		},
		resizable: false
	});
});