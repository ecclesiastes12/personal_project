package com.sms.admin.subjects;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.sms.admin.controller.LectureHallNotFoundException;
import com.sms.common.entity.Subjects;

@Service
public class SubjectService {

	SubjectRepository subjectRepo;
	
	
	//service method that list subject
	
	//service method that save subject
	public Subjects saveSubject(Subjects subjects) {
		return subjectRepo.save(subjects);
	}
	
	//service method that get subject by id
	public Subjects getSubjectId(Integer id) throws SubjectNotFoundException{
		try {
			return subjectRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new SubjectNotFoundException("Could not find subject ID: " + id);
		}
	}
	
	//service method that delete subject
	public void deleteSubject(Integer id) throws SubjectNotFoundException {
		Long countById = subjectRepo.countById(id);
		
		//throws exception if count by Id is null or equal to 0
		// thus subject with the given Id does not exist in the db
		if(countById == null || countById == 0) {
			throw new SubjectNotFoundException("Could not Subject with ID" + id);
		}
		
		subjectRepo.deleteById(id);
	}
}
