<%-- 
    Document   : index
    Created on : 25-ene-2019, 12:38:27
    Author     : danie
--%>

<%@page import="BookREST.entities.Book"%>
<%@page import="java.util.List"%>
<%@page import="BookREST.entities.BookList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            BookList books = new BookList();
            books.setBooks((List<Book>) sesion.getAttribute("carrito"));
            Integer totalPrice = (Integer) sesion.getAttribute("totalPrice");
            pageContext.setAttribute("books", books);
        %>
        
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">Practica SOB</a>
                  </div>
                   <ul class="nav navbar-nav navbar-right">
                        <%--<li class="nav-item active"><a href="carrito.jsp">Carrito de ${user}</a></li>--%>
                    </ul>
                </div>
            </nav>
        </header>

        <div class="container" style="margin-top:1%">
            
            <center><h1>RECIBO</h1></center>
            
            <div class="row" style="margin-top: 10%;">
                <p>
                    <c:forEach var="book" items="${books.books}">
                       <br /><strong>${book.title}</strong> - Precio: ${book.price} €<br />
                    </c:forEach>
                </p> 
            </div>
            <hr>
            <p class="card-text">Precio Total: <strong>${totalPrice}</strong> €</p>
            <br>
            <br>
            
        </div>
        
        
        
        <footer class="footer bg-light" style="bottom:0px;">
            <center><span><strong>Creado por:</strong> Dani Diaz - Pablo Paradinas Prieto - Catalin Salvan</span></center>
        </footer>
        </div>
        
        
        
    </body>
</html>
