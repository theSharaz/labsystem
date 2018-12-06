    $(document).ready(function(){
   	
    	//initial 
    	$("#profcont").load('../profjsp/viewBookedExp.jsp');
    	
    	//handle menu clicks
    	$("ul#navmachine li a").click(function(){
    		
    		var page = $(this).attr('href');
    		$("#profcont").load('../profjsp/'+page+'.jsp');
    		return false;
    	});
    	
    	
    });