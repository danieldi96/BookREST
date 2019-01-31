<%-- 
    Document   : login
    Created on : 25-ene-2019, 12:40:48
    Author     : danie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <li class="nav-item active"><a href="register.jsp">Register</a></li>
                  </ul>
                </div>
            </nav>
        </header>
        
        <div class="container">
            <div class="row">
              <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                  <div class="card-body">
                    <h5 class="card-title text-center">Acceso a la tienda</h5>
                    <form class="form-signin" action="loged.do" method="post">
                      <div class="form-label-group">
                        <label for="inputUsername">Usuario</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
                      </div>
                      <br>
                      <div class="form-label-group">
                        <label for="inputPassword">Contraseña</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Contraseña" required>
                      </div>
                      <br>
                      <div style="text-align: center">
                        <c:if test ="${login}">
                            <label style="color:red;"><b>Usuario o Contraseña incorrecto</b></label>
                        </c:if>
                      </div>
                      <br>
                      <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" value="login">Acceder</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
         </div>
        
    </body>
</html>
