package ru.vsu.cs.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static ru.vsu.cs.Models.Type.BOOK;

@Entity
@DiscriminatorValue("book")
public class Book extends Paper implements Serializable {
    @Column(name = "author")
    private String author;

    @Column(name = "publishinghouse")
    private String publishingHouse;

    @Column(name = "numpages")
    private int numPages;

    public Book(String name, String author, String publishingHouse, int numPages) {
        super(name);
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.numPages = numPages;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }


    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public Type getType() {
        return BOOK;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", numPages=" + numPages +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numPages == book.numPages && Objects.equals(author, book.author) && Objects.equals(publishingHouse, book.publishingHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, publishingHouse, numPages);
    }
}
