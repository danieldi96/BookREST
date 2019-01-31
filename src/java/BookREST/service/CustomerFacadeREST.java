/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookREST.service;

import BookREST.entities.Customer;
import BookREST.entities.CustomerList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daniel Díaz Fernández
 * Universitat Rovira i Virgili (URV)
 */
@Stateless
@Path("customers")
public class CustomerFacadeREST extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "BookRESTPU")
    private EntityManager em;

    public CustomerFacadeREST() {
        super(Customer.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Customer entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Customer entity, @HeaderParam("user") String user, @HeaderParam("password") String password) {
        
        if(super.find(id)!=null){
            if((user.equals(super.find(id).getUser())) && (password.equals(super.find(id).getPassword()))){
                super.edit(entity);
                GenericEntity entity2=new GenericEntity<String>("The edit of the client was succesfully done, ID:  "+ id ){};
                return Response.ok(entity2).build();
            }
            else{
                return Response.status(Response.Status.FORBIDDEN).entity("The user or password are not correct!").build();
             }
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("The client "+id+" not exists!").build();    
        }
        
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") String id, @HeaderParam("user") String user, @HeaderParam("password") String password) {
        if(super.find(id)!=null){
            if((user.equals(super.find(id).getUser())) && (password.equals(super.find(id).getPassword()))){
                super.remove(super.find(id));
                GenericEntity entity2=new GenericEntity<String>("The edit of the client was succesfully done, ID:  "+ id ){};
                return Response.ok(entity2).build();
            }
            else{
                return Response.status(Response.Status.FORBIDDEN).entity("The user or password are not correct!").build();
            }
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("The client "+id+" not exists!").build();    
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") String id, @HeaderParam("user") String user, @HeaderParam("password") String password) {
        if(super.find(id) != null){
            if((user.equals(super.find(id).getUser())) && (password.equals(super.find(id).getPassword()))){
                super.remove(super.find(id));
                return Response.ok(super.find(id)).build();
            }
            else{
                return Response.status(Response.Status.FORBIDDEN).entity("The user or password are not correct!").build();
            }
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("The client "+id+" not exists!").build();    
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findAllCustomers() {

        List<Customer> cust = super.findAll();
        CustomerList list = new CustomerList();
        list.setCustomers(cust);
        if (cust != null){
            GenericEntity<CustomerList> ent = new GenericEntity<CustomerList>(list){};
            return Response.ok(ent).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("There are no customers").build();
        }
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response.ResponseBuilder findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return Response.ok(super.findRange(new int[]{from, to}));
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
