package ru.kosdev.gwtwebsocket.client;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

/**
 * Created by Константин on 26.07.2015.
 */
public class Converter<I> {

    private Class<I> iClass;

    private AutoBeanFactory autoBeanFactory;

    public Converter(Class<I> iClass, AutoBeanFactory autoBeanFactory) {
        this.autoBeanFactory = autoBeanFactory;
        this.iClass = iClass;
    }

    public String serialize(I data) {
        AutoBean<I> bean = autoBeanFactory.create(iClass, data);
        return AutoBeanCodex.encode(bean).getPayload();
    }

    public I deserialize(String json) {
        AutoBean<I> bean = AutoBeanCodex.decode(autoBeanFactory, iClass, json);
        return bean.as();
    }

}
