package com.example.demo.command;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class comm {
    @Id
    @SequenceGenerator(
        name = "command_seq", 
        sequenceName = "command_seq",
        allocationSize = 1) 
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "command_seq")
    private long id;
    private String produit;
    private int quantity;
    private float price;

    public comm() {
    }
    
    public comm(long id, String produit, int quantity, float price) {
        this.id = id;
        this.produit = produit;
        this.quantity = quantity;
        this.price = price;
    }

    public comm(String produit, int quantity, float price) {
        this.produit = produit;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "command{" +
         "id=" + id +
          ", produit=" + produit +
          ", quantity="+ quantity +
          ", price=" + price +
         '}';
    }
}
