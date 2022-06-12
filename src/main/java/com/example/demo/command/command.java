package com.example.demo.command;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.example.demo.medcin.medcin;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class command {

    @Id
    @SequenceGenerator(
        name = "command_seq", 
        sequenceName = "command_seq",
        allocationSize = 1) 
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "command_seq")
    private long id;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medcin_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private medcin medcin;


    public command(long id, int quantity, com.example.demo.medcin.medcin medcin) {
        this.id = id;
        this.quantity = quantity;
        this.medcin = medcin;
    }

    
    public command(int quantity, com.example.demo.medcin.medcin medcin) {
        this.quantity = quantity;
        this.medcin = medcin;
    }


    public command() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public medcin getMedcin() {
        return medcin;
    }

    public void setMedcin(medcin medcin) {
        this.medcin = medcin;
    }


   

    
}
