package com.ailot.mvc.v1.annotation;

import java.lang.annotation.*;

/**
 * @author ailot
 * @version Controller.java, 2019年04月07日 上午11:41
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    String value() default  "";
}
