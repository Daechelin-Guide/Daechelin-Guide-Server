package com.hackathon.daechelinguide.domain.comment.domain.repository;

import com.hackathon.daechelinguide.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "select * from comment where date = :dates AND menu = :menus order by comment_id DESC ",nativeQuery = true)
    Optional<List<Comment>> findByMessage(@Param("menus") String menus, @Param("dates") String dates);
}