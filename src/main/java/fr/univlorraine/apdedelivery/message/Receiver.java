package fr.univlorraine.apdedelivery.message;

import fr.univlorraine.apdedelivery.dao.IDeliveryRepository;
import fr.univlorraine.apdedelivery.model.Delivery;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@RabbitListener(queues = "delivery")
@Component
public class Receiver {

    @Autowired
    private IDeliveryRepository dao;

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received : '" + in + "'");
        JSONObject order = new JSONObject(in);
        dao.save(new Delivery(Integer.parseInt(order.getString("buyer")), Date.valueOf(order.getString("date")), order.getString("address"))); //create a new delivery entry
    }
}
