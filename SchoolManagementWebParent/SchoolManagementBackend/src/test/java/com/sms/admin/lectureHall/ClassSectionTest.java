package com.sms.admin.lectureHall;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sms.admin.repository.ClassSectionRepository;
import com.sms.common.entity.ClassSection;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ClassSectionTest {

	@Autowired ClassSectionRepository repo;
	
	@Test
	public void createSection() {
		
		//create sections
		ClassSection section = new ClassSection(1,"A");
		ClassSection saveSection = repo.save(section);
		
		assertThat(saveSection.getId()).isGreaterThan(0);
	}
	
	@Test
	public void createSection2() {
		
		//create sections
		ClassSection section1 = new ClassSection("B");
		ClassSection section2 = new ClassSection("C");
		ClassSection section3 = new ClassSection("D");
		
		//save all section
		repo.saveAll(List.of(section1, section2, section3));
	}
	
}
