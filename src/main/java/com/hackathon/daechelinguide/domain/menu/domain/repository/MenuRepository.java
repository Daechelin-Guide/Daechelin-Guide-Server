package com.hackathon.daechelinguide.domain.menu.domain.repository;

import com.hackathon.daechelinguide.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    boolean existsByDate(String date);

    Optional<Menu> findByDate(String date);
}
