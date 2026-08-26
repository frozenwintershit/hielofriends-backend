package com.hielofriends.domain.repository;

public interface MessageNotifier {
    void sendNotification(String recipient, String message);
}