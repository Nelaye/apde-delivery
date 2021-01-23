package fr.univlorraine.apdedelivery.controller;

import fr.univlorraine.apdedelivery.dao.IDeliveryRepository;
import fr.univlorraine.apdedelivery.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DeliveryController {

    @Autowired
    private IDeliveryRepository dao;

    @GetMapping(value = "delivery")
    public Iterable<Delivery> findAll(){
        return dao.findAll();
    }

    @GetMapping(value = "delivery/{id}")
    public Optional<Delivery> getDeliveryById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "delivery/buyer/{buyer}")
    public Optional<Delivery[]> getDeliveryByBuyer(@PathVariable Integer buyer){
        return dao.findByBuyer(buyer);
    }
}
