package xyz.kail.demo.spring.core.annotation;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.Resource;
import java.util.Map;

@Resource(name = "test")
public class AnnotationMetadataMain {

    public static void main(String[] args) {

        AnnotationMetadata introspect = AnnotationMetadata.introspect(AnnotationMetadataMain.class);

        Map<String, Object> annotationAttributes = introspect.getAnnotationAttributes(Resource.class.getName());
        System.out.println(annotationAttributes);

        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationAttributes);
        final String name = attributes.getString("name");
        System.out.println(name);


    }

}
