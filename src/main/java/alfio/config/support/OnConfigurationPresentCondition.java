package alfio.config.support;

import alfio.manager.system.ConfigurationManager;
import alfio.model.system.Configuration;
import alfio.model.system.ConfigurationKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Created by andrew on 7/10/16.
 */
public class OnConfigurationPresentCondition implements Condition {

    @Autowired
    private ConfigurationManager configurationManager;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes =
            metadata.getAnnotationAttributes(ConditionalOnConfigurationPresentProperty.class.getName());

        Configuration.ConfigurationPathKey key = Configuration.getSystemConfiguration(
            (ConfigurationKeys) attributes.get("value"));
        boolean configPropExistsCheck = (Boolean) attributes.get("exists");

        return configPropExistsCheck ^ configurationManager.getStringConfigValue(key).isPresent();
    }
}