package subpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.jms.*;

/**
 * Created by Student on 24.10.2016.
 */
public class QueueConsumer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(QueueExamplesConfig.class, args);

        ConnectionFactory connectionFactory = context.getBean(ConnectionFactory.class);

        Queue queue = context.getBean(Queue.class);

        try (Connection connection = connectionFactory.createConnection()){
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);
            TextMessage message = (TextMessage)consumer.receive();
            System.out.println(message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
