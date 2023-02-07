package com.hackathon.daechelinguide.domain.menu.domain.repository;

import com.hackathon.daechelinguide.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
