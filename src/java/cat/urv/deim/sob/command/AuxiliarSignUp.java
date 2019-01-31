package cat.urv.deim.sob.command;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import BookREST.entities.Customer;

public class AuxiliarSignUp {

    public static void llistaCustomers(Customer cli) {

        javax.ws.rs.client.Client customer = ClientBuilder.newClient();

        customer.target("http://localhost:8080/BookREST/rest/api/v1/customers")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(cli), String.class);
    }
}
