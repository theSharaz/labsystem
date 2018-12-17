<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link  href="../css/testcss.css" rel="stylesheet" type="text/css">

<!-- Optional theme 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">-->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<div class="container">
  <h2>Part 2</h2>
  <ul class="nav nav-pills">
    <li class="active noround"><a data-toggle="pill" href="#home">Orar</a></li>
    <li class="noround"><a data-toggle="pill" href="#menu1">Profesori</a></li>
    <li class="noround"><a data-toggle="pill" href="#menu2">Materii</a></li>
    <li class="noround"><a data-toggle="pill" href="#menu3">Sali</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <ol class="breadcrumb">
        <li><a href="#">FII</a></li>
        <li>
          <div class="btn-group">
            <a href="#" class="btn">Info2</a>
            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="caret"></span>
              <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu">
              <li><a href="#">Info1</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">Add more</a></li>
            </ul>
          </div>  <!-- end btn-group -->
        </li>  <!-- end-breadcrumb-li -->
        <li><div class="btn-group">
            <a href="#" class="btn">Semian B</a>
            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="caret"></span>
              <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu">
              <li><a href="#">Semian A</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">Add more</a></li>
            </ul>
          </div>  <!-- end btn-group -->
        </li>  <!-- end-breadcrumb-li -->
        <li class="active"><div class="btn-group">
            <a href="#" class="btn">Grupa 1</a>
            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="caret"></span>
              <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu">
              <li><a href="#">Grupa 2</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="#">Add more</a></li>
            </ul>
          </div>  <!-- end btn-group -->
        </li>  <!-- end-breadcrumb-li -->
      </ol>
      <h3>HOME</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
      <table class="table table-bordered table-striped table-hover">
        <thead>
          <tr class="table-head">
            <th class="col-md-1">incepe</th>
            <th class="col-md-1">termina</th>
            <th class="col-md-3">Materie</th>
            <th class="col-md-2">Parte</th>
            <th class="col-md-4">Profesor</th>
            <th class="col-md-1">Sala</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th colspan="7">>Luni</th>
          </tr>
          <tr>
            <th scope="row">08.000</th>
            <td>10.00</td>
            <td>Algoritmica grafurilor</td>
            <td>Curs</td>
            <td>Prof. dr. Cornelius Croitoru</td>
            <td>C309</td>
          </tr>
          <tr>
            <th scope="row">10.00</th>
            <td>12.00</td>
            <td>Limbaje formale, automate si compilatoare</td>
            <td>Curs</td>
            <td>Lect. dr. Captarencu Oana</td>
            <td>C309</td>
          </tr>
          <tr>
            <th colspan="7">>Marti</th>
          </tr>
          <tr>
            <th scope="row">08.00</th>
            <td>10.00</td>
            <td>Algoritmica grafurilor</td>
            <td>Curs</td>
            <td>Prof. dr. Cornelius Croitoru</td>
            <td>C309</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div id="menu1" class="tab-pane fade">
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Library</a></li>
        <li class="active">Data</li>
      </ol>
 
       <h3>About</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
      <table class="table table-bordered table-striped table-hover">
        <thead>
          <tr class="table-head">
            <th class="col-md-1">incepe</th>
            <th class="col-md-1">termina</th>
            <th class="col-md-3">Materie</th>
            <th class="col-md-2">Parte</th>
            <th class="col-md-4">Profesor</th>
            <th class="col-md-1">Sala</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th colspan="7">>Luni</th>
          </tr>
          <tr>
            <th scope="row">08.000</th>
            <td>10.00</td>
            <td>Algoritmica grafurilor</td>
            <td>Curs</td>
            <td>Prof. dr. Cornelius Croitoru</td>
            <td>C309</td>
          </tr>
          <tr>
            <th scope="row">10.00</th>
            <td>12.00</td>
            <td>Limbaje formale, automate si compilatoare</td>
            <td>Curs</td>
            <td>Lect. dr. Captarencu Oana</td>
            <td>C309</td>
          </tr>
          <tr>
            <th colspan="7">>Marti</th>
          </tr>
          <tr>
            <th scope="row">08.00</th>
            <td>10.00</td>
            <td>Algoritmica grafurilor</td>
            <td>Curs</td>
            <td>Prof. dr. Cornelius Croitoru</td>
            <td>C309</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div id="menu1" class="tab-pane fade">
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Library</a></li>
        <li class="active">Data</li>
      </ol>
 
      
      <h3>Menu 1</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
    <div id="menu2" class="tab-pane fade">
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Library</a></li>
        <li class="active">Data</li>
      </ol>
      <h3>Menu 2</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="menu3" class="tab-pane fade">
      <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Library</a></li>
        <li class="active">Data</li>
      </ol>
      <h3>Menu 3</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
</div>