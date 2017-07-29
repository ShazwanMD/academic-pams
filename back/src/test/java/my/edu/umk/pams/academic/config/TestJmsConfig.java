package my.edu.umk.pams.academic.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.integration.dsl.support.Function;
import org.springframework.integration.dsl.support.FunctionExpression;
import org.springframework.integration.jms.JmsSendingMessageHandler;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;

import my.edu.umk.pams.academic.term.service.TermServiceImpl;
import my.edu.umk.pams.connector.payload.ProgramCodePayload;

@TestConfiguration
@EnableJms
public class TestJmsConfig {

    private static final Logger LOG = LoggerFactory.getLogger(TestJmsConfig.class);

    @Bean
    public JmsSendingMessageHandler jmsMessageHandler(final JmsTemplate jmsTemplate, final ConnectionFactory connectionFactory) {
        LOG.debug("we have jms template: " + jmsTemplate);
        LOG.debug("we have connection Factory: " + connectionFactory);
        JmsSendingMessageHandler handler = new JmsSendingMessageHandler(jmsTemplate);
        handler.setDestinationExpression(new FunctionExpression<>(new DestinationExpressionFunction()));
        handler.setExtractPayload(true);
        return handler;
    }

    private class DestinationExpressionFunction implements Function<GenericMessage, Object> {
        private final Map<String, ActiveMQQueue> queueMap;

        // map to queue or topic
        public DestinationExpressionFunction() {
            queueMap = new HashMap<>();
            queueMap.put(ProgramCodePayload.class.getName(), new ActiveMQQueue("programCodeQueue"));
        }

        @Override
        public Object apply(GenericMessage message) {
            Object objectType = message.getHeaders().get("json__TypeId__");
            return queueMap.get(((Class) objectType).getName());
        }
    }
}
