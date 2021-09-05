package ru.vsu.cs.Models;

import javax.persistence.*;

@Entity
@Table(name = "paper")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Paper {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "name")
    protected String name;

    public Paper() {
    }

    public Paper(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Type getType();
}
