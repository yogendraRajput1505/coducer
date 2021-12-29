<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Employee - Login</title>
    <!-- Font Awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/yogi.css" />" rel="stylesheet">

</head>

<style>

html,
        body,
        header,
        .view {
          height: 100vh;
        }

        @media (max-width: 740px) {
          html,
          body,
          header,
          .view {
            height: 815px;
          }
        }

        @media (min-width: 800px) and (max-width: 850px) {
          html,
          body,
          header,
          .view  {
            height: 650px;
          }
        }

        .intro-2 {
            background: url("http://mdbootstrap.com/img/Photos/Horizontal/Nature/full page/img%20(11).jpg")no-repeat center center;
            background-size: cover;
        }
        .top-nav-collapse {
            background-color: #3f51b5 !important;
        }
        .navbar:not(.top-nav-collapse) {
            background: transparent !important;
        }
        @media (max-width: 768px) {
            .navbar:not(.top-nav-collapse) {
                background: #3f51b5 !important;
            }
        }
        @media (min-width: 800px) and (max-width: 850px) {
            .navbar:not(.top-nav-collapse) {
                background: #3f51b5!important;
            }
        }

        .card {
            background-color: rgba(229, 228, 255, 0.2);
        }
        .md-form label {
            color: #ffffff;
        }
        h6 {
            line-height: 1.7;
        }
        

        .card {
            margin-top: 30px;
         }

        .md-form input[type=text]:focus:not([readonly]),
        .md-form input[type=password]:focus:not([readonly]) {
            border-bottom: 1px solid #8EDEF8;
            box-shadow: 0 1px 0 0 #8EDEF8;
        }
        .md-form input[type=text]:focus:not([readonly])+label,
        .md-form input[type=password]:focus:not([readonly])+label {
            color: #8EDEF8;
        }

        .md-form .form-control {
            color: #fff;
        }
        

</style>

<body class="fixed-sn pink-skin">
    
  <!--Main Navigation-->
  <header>

    <nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
            <div class="container">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
                    aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="basicExampleNav">
                    <ul class="navbar-nav mr-auto smooth-scroll">
                        <li class="nav-item">
                            <a class="nav-link" href="index">Home</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav nav-flex-icons">
                        <li class="nav-item">
                            <a href="login"><button class="btn bg-info pt-2 pb-2">Login</button></a>
                        </li>
                        <li class="nav-item">
                            <a href="signup"><button class="btn bg-info pt-2 pb-2">Sign Up</button></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    <!--Intro Section-->
    <section class="view intro-2">
      <div class="mask rgba-stylish-strong h-100 d-flex justify-content-center align-items-center">
        <div class="container">
          <div class="row">
            <div class="col-xl-5 col-lg-6 col-md-10 col-sm-12 mx-auto mt-lg-5">

              <!--Form with header-->
              <div class="card wow fadeIn" data-wow-delay="0.3s">
                <div class="card-body">

                  <!--Header-->
                  <div class="form-header purple-gradient">
                    <h3><i class="fas fa-user mt-2 mb-2"></i> Log in:</h3>
                  </div>

                  <!--Body-->
				  <form action="processlogin" method="post">
  	                  <div class="md-form">
	                    <i class="fas fa-envelope prefix white-text"></i>
	                    <input name="email" type="email" id="orangeForm-email" class="form-control" required="">
	                    <label for="orangeForm-email">Your email</label>
	                  </div>
						
	                  <div class="md-form">
	                    <i class="fas fa-lock prefix white-text"></i>
	                    <input name="hashedData" type="text" id="orangeForm-pass2" class="form-control" required="">
	                    <input name="password" type="password" id="orangeForm-pass" class="form-control" required="" style="position: absolute;
    top: 0px; color: #ff000000">
	                    <label for="orangeForm-pass">Your password</label>
	                  </div>
	
	                  <div class="text-center">
	                    <button type="submit" class="btn purple-gradient btn-lg" onsubmit="updatePassword()">Sign up</button>
	                    <hr>
	                    <div class="inline-ul text-center d-flex justify-content-center">
	                      <a class="p-2 m-2 fa-lg tw-ic"><i class="fab fa-twitter white-text"></i></a>
	                      <a class="p-2 m-2 fa-lg li-ic"><i class="fab fa-linkedin-in white-text"> </i></a>
	                      <a class="p-2 m-2 fa-lg ins-ic"><i class="fab fa-instagram white-text"> </i></a>
	                    </div>
	                  </div>
				  </form>
                </div>
              </div>
              <!--/Form with header-->
            </div>
          </div>
        </div>
      </div>
    </section>
  </header>
  <!--Main Navigation-->
 
    <!-- SCRIPTS -->
   <script src="<c:url value="/resources/js/jquery-3.4.1.min.js" />"></script>
   <script src="<c:url value="/resources/js/popper.min.js" />"></script>
   <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
   <script src="<c:url value="/resources/js/mdb.min.js" />"></script>
	
	<script>
	$('#orangeForm-pass').on('input', function() {
		var val = $('#orangeForm-pass').val();  
		var data="";
		    for(var i=0;i<val.length;i++){
		    	data = data+'#';
		    }
		    $("#orangeForm-pass2").val(data);
		});		
	
	</script>
	
</body>
</html>