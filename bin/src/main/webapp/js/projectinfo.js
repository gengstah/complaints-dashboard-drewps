$(document).ready(function(){
	$("input:button#editProjectButton").button().click(function() {
		window.location = 'updateproject.html?projectAccountNo=' + $("input:hidden#projectAccountNumber").val();
	});
	$("input:button#deleteProjectButton").button().click(function() {
		$( "div#dialog-confirmdelete" ).dialog({
			resizable: false,
			height:200,
			modal: true,
			buttons: {
				Delete: function() {
					window.location = 'deleteproject.html?projectAccountNo=' + $("input:hidden#projectAccountNumber").val();
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
	$("input:button#backProjectButton").button().click(function() {
		window.location = 'list.html';
	});
	$( "div#properties" ).accordion();
});

function createProgressBar(progressBar, val) {
	$( progressBar ).progressbar({
		value: val
	});
	
	$( progressBar + " > div" ).css({ 'background': 'url(/ProjectManagement/css/images/pbar-ani.gif)'});
}