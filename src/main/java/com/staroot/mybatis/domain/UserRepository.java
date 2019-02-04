package com.staroot.mybatis.domain;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Serializable>{
	User findByUserId(String userId);
}
