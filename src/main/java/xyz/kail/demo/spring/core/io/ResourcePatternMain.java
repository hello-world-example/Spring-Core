package xyz.kail.demo.spring.core.io;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

import static org.springframework.core.io.support.ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX;

public class ResourcePatternMain {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourceLoader.getResources(CLASSPATH_ALL_URL_PREFIX + "**/lic*.txt");
        for (Resource resource : resources) {
            System.out.println(resource.getURI());
        }

        resources = resourceLoader.getResources("/WEB-INF/Asd*.txt");
        for (Resource resource : resources) {
            System.out.println(resource.getURI());
        }


    }

}
