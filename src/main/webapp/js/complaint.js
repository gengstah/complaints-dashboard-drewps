$(document).ready(function(){
	var dates = $( "form#complaint input:text#date" ).datepicker({
		//defaultDate: "+1w",
		changeMonth: true,
		numberOfMonths: 1,
		/*onSelect: function( selectedDate ) {
			var option = this.id == "date" ? "minDate" : "maxDate",
				instance = $( this ).data( "datepicker" ),
				date = $.datepicker.parseDate(
					instance.settings.dateFormat ||
					$.datepicker._defaults.dateFormat,
					selectedDate, instance.settings );
			dates.not( this ).datepicker( "option", option, date );
		}*/
	});
	
	$("input:button#submitComplaintButton").button().click(function() {
		$('form#complaint').submit();
	});
	
	$("input:button#cancelComplaintButton").button();
	$("input:button#addComplaintButton").button();
	$("input:button#deleteComplaintButton").button();
	$("input:button#reopenComplaintButton").button();
});