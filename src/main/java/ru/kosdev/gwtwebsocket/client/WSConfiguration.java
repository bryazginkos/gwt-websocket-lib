package ru.kosdev.gwtwebsocket.client;

import com.google.web.bindery.autobean.shared.AutoBeanFactory;

/**
 * Created by Константин on 27.07.2015.
 */
public class WSConfiguration<S, G> {

    private Class<S> sClass;
    private Class<G> gClass;

    private AutoBeanFactory autoBeanFactory;

    private String url;
    private String subscribeUrl;

    private WSCallback<G> callback;

    public WSConfiguration() {
    }

    public Class<S> getSClass() {
        return sClass;
    }

    public WSConfiguration<S,G> withSClass(Class<S> sClass) {
        this.sClass = sClass;
        return this;
    }

    public Class<G> getGClass() {
        return gClass;
    }

    public WSConfiguration<S, G> withGClass(Class<G> gClass) {
        this.gClass = gClass;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public WSConfiguration<S, G> withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSubscribeUrl() {
        return subscribeUrl;
    }

    public WSConfiguration<S, G> withSubscribeUrl(String subscribeUrl) {
        this.subscribeUrl = subscribeUrl;
        return this;
    }

    public WSCallback<G> getCallback() {
        return callback;
    }

    public WSConfiguration<S, G> withCallback(WSCallback<G> callback) {
        this.callback = callback;
        return this;
    }

    public AutoBeanFactory getAutoBeanFactory() {
        return autoBeanFactory;
    }

    public WSConfiguration<S, G> withAutoBeanFactory(AutoBeanFactory autoBeanFactory) {
        this.autoBeanFactory = autoBeanFactory;
        return this;
    }
}
