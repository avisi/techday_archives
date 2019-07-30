package nl.avisi.labs.techday.advanced;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.function.Function;

@Controller
@SpringBootApplication
public class SpringSLApplication {

    @Value(value = "classpath:square.sl")
    private Resource slSource;

    @Autowired
    private Function<Integer, Long> squareFunction;

    @Bean
    Function<Integer, Long> getSquareFunction(@Autowired Context ctx)
            throws IOException {
        Source source = Source.newBuilder("sl", slSource.getURL()).build();
        return ctx.eval(source).as(Function.class);
    }

    @RequestMapping(value = "/{input}", produces = "text/html")
    public ResponseEntity<String> square(@PathVariable("input") Integer input) {
        // the Bean initialized earlier defines a Fucntion which maps an Integer to a Long
        // this is where the actual interop between Java and SL happens

        String square =
                squareFunction.apply(input).toString();
        return new ResponseEntity<>(
                square,
                HttpStatus.OK);
    }

    @Bean
    public Context getGraalVMContext() {
        return Context.newBuilder().allowAllAccess(true).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSLApplication.class, args);
    }

}
