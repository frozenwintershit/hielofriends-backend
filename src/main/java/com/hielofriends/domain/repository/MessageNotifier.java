package com.hielofriends.domain;

public interface MessageNotifier {
    void sendNotification(String recipient, String message);
}