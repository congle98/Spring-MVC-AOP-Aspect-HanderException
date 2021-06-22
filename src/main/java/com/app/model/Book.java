package com.app.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "int check (amount >= 0)")
    private int amount;

    private String borrowCode;

    @Column(columnDefinition = "boolean default false")
    private boolean borrowStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public boolean isBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(boolean borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name;    }
}
