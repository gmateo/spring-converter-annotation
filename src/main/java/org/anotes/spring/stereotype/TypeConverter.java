package org.anotes.spring.stereotype;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * User: gmc
 * Date: 14/03/13
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface TypeConverter {
}

