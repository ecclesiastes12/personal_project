package com.sms.admin.subjects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sms.common.entity.Subjects;

@Controller
public class SubjectController {

	SubjectService subjectService;
	
	@GetMapping("/subjects")
	public String showSubjects(Subjects subjects, Model model) {
		
		Subjects subject = new Subjects();
		
		model.addAttribute("subject", subject);
		
		return "academics/subjectList";
	}
	
	//handler method that saves subjects
		@GetMapping("/subjects/new")
		public String showSubjectForm(Model model) {
			
			Subjects subject = new Subjects();
			
			model.addAttribute("subject", subject);
			
			return "redirect:/subjectList";
		}
	//handler method that saves subjects
	
		@PostMapping("/subjects/save")
	public String saveSubject(Subjects subject) {
		
		subjectService.saveSubject(subject);
		
		return "redirect:/subjectList";
	}
}
