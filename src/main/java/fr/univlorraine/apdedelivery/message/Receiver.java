package fr.univlorraine.apdedelivery.message;

import fr.univlorraine.apdedelivery.dao.IDeliveryRepository;
import fr.univlorraine.apdedelivery.model.Delivery;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "delivery")
public class Receiver {

    @Autowired
    private IDeliveryRepository dao;

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received : '" + in + "'");
        //dao.save(new Delivery()); //create a new delivery entry
    }
}
