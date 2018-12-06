//alert("Working!");
	
    $(document).ready(function(){
    	
    	
//    	var lepag;
//    	
//    	if(lepag==null){
//        	$("#cont").load('../myjsp/admin.jsp');
//        	alert(lepag);
//    	}
//    	else{
//    	//initial 
//
//		$("#cont").load('../myjsp/'+lepag+'.jsp');
//		alert(page);
//    	}
    	
    	//initial 
    	$("#stucont").load('../stujsp/info.jsp');
    	
    	//handle menu clicks
    	$("ul#navmachine li a").click(function(){
    		
    		var page = $(this).attr('href');
    		$("#stucont").load('../stujsp/'+page+'.jsp');
    		return false;
    	});
    });