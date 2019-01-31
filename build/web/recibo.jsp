<%-- 
    Document   : index
    Created on : 25-ene-2019, 12:38:27
    Author     : danie
--%>

<%@page import="BookREST.entities.Book"%>
<%@page import="java.util.List"%>
<%@page import="BookREST.entities.BookList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        
        <title>Practica Sob</title>
    </head>
    <body style="overflow:auto;  margin: 0; padding: 0; height: 100%; width: 100%;">
        <%
            HttpSession sesion = request.getSession();
            BookList list = new BookList();
            list.setBooks((List<Book>) sesion.getAttribute("carrito"));
            pageContext.setAttribute("ll", list);
        %>
        
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">Practica SOB</a>
                  </div>
                    <form class="navbar-form" action="">
                        <div class="input-group">
                          <input type="text" class="form-control" placeholder="Buscar Libro" name="search">
                          <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                              Buscar
                            </button>
                          </div>
                        </div>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <button type="button" class="btn btn-default" id="carrito" href="carrito.jsp">
                                Carrito de ${sessionScope.usuario}
                            </button>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>

        <div class="container" style="margin-top:1%">
            
            <center><h1>RECIBO</h1></center>
            
            <p class="card-text">Import Total de la compra<br> €</p>
            
        </div>
        
        
        
        <footer class="footer bg-light" style="bottom:0px;">
            <center><span><strong>Creado por:</strong> Dani Diaz - Pablo Paradinas Prieto - Catalin Salvan</span></center>
        </footer>
        </div>
        
        
        
    </body>
</html>
