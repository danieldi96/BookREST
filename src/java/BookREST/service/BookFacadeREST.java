/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookREST.service;

import java.util.List;
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
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public void edit(Book entity) {
        super.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        Book book = super.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).entity("No existe el libro con id: " + id).build();
        else{ 
            GenericEntity<Book> bookres=new GenericEntity<Book>(book){};
            return Response.ok(bookres).build();
        }
    }   
            
    /*
    @GET
    @Path("{author}")
    @Produces({"application/xml", "application/json"})
    public Book find(@PathParam("author") String author) {
        return super.find(author);
    }
    */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Book> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    //crear método para obtener el response y acceder a la bd
}
