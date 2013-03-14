$(document).ready(function(){
	$("input:button#editCompanyButton").button().click(function() {
		window.location = 'updatecompany.html?companyAccountNo=' + $("input:hidden#companyAccountNumber").val();
	});
	$("input:button#deleteCompanyButton").button().click(function() {
		$( "div#dialog-confirmdelete" ).dialog({
			resizable: false,
			height:200,
			modal: true,
			buttons: {
				Delete: function() {
					window.location = 'deletecompany.html?companyAccountNo=' + $("input:hidden#companyAccountNumber").val();
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
	$("input:button#backCompanyButton").button().click(function() {
		window.location = 'list.html';
	});
});