package my.app2;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * Created by eisig on 2019/2/27.
 */
@Controller
public class HelloController {


    @Get("/hello")
    public String sayHello() {
        return "hello";
    }


}
