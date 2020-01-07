package camel.aggregate;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AggRoute extends RouteBuilder {

    @Autowired
    private AggStrategy strategy;

    @Override
    public void configure() {
        /*from("jms:agg-queue").aggregate(header("JMSCorrelationID"), strategy)
                .completionTimeout(15000)
                .log("body: ${body}")
                .to("direct:hello");*/
        from("direct:agg")
                .log("body before aggregation: ${body}")
                .aggregate(header("id"), strategy)
                .completionTimeout(1000)
                .log("body after aggregation: ${body}")
                .to("direct:hello");
    }
}