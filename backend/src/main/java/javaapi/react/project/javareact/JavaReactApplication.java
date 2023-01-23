package javaapi.react.project.javareact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;

@SpringBootApplication(scanBasePackageClasses = {JavaReactApplication.class})
@Configuration
@EnableJpaRepositories({"javaapi.react.project.javareact.repository"})
public class JavaReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaReactApplication.class, args);
    }

}
