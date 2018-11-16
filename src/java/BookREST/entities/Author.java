/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookREST.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Díaz Fernández
 * Universitat Rovira i Virgili (URV)
 */
@Embeddable
@XmlRootElement
public class Author implements Serializable {
    private String name;
}
