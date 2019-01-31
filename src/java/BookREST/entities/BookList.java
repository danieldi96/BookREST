/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookREST.entities;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@XmlRootElement
public class BookList {
    private List<Book> books;

    public BookList() {
        this.books = null;
    }
    
    public List<Book> getBooks(){
        return books;
    }
    
    public void setBooks(List<Book> books){
        this.books = books;
    }
}
