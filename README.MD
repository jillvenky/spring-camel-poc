#Apache Camel Sample Code

This project runs Camel along with Spring Boot to demonstrate some examples. 
Note that Camel has RESTLet component that can run REST services without Spring.
The reason we want the two work together is because all our projects are Spring-based.

##How to use

Run the application as a usual spring app.

```./gradlew bootRun```

###Direct Route
This use case demonstrates how to use Direct Route. Direct component is to connect routes: 
the route with `to("direct:xxx")` will make a synchronous call to the route starts with `from("direct:xxx")`.
The implementation also demonstrates how to trigger a bean, which can hold business logic.

To trigger the route, visit `http://localhost:8080/hello`


###JMS
This use case demonstrates how to use Camel to dequeue and enqueue JMS messages.
The example code only moves message from one to another. But it is easy to add some bean to process the message.

Assuming you are running a local ActiveMQ. (This can be done by using the ./infra.sh up w/ CMP project.)

1. Go to `http://localhost:8161/admin/message.jsp`
2. Send some messages to `in-queue`
3. Check the messages are dequeued and enqueued to `out-queue`

###Aggregator
This use case demonstrates how to use Camel to implement the aggregator EIP.
The example aggregate messages with the same id specified in the header. 
The logic is implemented in `AggStrategy` which implements Camel's `AggregationStrategy` interface.

To trigger the route, visit `http://localhost:8080/agg`.
And look at the stdout for aggregated outputs.
