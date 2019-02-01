/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import BookREST.entities.CustomerList;
import com.google.gson.Gson;


/**
 *
 * @author Pablo
 */
public class auxiliarLogin {
    
    public static CustomerList llistaClients() {
        Client customer= ClientBuilder.newClient();
        
        String ll=customer.target("http://localhost:8080/BookREST/rest/api/v1/customers").
                        request().
                        get(String.class);
                
        Gson gson = new Gson();
        CustomerList list = gson.fromJson(ll, CustomerList.class);

        return list;
    }
}
