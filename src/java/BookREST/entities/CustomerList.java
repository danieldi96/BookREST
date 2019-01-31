/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookREST.entities;

import java.util.List;

/**
 *
 * @author Pablo
 */
public class CustomerList {
    private List<Customer> customers;

    public CustomerList() {
        this.customers = null;
    }
    
    public List<Customer> getCustomers(){
        return customers;
    }
    
    public void setCustomers(List<Customer> customers){
        this.customers = customers;
    }
}
