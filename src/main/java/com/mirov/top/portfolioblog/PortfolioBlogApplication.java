package com.mirov.top.portfolioblog;

import com.mirov.top.portfolioblog.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PortfolioBlogApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(PortfolioBlogApplication.class, args);
        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println(userService.findById(1));
    }

}
