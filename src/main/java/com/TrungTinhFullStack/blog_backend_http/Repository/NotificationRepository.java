package com.TrungTinhFullStack.blog_backend_http.Repository;

import com.TrungTinhFullStack.blog_backend_http.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
