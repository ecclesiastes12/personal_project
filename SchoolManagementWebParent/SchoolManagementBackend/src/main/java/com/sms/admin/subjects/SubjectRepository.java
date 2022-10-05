package com.sms.admin.subjects;

import org.springframework.data.repository.CrudRepository;

import com.sms.common.entity.Subjects;

public interface SubjectRepository extends CrudRepository<Subjects, Integer>{

	//method to be used to check the existence of  lecture Hall before deletion
	Long countById(Integer id);

}
