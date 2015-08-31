 $(document).ready(function() {
		$("#menu li").hover(function(){
			$("#item", this).show();
			$("#menu h2", this).addClass('selected');
			}, function(){
				$('#item',this).hide();
				$("#menu h2",this).removeClass('selected');
				});
	});
