package ice_cream_parlor.Orders;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import ice_cream_parlor.RabbitMqManager;

public class Attendant {
    public static void main(String[] args) throws Exception {
        Channel v_channel = RabbitMqManager.createChannel();
        String v_queueName = QueueNames.Orders.toString();
        v_channel.queueDeclare(v_queueName, false, false, false, null);
        System.out.println("Pressione Ctrl + C para finalizar o atendimento");

        DeliverCallback v_deliverCallback = (p_consumerTag, p_delivery) -> {
            String v_message = new String(p_delivery.getBody(), "UTF-8");
            System.out.println(v_message);
        };

        v_channel.basicConsume(v_queueName, true, v_deliverCallback, p_consumerTag -> {});
    }
}
