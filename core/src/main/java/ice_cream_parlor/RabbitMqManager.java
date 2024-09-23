package ice_cream_parlor;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import com.rabbitmq.client.Channel;

public class RabbitMqManager {
    public static Connection createConnection() throws Exception
    {
        ConnectionFactory v_factory = new ConnectionFactory();
        v_factory.setHost("jackal-01.rmq.cloudamqp.com");
        v_factory.setPort(5672);
        v_factory.setUsername("vizrwfrx");
        v_factory.setPassword("fbr1K1DUqQKVj3VI8KpgOH58SnEOq3KL");
        v_factory.setVirtualHost("vizrwfrx");
        v_factory.setConnectionTimeout(30000);
        Connection v_connection = v_factory.newConnection();

        return v_connection;
    }

    public static Channel createChannel() throws Exception
    {
        Connection v_connection = RabbitMqManager.createConnection();
        Channel v_channel = v_connection.createChannel();
        return v_channel;
    }

    public static Channel createChannel(String p_exchangeName, String p_typeExchange) throws Exception
    {
        Channel v_channel = RabbitMqManager.createChannel();
        v_channel.exchangeDeclare(p_exchangeName, p_typeExchange);
        return v_channel;
    }
}
