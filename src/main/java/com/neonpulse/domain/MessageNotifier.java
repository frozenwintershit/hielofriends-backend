package com.neonpulse.domain;

public interface MessageNotifier {
    void sendNotification(String recipient, String message);
}