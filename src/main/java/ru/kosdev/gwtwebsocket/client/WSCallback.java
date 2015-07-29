package ru.kosdev.gwtwebsocket.client;

/**
 * Created by Константин on 26.07.2015.
 */
public interface WSCallback<T> {
    void onMessage(T message);
}
