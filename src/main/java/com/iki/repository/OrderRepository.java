package com.iki.repository;

import com.iki.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
