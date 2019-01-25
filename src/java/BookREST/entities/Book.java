/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookREST.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Díaz Fernández
 * Universitat Rovira i Virgili (URV)
 */
@Entity 
@Table(name = "BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    // TODO: This query could not be correct
    //@NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE :author IN (b.authors)"),
    @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price"),
    @NamedQuery(name = "Book.findByAssessment", query = "SELECT b FROM Book b WHERE b.assessment = :assessment")
})

public class Book implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "BOOK_ID")
    private Integer bookId;
    @Size(max = 40)
    @Column(name = "TITLE")
    private String title;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "AUTHORS")
    private List<Author> authors;
    @Size(max = 240)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 240)
    @Column(name = "COVER")
    private String coverBook;
    @Column(name = "PRICE")
    private float price;
    @Column(name = "ASSESSMENT")
    private int assessment;
    
    public Book() {
    }
    
    public Book(Integer bookId){
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    /*
    public void setAuthors(Author[] authors) {
        this.authors.addAll(Arrays.asList(authors));
    }*/
    
    public void setAuthors(Author author) {
        this.authors.add(author);
    }

    public String getCoverBook() {
        return coverBook;
    }

    public void setCoverBook(String coverBook) {
        this.coverBook = coverBook;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.bookId, other.bookId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book {" + "bookId = " + bookId + '}';
    }
    
    
    
}
