package com.sms.admin.lectureHall;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sms.admin.repository.LectureHallRepository;
import com.sms.common.entity.ClassSection;
import com.sms.common.entity.LectureHall;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class LectureHallTest {

	@Autowired LectureHallRepository repo;
	
	@Autowired TestEntityManager entityManager;
	
	//test method that create a lecture hall
	@Test
	public void createLectureHall() {
		
		//find class section 
		ClassSection classroomSection = entityManager.find(ClassSection.class, 1);
		
		//creates a lecture hall object
		LectureHall  classroomHall = new LectureHall(1,"KG");
		
		//add class section to the lecture hall
		classroomHall.addSections(classroomSection);
		
		//save class room
		LectureHall saveClassroom = repo.save(classroomHall);
		
		assertThat(saveClassroom.getId()).isGreaterThan(0);
		
		
		
	}
}
