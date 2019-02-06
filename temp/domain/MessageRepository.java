package com.staroot.mybatis.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>{
	public List<Message> findAllByOrderByIdDesc();
	
	public List<Message> findTop2ByOrderByIdDesc();
}

/*
@Repository
public interface MessageRepository extends CrudRepository{
	
	@Query("select MSG_ID from message")
	List<?> getMessage();
}
*/