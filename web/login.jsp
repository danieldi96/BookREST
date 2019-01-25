<%-- 
    Document   : login
    Created on : 25-ene-2019, 12:40:48
    Author     : danie
--%>

<%--@page contentType="text/html" pageEncoding="UTF-8"--%>
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
        <div class="container login-container">
            <div class="row" style="margin: 2%;">
                <div class="col-md-6 login-form-1">
                    <h3>Login SOB</h3>

                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Your Email *" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Your Password *" value="" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" value="Login" />
                        </div>
                        <div class="form-group">
                            <a href="#" class="btnForgetPwd">Forget Password?</a>
                        </div>

                </div>
            </div>
        </div>
    </body>
</html>
