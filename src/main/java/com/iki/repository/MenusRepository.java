package com.iki.repository;

import com.iki.domain.entity.Menus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenusRepository extends JpaRepository<Menus, Long> {
}
