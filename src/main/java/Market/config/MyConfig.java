package Market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@ComponentScan("Market")
public class MyConfig {

    @Bean
    public Scanner setScanner () {
        return new Scanner(System.in);
    }

    @Bean
    @Scope("prototype")
    public List<Object> list() {
        return new ArrayList<>();
    }
}