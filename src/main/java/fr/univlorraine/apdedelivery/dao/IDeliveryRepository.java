package fr.univlorraine.apdedelivery.dao;

import fr.univlorraine.apdedelivery.model.Delivery;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface IDeliveryRepository extends CrudRepository<Delivery,Integer>{
    Optional<Delivery[]> findByBuyer(Integer buyer);
}
