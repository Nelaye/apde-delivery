package fr.univlorraine.apdedelivery.message;

import fr.univlorraine.apdedelivery.dao.IDeliveryRepository;
import fr.univlorraine.apdedelivery.model.Delivery;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RabbitListener(queues = "delivery")
@Component
public class Receiver {

    @Autowired
    private IDeliveryRepository dao;

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received : '" + in + "'");
        JSONObject order = new JSONObject(in);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = df.parse(order.getString("date"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        dao.save(new Delivery(Integer.parseInt(order.getString("buyer")), date, order.getString("address"))); //create a new delivery entry
    }
}
