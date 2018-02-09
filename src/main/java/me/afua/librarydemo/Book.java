package me.afua.librarydemo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String author;

    private String image;

    private String ISBN;

    private boolean borrowed;

    private Date lastborrowed;

    private int borrowedtimes;

    public Book() {
        borrowed=false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Date getLastborrowed() {
        return lastborrowed;
    }

    public void setLastborrowed(Date lastborrowed) {
        this.lastborrowed = lastborrowed;
    }

    public int getBorrowedtimes() {
        return borrowedtimes;
    }

    public void setBorrowedtimes(int borrrowedtimes) {
        this.borrowedtimes = borrrowedtimes;
    }
    public void addToBorrowed()
    {
        this.borrowedtimes+=1;
    }
}
