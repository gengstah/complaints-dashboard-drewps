$(document).ready(function(){
	$("input:button#addCompanyButton").button().click(function() {
		$('form#company').submit();
	});
	$("input:button#cancelCompanyButton").button();
	$("input:button#addAnotherButton").button();
	$("input:button#companyListButton").button();
});