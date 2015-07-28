package ru.kos.gwtwebsocket.client;

/**
 * Created by Константин on 27.07.2015.
 */
public class WSConfigurationValidator {

    public static void validate(WSConfiguration configuration) {
        if (configuration == null) throw new IllegalArgumentException("Websocket configuration is null");
        if (configuration.getCallback() == null) throw new IllegalArgumentException("Websocket Callback is null");
        if (configuration.getGClass() == null) throw new IllegalArgumentException("Websocket G class is null. Use G.getClass");
        if (configuration.getSClass() == null) throw new IllegalArgumentException("Websocket S class is null. Use S.getClass");
        if (configuration.getUrl() == null) throw new IllegalArgumentException("Websocket URL is null");
        if (configuration.getSubscribeUrl() == null) throw new IllegalArgumentException("Websocket subscribe URL is null");
        if (configuration.getAutoBeanFactory() == null) throw new IllegalArgumentException("Websocket autoBeanFactory is null");
    }
}
