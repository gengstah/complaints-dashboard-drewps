$(document).ready(function(){	
	$("input:button#submitUserButton").button().click(function() {
		$('form#user').submit();
	});
	
	$("input:button#cancelUserButton").button();
	$("input:button#addUserButton").button();
	$("input:button#deleteUserButton").button();
	$("input:button#reopenUserButton").button();
});