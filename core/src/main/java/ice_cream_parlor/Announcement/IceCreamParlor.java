package ice_cream_parlor.Announcement;

import java.util.ArrayList;

import com.rabbitmq.client.Channel;

import ice_cream_parlor.RabbitMqManager;

public class IceCreamParlor {

    public static void main( String[] args ) throws Exception
    {
        String v_exchangeName = ExchangeNames.Announcement.toString();
        Channel  v_channel = RabbitMqManager.createChannel(v_exchangeName,"fanout");

        ArrayList<String> v_messageArray = new ArrayList<String>();
        for (String v_newFlavor : args) {
            v_messageArray.add("Novo sabor de "+ v_newFlavor +" disponível!");
        }
        for (String v_message : v_messageArray) {
            v_channel.basicPublish(v_exchangeName, "", null, v_message.getBytes());
            System.out.println(v_message);
        }
    }
}
