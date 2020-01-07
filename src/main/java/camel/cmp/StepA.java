package camel.cmp;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * A bean to be triggered by camel route
 */
@Component
public class StepA {
    public void process(Exchange message) {
        System.out.println("CMP Bean StepA.process is triggered");
        System.out.println("Message body: " + message.getIn().getBody());
    }
}
