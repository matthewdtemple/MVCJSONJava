package SpringMVCTest2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class book {

    @Id
    @GeneratedValue
    private int Id;

    private String name;

    private String author;


    public book (int Id, String name, String author){
        this.Id = Id;
        this.name = name;
        this.author = author;
    }

    public book (){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
//    public findBookById(int id){
//
//    }

}
