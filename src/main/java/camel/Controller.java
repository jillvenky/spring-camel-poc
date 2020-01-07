package camel;

import hello.FileCopierWithCamel;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private FluentProducerTemplate producer;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {

        producer.to("direct:hello").request();
        return "Done!";
    }

    @RequestMapping("/agg")
    public String agg() throws Exception {

        producer.withHeader("id", "1").withBody("1-1").to("direct:agg").request();
        producer.withHeader("id", "1").withBody("1-2").to("direct:agg").request();
        producer.withHeader("id", "2").withBody("2-1").to("direct:agg").request();
        producer.withHeader("id", "1").withBody("1-3").to("direct:agg").request();
        producer.withHeader("id", "2").withBody("2-1").to("direct:agg").request();
        return "Done!";
    }

    @RequestMapping("/trigger")
    public String trigger(@RequestParam("target") String target) throws Exception {
        producer.to(target).request();
        return "Done!";
    }

}