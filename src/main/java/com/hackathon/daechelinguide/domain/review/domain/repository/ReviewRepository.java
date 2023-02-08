package com.hackathon.daechelinguide.domain.review.domain.repository;

import com.hackathon.daechelinguide.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsByDateAndMenu(String date, String menu);
    @Query(value = "select AVG(star) from review where date = :dates AND menu = :menus",nativeQuery = true)
    double findByDateAndMenu(@Param("dates") String date, @Param("menus") String menu);
    @Query(value = "select DISTINCT menu, review, date, star from review ORDER BY star DESC ",nativeQuery = true)
    List<Review> findAllByStar();
    @Query(value = "select AVG(star) from review where date = :dates AND menu = :menus",nativeQuery = true)
    Optional<Double> findByStar(@Param("dates") String date, @Param("menus") String menu);
}
