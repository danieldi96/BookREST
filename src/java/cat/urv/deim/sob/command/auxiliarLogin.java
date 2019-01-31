/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import BookREST.entities.CustomerList;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Pablo
 */
public class auxiliarLogin {
    
    public static CustomerList llistaClients(){
        Client customer= ClientBuilder.newClient();
        
        String ll=customer.target("http://localhost:8080/BookREST/rest/api/v1/customers").
                        request(MediaType.APPLICATION_JSON).
                        get(String.class);
        
        CustomerList list=auxiliarLogin.stringtoXML(ll);
        
        return list;
    }
    
    public static CustomerList stringtoXML(String str){
        JAXBContext jaxbcontext;
        CustomerList list=null;
        try {
            jaxbcontext = JAXBContext.newInstance(CustomerList.class);
            Unmarshaller jaxbunmarshaller=jaxbcontext.createUnmarshaller();
            list=(CustomerList) jaxbunmarshaller.unmarshal(new StringReader(str));
            
        } catch (JAXBException ex) {
            Logger.getLogger(SortCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return list;
    }

   

}
