$(document).ready(function(){
	$("input:button#addPurchaseOrderButton").button().click(function() {
		$('form#purchaseOrder').submit();
	});
	$("input:button#cancelPurchaseOrderButton").button();
	$("input:button#addAnotherButton").button();
	$("input:button#purchaseOrderListButton").button();
});