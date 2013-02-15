package nl.avisi.server.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:springmvc-resteasy.xml")
public class RestEasyConfiguration {

    public RestEasyConfiguration() {
        System.out.println("INIT REST EASY");
    }
}
