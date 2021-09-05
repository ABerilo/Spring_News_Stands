package ru.vsu.cs.Models;

import javax.persistence.*;
import java.io.Serializable;

import static ru.vsu.cs.Models.Type.NEWSPAPER;

@Entity
@DiscriminatorValue("newspaper")
public class NewsPaper extends Paper implements Serializable {
    @Column(name = "number")
    private int number;
    @Column(name = "date")
    private String date;

    public NewsPaper(String name, int number, String date) {
        super(name);
        this.number = number;
        this.date = date;
    }

    public NewsPaper() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Type getType() {
        return NEWSPAPER;
    }

    @Override
    public String toString() {
        return "NewsPaper{" +
                "number=" + number +
                ", date='" + date + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
