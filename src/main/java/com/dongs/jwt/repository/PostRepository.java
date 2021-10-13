package com.dongs.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongs.jwt.domain.post.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	public PostRepository findByEndType(int endType);
}
