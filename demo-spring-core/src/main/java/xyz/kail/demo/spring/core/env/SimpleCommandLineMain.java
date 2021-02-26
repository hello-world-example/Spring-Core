package xyz.kail.demo.spring.core.env;

import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.util.Arrays;

public class SimpleCommandLineMain {

    public static void main(String[] args) {
        args = Arrays.asList(
                "--server.port=8080",
                "--server.ctx=/test",
                "--bar",
                "--foo=bar,baz,biz"
        ).toArray(args);

        SimpleCommandLinePropertySource commandLine = new SimpleCommandLinePropertySource(args);

        System.out.println(Arrays.asList(commandLine.getPropertyNames()));
        System.out.println(commandLine.getProperty("server.port"));
        System.out.println(commandLine.getName());
        System.out.println(commandLine.getProperty("bar"));
        System.out.println(commandLine.containsProperty("bar"));
        System.out.println(commandLine.getProperty("foo"));
    }

}
