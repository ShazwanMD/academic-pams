package my.edu.umk.pams.academic.config;

import my.edu.umk.pams.academic.planner.event.ProgramEvent;
import my.edu.umk.pams.academic.term.event.AdmissionEvent;
import my.edu.umk.pams.academic.term.event.EnrollmentEvent;
import my.edu.umk.pams.connector.payload.ProgramCodePayload;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.support.Function;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.event.inbound.ApplicationEventListeningMessageProducer;
import org.springframework.integration.jms.JmsSendingMessageHandler;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * @author PAMS
 */
public class IntegrationConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Environment env;

    @Bean
    public Destination chargeQueue() {
        return new ActiveMQQueue("charge");
    }

    @Bean
    public MessageChannel channelError() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel channelLog() {
        return new DirectChannel();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(env.getProperty("broker.url"));
    }

    @Bean
    public ConnectionFactory cacheConnectionFactory() {
        CachingConnectionFactory connFactory = new CachingConnectionFactory();
        connFactory.setClientId("pams-academic");
        connFactory.setTargetConnectionFactory(connFactory);
        connFactory.setSessionCacheSize(5);
        return connFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setPubSubDomain(true);
        template.setDeliveryMode(2);
        template.setSessionAcknowledgeMode(2);
        template.setExplicitQosEnabled(true);
        return template;
    }

    @Bean
    public JmsSendingMessageHandler jmsAdapter() {
        JmsSendingMessageHandler handler = new JmsSendingMessageHandler(jmsTemplate());
        handler.setDestination(chargeQueue());
        handler.setExtractPayload(true);
        return handler;
    }

    @Bean
    public ApplicationEventListeningMessageProducer termEventAdapter() {
        ApplicationEventListeningMessageProducer producer = new ApplicationEventListeningMessageProducer();
        producer.setApplicationContext(applicationContext);
        producer.setEventTypes(
                AdmissionEvent.class,
                EnrollmentEvent.class,
                ProgramEvent.class);
        producer.setPayloadExpressionString("payload");
        return producer;
    }

    @Bean
    public IntegrationFlow integrationFlow() {
        return IntegrationFlows.from(termEventAdapter())
                .transform(Transformers.toJson(ObjectToJsonTransformer.ResultType.STRING,
                        MediaType.APPLICATION_JSON_VALUE))
                .handle((payload, headers) -> {
                    return payload;
                })
                .handle(jmsAdapter())
                .get();
    }

    private class DestinationExpressionFunction implements Function<GenericMessage, Object> {

        private final Map<String, ActiveMQQueue> queueMap;

        // map to queue or topic
        public DestinationExpressionFunction() {
                queueMap = new HashMap<>();
            queueMap.put(ProgramCodePayload.class.getName(), new ActiveMQQueue("programCodeQeueu"));
        }

        @Override
        public Object apply(GenericMessage message) {
            Object objectType = message.getHeaders().get("json__TypeId__");
            return queueMap.get(((Class) objectType).getName());
        }
    }
}
