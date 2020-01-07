package camel.direct;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Use a bean example.
 * Direct is a synchronous call.
 */
@Component
public class DirectRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        /*rest("/").produces("text/plain")
                .get("hello")
                .to("direct:hello");*/

        from("direct:hello")
                .bean("stepA", "process");
    }
}
