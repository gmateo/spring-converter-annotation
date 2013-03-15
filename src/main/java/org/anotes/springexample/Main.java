package org.anotes.springexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

import java.util.Date;

/**
 * User: gmc
 * Date: 14/03/13
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        String configFiles = "classpath*:/app-context.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configFiles);
        Client client = createClient();
        ConversionService conversionService = (ConversionService) context.getBean("conversionService");
        Person person = conversionService.convert(client, Person.class);
        logger.info("Client:{}", client );
        logger.info("Person:{}", person );
    }

    private static Client createClient() {
        Client client = new Client();
        client.setName("Joseph");
        client.setAddress("St Main Square");
        client.setGender("M");
        client.setSubscriptionDate(new Date());
        return client;
    }
}
