/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookREST.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import BookREST.entities.Book;
import BookREST.entities.BookList;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daniel Díaz Fernández
 * Universitat Rovira i Virgili (URV)
 */
@Stateless
@Path("book")
public class BookFacadeREST extends AbstractFacade<Book>{
    @PersistenceContext(unitName = "BookRESTPU")
    private EntityManager em;

    public BookFacadeREST() {
        super(Book.class);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public void create(Book entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, Book book) {
        if (super.find(id) == null){
            return Response.status(Response.Status.NOT_FOUND).entity("El libro "+id+" no existe.").build();
        } else {
            super.edit(book);
            GenericEntity bookDel=new GenericEntity<String>("El libro "+id+" se ha editado correctamente."){};
            return Response.ok(bookDel).build();
        }
    }
    
    //elimina un libro gracias a su id
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        if (super.find(id) == null){
            return Response.status(Response.Status.NOT_FOUND).entity("El libro "+id+" no existe.").build();
        } else {
            super.remove(super.find(id));
            GenericEntity bookDel=new GenericEntity<String>("El libro "+id+" se ha eliminado correctamente."){};
            return Response.ok(bookDel).build();
        }
    }

    //Busca un libro gracias a su id
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        Book book = super.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).entity("No existe el libro " + id).build();
        else{ 
            GenericEntity<Book> bookres = new GenericEntity<Book>(book){};
            return Response.ok(bookres).build();
        }
    }   
      
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    //crear método para obtener el response y acceder a la bd

    // metodo que retorna una lista ordenada por precio o valoracion

    @GET 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findAll( @QueryParam("sort") String criteri) {
        List<Book> disordered = super.findAll(); 
        List<Book> ordered = null; 
        BookList list = new BookList(); 

        switch ( criteri){
            case "price": 
                ordered = disordered.stream().sorted((a, b)->new Float(a.getPrice()).compareTo(b.getPrice())).collect(Collectors.toList());
            break;
            case "assessment":
                ordered = disordered.stream().sorted((a, b)->new Integer(a.getAssessment()).compareTo(b.getAssessment())).collect(Collectors.toList());
            break;
            default:
                return Response.status(Response.Status.NOT_FOUND).entity("Parameter not correct").build();
        }
        
        list.setBooks(ordered);
        GenericEntity<BookList> entity = new GenericEntity<BookList>(list){}; 
        return Response.ok(entity).build(); 

    }
    

}
