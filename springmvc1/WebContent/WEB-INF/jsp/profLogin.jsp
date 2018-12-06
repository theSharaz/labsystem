<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<link  href="../css/adlog.css" rel="stylesheet" type="text/css"> 
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<style type="text/css"></style>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript"></script>
	<title>Prof Login | login</title>
	
</head> 
<body class ="bg-secondary">
  <div class="container ">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-5 ">
        <div class="card text-white bg-dark mb-3 ">
          <div class="card-body">
            <h5 class="card-title text-center">Prof Login</h5>
            <form action="logg" method="post" class="form-signin">
              <div class="form-label-group">
                <input type="text" name="profnum" value="20000001" class="form-control" placeholder="profNum" required autofocus>
                <label for="inputEmail">Prof No.</label>
              </div>

              <div class="form-label-group">
                <input type="password" name="password" value="0000" class="form-control" placeholder="Password" required autofocus>
                <label for="inputPassword">Password</label>
              </div>

              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              <hr class="my-4">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>