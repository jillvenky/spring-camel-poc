package camel.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * JMS Example
 */
@Component
public class JMSRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("jms:in-queue")
                .to("jms:out-queue");
    }
}