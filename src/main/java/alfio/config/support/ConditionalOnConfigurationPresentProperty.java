package alfio.config.support;

import alfio.model.system.ConfigurationKeys;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by andrew on 7/10/16.
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnConfigurationPresentCondition.class)
public @interface ConditionalOnConfigurationPresentProperty {
    public ConfigurationKeys value();
    public boolean exists() default true;
}
