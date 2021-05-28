package xyz.kail.demo.spring.core;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 泛型工具类
 * <p>
 * Spring4 新特性——更好的 Java 泛型操作 API： https://www.iteye.com/blog/jinnianshilongnian-1993608
 *
 * @see org.springframework.core.ResolvableType
 */
public class ResolvableTypeMain {

    public static void main(String[] args) {

        // 定义泛型
        ParameterizedTypeReference<Map<String, List<Integer>>> typeReference = new ParameterizedTypeReference<Map<String, List<Integer>>>() {
        };

        // 获取类型: java.util.Map<java.lang.String, java.util.List<java.lang.Integer>>
        final Type type = typeReference.getType();
        System.out.println(type);

        /*
         * 使用 ResolvableType
         */
        final ResolvableType resolvableType = ResolvableType.forType(typeReference);

        // 获取泛型类型
        final Class<?> resolve = resolvableType.resolve();
        // java.util.Map
        System.out.println(resolve);

        final Object source = resolvableType.getSource();
        // sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        System.out.println(source.getClass());

        // 获取 第二个泛型类型
        final ResolvableType generic = resolvableType.getGeneric(1);
        // java.util.List<java.lang.Integer>
        System.out.println(generic);

        // 泛型的原始类型
        final Class<?> rawClass = resolvableType.getGeneric(1).getGeneric(0).getRawClass();
        // class java.lang.Integer
        System.out.println(rawClass);


    }

}
