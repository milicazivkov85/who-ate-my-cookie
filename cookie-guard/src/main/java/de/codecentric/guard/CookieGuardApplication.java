package de.codecentric.guard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CookieGuardApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CookieGuardApplication.class);
    }
}
