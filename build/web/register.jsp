<%-- 
    Document   : register
    Created on : 28-ene-2019, 17:18:07
    Author     : Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> --%>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Practica Sob</title>
    </head>
    <body>
       
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">Practica SOB</a>
                  </div>
                  <ul class="nav navbar-nav">
                    <li class="nav-item active"><a href="index.jsp">Visitante</a></li>
                     / 
                    <li class="nav-item active"><a href="login.jsp">Login</a></li>
                  </ul>
                </div>
            </nav>
        </header>
        
        
        <div class="container">
            <div class="row">
              <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                  <div class="card-body">
                    <h5 class="card-title text-center">Registrarse en la tienda</h5>
                    <form class="form-signin"  action="loged.do" method="post">
                      <div class="form-label-group">
                        <label for="inputUsername">Usuario</label>
                        <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Email address" required autofocus>
                      </div>
                      <br>
                      <div class="form-label-group">
                        <label for="inputPassword">Contraseña</label>
                        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                      </div>
                      <br>
                      <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Registrarse</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
         </div>
            
    </body>
</html>
