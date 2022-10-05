package com.sms.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.common.entity.LectureHall;


public interface LectureHallRepository extends JpaRepository<LectureHall, Integer> {

	//method to be used to check the existence of  lecture Hall before deletion
	Long countById(Integer id);

	
}
