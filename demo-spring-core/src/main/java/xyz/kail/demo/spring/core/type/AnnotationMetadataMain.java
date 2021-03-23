package xyz.kail.demo.spring.core.type;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@Resource(name = "test")
public class AnnotationMetadataMain {

    @PostConstruct
    public void asd(){

    }

    @PostConstruct
    public static void main(String[] args) {

        /**
         * 获取 Class 的注解数据
         */
        AnnotationMetadata classMetadata = AnnotationMetadata.introspect(AnnotationMetadataMain.class);

        Map<String, Object> annotationAttributes = classMetadata.getAnnotationAttributes(Resource.class.getName());
        System.out.println(annotationAttributes);

        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationAttributes);
        final String name = attributes.getString("name");
        System.out.println(name);

        /**
         * 获取带有注解方法信息
         */
        Set<MethodMetadata> annotatedMethods = classMetadata.getAnnotatedMethods(PostConstruct.class.getName());
        System.out.println(annotatedMethods);

    }

}
