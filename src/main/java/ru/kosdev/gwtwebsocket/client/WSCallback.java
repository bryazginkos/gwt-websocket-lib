package ru.kosdev.gwtwebsocket.client;

/**
 * Created by kos on 26.07.2015.
 */
public interface WSCallback<T> {
    void onMessage(T message);
}
