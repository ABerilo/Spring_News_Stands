package ru.vsu.cs.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static ru.vsu.cs.Models.Type.MAGAZINE;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Paper implements Serializable {
    @Column(name = "number")
    private int number;
    @Column(name = "numpages")
    private int numPages;
    @Column(name = "date")
    private String date;

    public Magazine(String name, int number, String date, int numPages) {
        super(name);
        this.number = number;
        this.date = date;
        this.numPages = numPages;
    }

    public Magazine() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Type getType() {
        return MAGAZINE;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "number=" + number +
                ", numPages=" + numPages +
                ", date='" + date + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return number == magazine.number && numPages == magazine.numPages && Objects.equals(date, magazine.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, numPages, date);
    }
}
