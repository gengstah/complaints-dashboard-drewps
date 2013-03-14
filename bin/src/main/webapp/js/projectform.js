$(document).ready(function(){
	var dates = $( "form#project input:text#dateStarted, form#project input:text#expectedCompletionDate" ).datepicker({
		defaultDate: "+1w",
		changeMonth: true,
		numberOfMonths: 3,
		onSelect: function( selectedDate ) {
			var option = this.id == "dateStarted" ? "minDate" : "maxDate",
				instance = $( this ).data( "datepicker" ),
				date = $.datepicker.parseDate(
					instance.settings.dateFormat ||
					$.datepicker._defaults.dateFormat,
					selectedDate, instance.settings );
			dates.not( this ).datepicker( "option", option, date );
		}
	});
	
	$("input:button#addProjectButton").button().click(function() {
		$('form#project').submit();
	});
	$("input:button#cancelProjectButton").button();
	$("input:button#addAnotherButton").button();
	$("input:button#projectListButton").button();
});