package by.jmp.module18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Kiryl_Parfiankou on 4/13/2016.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"by.jmp.module18.rest", "by.jmp.module16.service"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
