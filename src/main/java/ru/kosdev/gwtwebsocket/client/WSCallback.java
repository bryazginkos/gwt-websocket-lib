package ru.kosdev.gwtwebsocket.client;

/**
 * Created by ���������� on 26.07.2015.
 */
public interface WSCallback<T> {
    void onMessage(T message);
}
