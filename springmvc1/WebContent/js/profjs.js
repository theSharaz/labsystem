	
    $(document).ready(function(){
   	
    	//initial 
    	$("#profcont").load('../profjsp/info.jsp');
    	
    	//handle menu clicks
    	$("ul#navmachine li a").click(function(){
    		
    		var page = $(this).attr('href');
    		$("#profcont").load('../profjsp/'+page+'.jsp');
    		return false;
    	});
    	
    	
    });
//    function getPage(){
//    	var myClass =Java.type("Controller.ProfController");
//    	myClass.letsdoit();
//    	$("#profcont").load('../profjsp/yuhu.jsp');
//		return false;
//	}
    
    
 
