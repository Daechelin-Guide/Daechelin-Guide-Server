package com.hackathon.daechelinguide.domain.review.domain.repository;

import com.hackathon.daechelinguide.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "select AVG(star) from review where date = :dates AND menu = :menus",nativeQuery = true)
    Integer findByDateAndMenu(@Param("dates") String date, @Param("menus") String menu);
}
