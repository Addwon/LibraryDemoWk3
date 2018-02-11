package me.afua.librarydemo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @URL
    private String image;

    @NotNull
    private long yearPub;

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

    public long getYearPub() {
        return yearPub;
    }

    public void setYearPub(long yearPub) {
        this.yearPub = yearPub;
    }

    public void addToBorrowed()
    {
        this.borrowedtimes+=1;
    }

}
