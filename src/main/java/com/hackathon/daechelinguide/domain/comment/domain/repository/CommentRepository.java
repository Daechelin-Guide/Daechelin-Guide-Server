package com.hackathon.daechelinguide.domain.comment.domain.repository;

import com.hackathon.daechelinguide.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}