package org.anotes.springexample;

import org.anotes.spring.stereotype.TypeConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * User: gmc
 * Date: 14/03/13
 */
@TypeConverter
public class ClientToPerson implements Converter<Client,Person> {
    @Override
    public Person convert(Client source) {
        Person person = new Person();
        BeanUtils.copyProperties(source,person);
        return person;
    }
}
