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
            BookList books = new BookList();
            books.setBooks((List<Book>) sesion.getAttribute("carrito"));
            Boolean vacio = true;
            if (books.getBooks()!=null) {
                vacio = false;
            }
            System.out.println("BOOKS: "+books.getBooks().toString());
            pageContext.setAttribute("books", books);
            pageContext.setAttribute("vacio", vacio);
        %>
        
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">Practica SOB</a>
                  </div>
                    
                </div>
            </nav>
        </header>
        

        <div class="container" style="margin-top:1%">
            
            <center><h1>CARRITO</h1></center>
            
            <c:if test = "${!vacio}">
                <form action="buy.do" method="post">
                    <button type="submit" class="btn btn-default">Comprar</button>
                </form>
            </c:if>
            <c:if test = "${vacio}">
                <h1 class="card-text" style="text-align: center"> NO HI HAN LLIBRES</h1>
            </c:if>
            
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
                            <div class="col-md-4 px-3">
                              <div class="card-block px-3">
                                <h4 class="card-title">${book.title}</h4>
                                <p class="card-text"><strong>Precio:</strong></p>
                                <p class="card-text">${book.price} €</p>
                              </div>
                            </div>
                           <div class="col-md-4 px-3">
                              <div class="card-block px-3">
                                <form action="book.do" method="post">
                                    <input type="text" name="id" value="${book.bookId}" hidden="">
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
        
        <%--<c:forEach var="temp" items="${llibres.llibres}">
            
        </c:forEach>--%>
        
        <footer class="footer bg-light" style="bottom:0px;">
            <center><span><strong>Creado por:</strong> Dani Diaz - Pablo Paradinas Prieto - Catalin Salvan</span></center>
        </footer>
        </div>
        
        
        
    </body>
</html>
