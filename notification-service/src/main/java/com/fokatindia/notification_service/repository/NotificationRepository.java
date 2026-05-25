package com.fokatindia.notification_service.repository;

import com.fokatindia.notification_service.entity.Notifications;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends ReactiveCrudRepository<Notifications, Long> {
}