<%-- 
    Document   : index
    Created on : 25-ene-2019, 12:38:27
    Author     : danie
--%>
<%@page import="BookREST.entities.BookList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        
        <title>Practica Sob</title>
    </head>
    <body style="overflow:auto;  margin: 0; padding: 0; height: 100%; width: 100%;">
        
        <%
            HttpSession sesion = request.getSession();
            String usr = (String) sesion.getAttribute("username");
            Boolean sis = usr == null;
            pageContext.setAttribute("sis", sis);
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
                        <c:if test = "${sis}">
                          <ul class="nav navbar-nav navbar-right">
                              <li class="nav-item active"><a href="install.jsp">Login</a></li>
                               / 
                              <li class="nav-item active"><a href="register.jsp">Register</a></li>
                          </ul>
                        </c:if>
                        <c:if test = "${!sis}">
                          <ul class="nav navbar-nav navbar-right">
                              <li>
                                  <button type="button" class="btn btn-default" id="carrito" href="carrito.jsp">
                                      Carrito de ${sessionScope.usuario}
                                  </button>
                              </li>
                          </ul>
                        </c:if>
                    </div>
                </nav>
            </header>
        

            <div class="container" style="margin-top: 2%">
                <center><h1>LIBROS</h1></center>
                <form action="sort.do" method="get">
                    <div class="form-group">
                        <input type="text" name="page" value="index" hidden="">
                        <label for="Seleccion_orden">Ordenar por:</label>
                        <select class="form-control" id="opcion_ordenar" name="sort">
                            <option value="price">Precio</option>
                            <option value="assessment">Valoración</option>
                        </select>
                        <div class="input-group-btn">
                          <button type="submit" class="btn btn-default">Ordenar</button>
                        </div>
                    </div>
                </form>
            </div>

        
            <div class="container">
                
                <c:forEach var="book" items="${books.books}">
                    <section>
                        <div class="container py-3">
                          <div class="card">
                            <div class="row " style="margin: 1%">
                              <div class="col-md-4">
                                  <img src="${book.img}" class="w-100">
                                </div>
                                <div class="col-md-8 px-3">
                                  <div class="card-block px-3">
                                    <h4 class="card-title">${book.title}</h4>
                                    <p class="card-text"><strong>Autores:</strong></p>
                                    <p class="card-text">${book.author}</p>
                                    <p class="card-text"><strong>Descripcion:</strong></p>
                                    <p class="card-text">${book.description}</p>
                                    <p class="card-text"><strong>Precio:</strong></p>
                                    <p class="card-text">${book.price} €</p>
                                    <div class="ec-stars-wrapper">
                                        <c:forEach var="i" begin = "1" end = "${book.assessment}">
                                            <a href="#" data-value="1" title="Votar con 1 estrellas">&#9733;</a>
                                        </c:forEach>
                                    </div>
                                    <form action="book.do" method="post">
                                        <input type="text" name="id" value="${temp.id}" hidden="">
                                        <button type="submit" class="btn btn-primary">Ver el libro</button>
                                    </form>
                                  </div>
                                </div>

                              </div>
                            </div>
                          </div>
                        </div>
                    </section>
                </c:forEach>
                
            </div>
                

                
        
            <footer class="footer bg-light" style="bottom:0px;">
                <center><span><strong>Creado por:</strong> Dani Diaz - Pablo Paradinas Prieto - Catalin Salvan</span></center>
            </footer>
   
        
    </body>
</html>
