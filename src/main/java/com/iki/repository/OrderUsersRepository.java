package com.iki.repository;

import com.iki.domain.entity.OrderUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderUsersRepository extends JpaRepository<OrderUsers, Long> {
}
