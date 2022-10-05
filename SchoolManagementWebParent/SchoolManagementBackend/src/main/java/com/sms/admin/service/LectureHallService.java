package com.sms.admin.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sms.admin.controller.LectureHallNotFoundException;
import com.sms.admin.repository.ClassSectionRepository;
import com.sms.admin.repository.LectureHallRepository;
import com.sms.common.entity.ClassSection;
import com.sms.common.entity.LectureHall;

@Service
public class LectureHallService {
	
	@Autowired LectureHallRepository repoLectureHall;
	
	@Autowired ClassSectionRepository repoClassSections;

	//method that list all class room
	public List<LectureHall> listAllLectureHalls(){
		return repoLectureHall.findAll();
	}
	
	//method that list all class sections
		public List<ClassSection> listAllClassSections(){
			return (List<ClassSection>) repoClassSections.findAll();
		}
	
	//method that insert data
		public LectureHall saveLectureHall(LectureHall lectureHall) {
			return repoLectureHall.save(lectureHall);
		}
		
		//method that get class by id
		public LectureHall getLectureHall(Integer id) throws LectureHallNotFoundException {
			try {
				return repoLectureHall.findById(id).get();
			} catch (NoSuchElementException ex) {
				throw new LectureHallNotFoundException("Could not find class with ID " + id);
			}
		}
		
		//method to delete lecture Hall
		public void delete(Integer id) throws LectureHallNotFoundException {
			
			Long countById = repoLectureHall.countById(id); //method call
			
			//throws exception if count by Id is null or equal to 0
			// thus class room with the given Id does not exist in the db
			if(countById == null || countById == 0) {
				throw new LectureHallNotFoundException("Could not find the class room with ID" + id);
			}
			repoLectureHall.deleteById(id);
		}
}
