/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookREST.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Díaz Fernández
 * Universitat Rovira i Virgili (URV)
 */
@Entity
@XmlRootElement
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PURCHASE_ID")
    private Integer purchaseId;
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Column(name = "BOOK_ID")
    private Integer bookId;

    public Purchase(){
        
    }
    
    public Purchase(Integer purchaseId){
        this.purchaseId = purchaseId;
    }
    
    public Integer getId() {
        return purchaseId;
    }

    public void setId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseId != null) ? purchaseId.hashCode() : 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the purchaseId fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        return !((this.purchaseId == null && other.purchaseId != null) || (this.purchaseId != null && !this.purchaseId.equals(other.purchaseId)));
    }

    @Override
    public String toString() {
        return "sob.lab10_ws.Purchase[ purchaseId=" + purchaseId + " ]";
    }
    
}
