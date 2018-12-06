<%@ page pageEncoding="utf-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>上传图片</title>  
</head>  
<body>  
<form action="file/upload.do" method="post" enctype="multipart/form-data">  
     <input type="hidden" name="name" value="zhangjun" />
     <input type="file" name="file" /> 
     <input type="submit" value="Submit" />
 </form>  
</body>  
</html> 