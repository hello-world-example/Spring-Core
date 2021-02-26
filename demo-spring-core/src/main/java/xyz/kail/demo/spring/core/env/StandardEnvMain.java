package xyz.kail.demo.spring.core.env;

import org.springframework.core.env.StandardEnvironment;

public class StandardEnvMain {

    public static void main(String[] args) {
        StandardEnvironment environment = new StandardEnvironment();

        System.out.println(environment.getProperty("user.home"));
        System.out.println(environment.resolvePlaceholders("My Home Is ${user.home}"));

    }


}
