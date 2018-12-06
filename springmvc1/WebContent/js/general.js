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
    	$("#cont").load('../myjsp/admin.jsp');
    	
    	//handle menu clicks
    	$("ul#navmachine li a").click(function(){
    		
    		var page = $(this).attr('href');
    		$("#cont").load('../myjsp/'+page+'.jsp');
    		return false;
    	});
    });
    
    function getPages(){
    	alert("Working!");
    	$("#cont").load('../myjsp/hello.jsp');
		return false;
	}