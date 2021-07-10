package com.cuong.service;

import com.cuong.model.Notification;
import com.cuong.model.User;

import java.util.List;

public interface NotificationService {
    void save(Notification notification);
    List<Notification> findAll();
    void delete(Notification notification);

    List<Notification> findAllByUserReceiveOrderById(User user);

    void deleteAllNotificationByUser(User user);

    // delete notification by id

    void deleteNotificationById(Long id);
}
