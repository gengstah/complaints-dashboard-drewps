$(document).ready(function(){
	$("input:button#addProjectButton").button();
	
	$("input:button#searchButton").button().click(function() {
		$("form#searchForm").submit();
	});
	$("input:button#clearButton").button().click(function() {
		$("input:text#searchProjectTitle").val('');
		$("input:text#searchAccountNo").val('');
		$("form#searchForm").submit();
	});
	$("a#backButton").click(function() {
		var value = parseInt($("select#page").val()) - 1;
		$("select#page").val(value);
		$("form#searchForm").submit();
	});
	$("a#nextButton").click(function() {
		var value = parseInt($("select#page").val()) + 1;
		$("select#page").val(value);
		$("form#searchForm").submit();
	});
	$("select#page").change(function() {
		$("form#searchForm").submit();
	});
});