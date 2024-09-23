package ice_cream_parlor.Orders;

import java.util.ArrayList;

import com.rabbitmq.client.Channel;

import ice_cream_parlor.RabbitMqManager;

public class Client {
    public static void main(String[] args) throws Exception {
        String v_queueName = QueueNames.Orders.toString();
        Channel v_channel = RabbitMqManager.createChannel();
        v_channel.queueDeclare(v_queueName, false, false, false, null);

        ArrayList<String> v_messageArray = new ArrayList<String>();
        for (String v_newFlavor : args) {
            v_messageArray.add("[X] Novo pedido realido, sorvete de " + v_newFlavor);
        }

        for (String v_message : v_messageArray) {
            v_channel.basicPublish("", v_queueName, null, v_message.getBytes());
            System.out.println(v_message);
        }
    }

}
