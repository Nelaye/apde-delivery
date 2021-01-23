package fr.univlorraine.apdedelivery.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;

@Service
@Scope("prototype")
@Entity
@Table(name = "Deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Id of the buyer
    @Column(name = "buyer")
    private int buyer;

    // The delivery date
    @Column(name = "date")
    private Date date;

    // Address of the buyer
    @Column(name = "address")
    private String address;


    public Delivery (){}

    public Delivery(int id, int buyer, Date date, String address){
        this.id = id;
        this.buyer = buyer;
        this.date = date;
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getBuyer() {
        return buyer;
    }
    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
