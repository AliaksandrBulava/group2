(function() {

	var $output = $("#output");
	var $input = $("#input");

	$("#run").on('click', function(e) {
		e.preventDefault();

		var text = $input.val();
		$output.text(text);
	});

})();