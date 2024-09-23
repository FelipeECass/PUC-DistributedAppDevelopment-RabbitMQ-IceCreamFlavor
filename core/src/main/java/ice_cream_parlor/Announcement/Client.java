package ice_cream_parlor.Announcement;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import ice_cream_parlor.RabbitMqManager;

public class Client {

    public static void main( String[] args ) throws Exception
    {
        String v_exchangeName = ExchangeNames.Announcement.toString();
        Channel  v_channel = RabbitMqManager.createChannel(v_exchangeName,"fanout");

        String v_queueName = v_channel.queueDeclare().getQueue();
        v_channel.queueBind(v_queueName, v_exchangeName, "");

        System.out.println("Pressione Ctrl + C para finalizar o atendimento");
        DeliverCallback v_deliverCallback = (p_consumerTag, p_delivery) -> {
            String v_message = new String(p_delivery.getBody(), "UTF-8");
            System.out.println(v_message);
        };
        v_channel.basicConsume(v_queueName, true, v_deliverCallback, p_consumerTag -> {});
    }
}
