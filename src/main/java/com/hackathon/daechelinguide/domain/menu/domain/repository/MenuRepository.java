package com.hackathon.daechelinguide.domain.menu.domain.repository;

import com.hackathon.daechelinguide.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    boolean existsByDate(String date);
    boolean existsMenuByBreakfastOrLunchOrDinner(String Breakfast, String Lunch, String Dinner);

    Optional<Menu> findByDate(String date);

    @Query(value = "select (select breakfast from menu where breakfast = :menus), (select lunch from menu where lunch = :menus), (select dinner from menu where dinner = :menus) from menu", nativeQuery = true)
    String findByMenus(@Param("menus")String menus);

    @Query(value = "select date from menu where breakfast = :menus or lunch = :menus or dinner = :menus", nativeQuery = true)
    String findByDates(@Param("menus")String menus);
}
