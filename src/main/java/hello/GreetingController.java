package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by GuoJianFeng on 3/6/18.
 */

@RestController
//HTTP requests are handled by a controller that identified by the @RestController annotation
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    //GreetingController below handles GET requests for /greeting by returning a new instance of the Greeting class
    //The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
    /**
     * The above example does not specify GET vs. PUT, POST, and so forth
     * because @RequestMapping maps all HTTP operations by default
     * Use @RequestMapping(method=GET) to narrow this mapping.
     */
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
