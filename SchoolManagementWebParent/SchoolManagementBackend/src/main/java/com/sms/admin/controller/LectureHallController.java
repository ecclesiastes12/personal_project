package com.sms.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sms.admin.service.LectureHallService;
import com.sms.common.entity.ClassSection;
import com.sms.common.entity.LectureHall;

@Controller
public class LectureHallController {
	
	@Autowired LectureHallService serviceLectureHall;
	

	//handler method that list all lecture hall
	@GetMapping("/classrooms")
	public String listAllLectureHalls(Model model) {
		
		List<LectureHall> lectureHall = serviceLectureHall.listAllLectureHalls();
		
		model.addAttribute("lectureHall", lectureHall);
		
		return "academics/classsection";
	}
	
	//handler method that show class section form
	@GetMapping("/classrooms/new")
	public String newLectureHall(Model model) {
		
		//grab list of class room sections
		List<ClassSection> listClassSections = serviceLectureHall.listAllClassSections();
		List<LectureHall> listLectureHalls = serviceLectureHall.listAllLectureHalls();
		
		LectureHall lectureHall = new LectureHall();
		
		model.addAttribute("lectureHall", lectureHall);
		model.addAttribute("listClassSections", listClassSections);
		model.addAttribute("listLectureHalls", listLectureHalls);
		
		return "academics/classsection";
	}
	
	
	//handler method that add new class room
	@PostMapping("/classrooms/save")
	public String addLectureHall(LectureHall lectureHall) {
		
		serviceLectureHall.saveLectureHall(lectureHall);
		
		return "redirect:/classrooms/new";
	}
	
	@GetMapping("/classrooms/edit/{id}")
	public String editLectureHall(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes ra) {
		//grab class id
		try {
			LectureHall lectureHall = serviceLectureHall.getLectureHall(id);
			
			List<ClassSection> listClassSections = serviceLectureHall.listAllClassSections();
			//List<LectureHall> listLectureHalls = serviceLectureHall.listAllLectureHalls();
			
			model.addAttribute("lectureHall", lectureHall);
			model.addAttribute("listClassSections", listClassSections);
			//model.addAttribute("listLectureHalls", listLectureHalls);
			
		} catch (LectureHallNotFoundException ex) {
			// TODO Auto-generated catch block
			ra.addFlashAttribute("message", ex.getMessage());
		}
		
		return "academics/lecture_hall_modal";
	}
	
	//handler method that delete a class
	@GetMapping("/classrooms/delete/{id}")
	public String deleteLectureHall(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes ra) {
		
		try {
			//get the id of the class to be deleted
			serviceLectureHall.delete(id);
			
			//display message after lecture hall has been deleted
			ra.addFlashAttribute("message", "Class room with ID " + id + " has been deleted succesfully ");
			
		} catch (LectureHallNotFoundException ex) {
			//display error message if lecture hall id does not exist
			ra.addFlashAttribute("message", ex.getMessage());
		}
		
		
		return "redirect:/classrooms/new";
	}
}
