package org.anotes.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: gmc
 * Date: 14/03/13
 */
public class ConverterRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, BeanPostProcessor, ApplicationContextAware {
    private final String CONVERSION_SERVICE_NAME = "conversionService";

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registry.registerBeanDefinition(CONVERSION_SERVICE_NAME, BeanDefinitionBuilder.rootBeanDefinition(ConversionServiceFactoryBean.class).getBeanDefinition());
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (CONVERSION_SERVICE_NAME.equals(beanName)) {
            Map<String, Converter> beansOfType = appCtx.getBeansOfType(Converter.class);
            ConversionServiceFactoryBean conversionfactoryBean = (ConversionServiceFactoryBean) bean;
            Set converters = new HashSet(beansOfType.values());
            conversionfactoryBean.setConverters(converters);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    ApplicationContext appCtx;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }

}
