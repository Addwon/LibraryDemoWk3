package me.afua.librarydemo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class BorrowingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @Valid
    private Book aBook;

    private String description;

    /*Uses Hibernate annotation to automatically update the field in the database when a record is added.
      From the documentation: The property value will be set to the current VM date exactly once when
      saving the owning entity for the first time.
    */

    @CreationTimestamp
    private java.sql.Timestamp createdDate;

    public BorrowingHistory() {
    }

    public BorrowingHistory(Book aBook) {
        this.aBook = aBook;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getaBook() {
        return aBook;
    }

    public void setaBook(Book aBook) {
        this.aBook = aBook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    //An example of how to create a getter that can be called from the view in Thymeleaf to format items as you want them.
    //You can also format items directly in the view - that method is more appropriate when you have a number of different formats to use.
    public String getTransactionDate()
    {
        //returns a formatted string of the desired timestamp
        return new SimpleDateFormat("EE, dd MMM YYYY - HH:mm").format(getCreatedDate());
    }
}
