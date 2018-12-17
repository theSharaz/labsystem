	
    $(document).ready(function(){
    	alert("Working!");

    	$("#stucont").load('../stujsp/info.jsp');
    	
    	//handle menu clicks
    	$("ul#navmachine li a").click(function(){
    		
    		var page = $(this).attr('href');
    		$("#stucont").load('../stujsp/'+page+'.jsp');
    		return false;
    	});
    });