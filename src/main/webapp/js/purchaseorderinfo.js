$(document).ready(function(){
	$("input:button#editPurchaseOrderButton").button().click(function() {
		window.location = 'updatepurchaseorder.html?id=' + $("input:hidden#id").val();
	});
	$("input:button#deletePurchaseOrderButton").button().click(function() {
		$( "div#dialog-confirmdelete" ).dialog({
			resizable: false,
			height:200,
			modal: true,
			buttons: {
				Delete: function() {
					window.location = 'deletepurchaseorder.html?id=' + $("input:hidden#id").val();
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
	$("input:button#backPurchaseOrderButton").button().click(function() {
		window.location = 'list.html';
	});
});