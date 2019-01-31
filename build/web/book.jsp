<%-- 
    Document   : index
    Created on : 25-ene-2019, 12:38:27
    Author     : danie
--%>
<%@page import="BookREST.entities.Book"%>
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
    <%
            Book book = (Book) request.getAttribute("book");
            pageContext.setAttribute("book", book);
            HttpSession sesion = request.getSession();
            String usr = (String) sesion.getAttribute("username");
            Boolean sis = usr == null;
            pageContext.setAttribute("sis", sis);
    %>
    
    <body style="overflow:auto;  margin: 0; padding: 0; height: 100%; width: 100%;">
        
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <div class="navbar-header">
                      <a class="navbar-brand" href="index.jsp">Practica SOB</a>
                    </div>
                    <c:if test = "${sis}">
                      <ul class="nav navbar-nav navbar-right">
                          <li class="nav-item active"><a href="login.jsp">Login</a></li>
                           / 
                          <li class="nav-item active"><a href="register.jsp">Register</a></li>
                      </ul>
                    </c:if>
                    <c:if test = "${!sis}">
                          <ul class="nav navbar-nav navbar-right">
                              <li class="nav-item active"><a href="carrito.jsp">Carrito de ${usr}</a></li>
                          </ul>
                    </c:if>
                </div>
            </nav>
        </header>
        

        <div class="container" style="margin-top:1%">
            
            <center><h1>${book.title}</h1></center>
            <br>
            <div class="row">
                <div class="col-md-4">
                <img src="${book.img}" style="height: 100%; width: 100%; padding: 3%">
                </div>

                <div class="col-md-8" style="padding: 3%">
                    <p><strong>Autores:</strong></p>
                    <p>${book.author}</p>
                    <p><strong>Descripción:</strong></p>
                    <p>${book.description}</p>
                    <p><strong>Precio:</strong></p>
                    <p>${book.price}</p>
                    <p><strong>Valoración:</strong></p>
                    <div class="ec-stars-wrapper">
                        <c:forEach var="i" begin = "1" end = "${book.assessment}">
                            <a href="#" data-value="1" title="Votar con 1 estrellas">&#9733;</a>
                        </c:forEach>
                    </div>
                </div>  
            </div>
            
            <br>
            
            <div class="row" style=" justify-content: center;">
              <form action="add.do" method="post">
              <input type="text" name="bookId" value="${book.bookId}" hidden="">
              <c:if test = "${!sis}">
                  <button class="btn btn-primary" type="submit">Afegir al carro</button>
              </c:if> 
          </form>
            </div>   
        </div>
        
        <br>
        
        <footer class="footer bg-light" style="bottom:0px;">
            <center><span><strong>Creado por:</strong> Dani Diaz - Pablo Paradinas Prieto - Catalin Salvan</span></center>
        </footer>
        </div>
        
        
        
    </body>
</html>
