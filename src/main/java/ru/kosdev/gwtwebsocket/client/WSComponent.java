package ru.kosdev.gwtwebsocket.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

/**
 * Created by kos on 25.07.2015.
 */
public class WSComponent<S, G> {

    private static boolean loadedLib = false;

    private JavaScriptObject stompClient;
    private final Converter<S>  sConverter;
    private final Converter<G>  gConverter;

    private final WSConfiguration<S, G> configuration;

    private WSCallback<G> callback;

    private final String url;
    private final String subscribeUrl;

    public WSComponent(WSConfiguration<S, G> configuration) {
        super();
        WSConfigurationValidator.validate(configuration);
        this.configuration = configuration;
        this.url = configuration.getUrl();
        this.subscribeUrl = configuration.getSubscribeUrl();
        sConverter = new Converter<S>(configuration.getSClass(), configuration.getAutoBeanFactory());
        gConverter = new Converter<G>(configuration.getGClass(), configuration.getAutoBeanFactory());
        if (!loadedLib) {
            loadScripts();
        }
    }

    private static void loadScripts() {
        ScriptInjector.fromUrl("stomp.js").inject();
        ScriptInjector.fromUrl("sockjs-0.3.4.js").inject();
        loadedLib = true;
    }

    public void send(S s, String url) {
        String json = sConverter.serialize(s);
        send(url, json);
    }

    public native void disconnect() /*-{
        if (stompClient != null) {
            stompClient.disconnect();
        }
    }-*/;

    public native void connect() /*-{
        var obj = this;
        var socket = new SockJS(obj.@ru.kosdev.gwtwebsocket.client.WSComponent::url);
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe(obj.@ru.kosdev.gwtwebsocket.client.WSComponent::subscribeUrl, function(answer){
                obj.@ru.kosdev.gwtwebsocket.client.WSComponent::handleAnswer(Ljava/lang/String;)(answer.body);
            });
        });
    }-*/;

    private void handleAnswer(String answer) {
        G ans = gConverter.deserialize(answer);
        if (callback != null) {
            callback.onMessage(ans);
        }
    }

    private native void send(String sendUrl, String json) /*-{
        stompClient.send(sendUrl, {}, json);
    }-*/;

    public void setCallback(WSCallback<G> callback) {
        this.callback = callback;
    }
}
