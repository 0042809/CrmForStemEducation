package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
