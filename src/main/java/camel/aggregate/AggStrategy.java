package camel.aggregate;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

/**
 * http://people.apache.org/~dkulp/camel/aggregate-example.html
 */
@Component
public class AggStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        String a = oldExchange.getIn().getBody(String.class);
        String b = newExchange.getIn().getBody(String.class);

        // just avoid bad inputs by assuming its a 0 value
        String c = a + "," + b;
        oldExchange.getIn().setBody(c);

        return oldExchange;
    }
}
