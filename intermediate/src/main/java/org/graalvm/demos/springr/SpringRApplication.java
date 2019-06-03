package org.graalvm.demos.springr;

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
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;

@Controller
@SpringBootApplication
public class SpringRApplication {

    @Value(value = "classpath:plot.R")
    private Resource rSource;

    @Autowired
    private BiFunction<DataHolder, DataHolder, String> plotFunction;

    @Bean
    BiFunction<DataHolder, DataHolder, String> o(@Autowired Context ctx)
            throws IOException {
        //
        Source source = null;

        // The source for rendereing a graph is found on the classpath as plot.R
        // Use the Source.newBuilder to build a source

        // we can interpret R code as a BiFunction
        return ctx.eval(source).as(BiFunction.class);
    }

    @RequestMapping(value = "/forecast", produces = "image/svg+xml")
    public ResponseEntity<String> forecast() {
        String svg = "";
        List<Double> forecasts = new ArrayList<>();
        List<Long> timestamps = new ArrayList<>();

        // the Bean initialized earlier defines a BiFunction which maps two lists to a String
        svg = plotFunction.apply(new DataHolder<>(forecasts), new DataHolder<>(timestamps));
        return new ResponseEntity<String>(
                svg,
                HttpStatus.OK);
    }

    @Bean
    public Context getGraalVMContext() {
        return Context.newBuilder().allowAllAccess(true).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRApplication.class, args);
    }

}
