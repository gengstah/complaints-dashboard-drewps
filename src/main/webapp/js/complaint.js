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
	
	$("input:button#addComplaintButton").button().click(function() {
		$('form#complaint').submit();
	});
});