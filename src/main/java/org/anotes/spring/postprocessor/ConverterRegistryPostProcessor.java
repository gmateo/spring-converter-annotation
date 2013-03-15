package org.anotes.spring.postprocessor;

import org.anotes.spring.stereotype.TypeConverter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: gmc
 * Date: 14/03/13
 */
public class ConverterRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registry.registerBeanDefinition("conversionService", BeanDefinitionBuilder.rootBeanDefinition(ConversionServiceFactoryBean.class).getBeanDefinition());
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Object> beansWithAnnotation = beanFactory.getBeansWithAnnotation(TypeConverter.class);
        Set converters = new HashSet();
        converters.addAll(beansWithAnnotation.values());
        DefaultConversionService conversionService = (DefaultConversionService) beanFactory.getBean("conversionService");
        for (Object converter : converters) {
            conversionService.addConverter((Converter<?, ?>) converter);
        }
    }
}
