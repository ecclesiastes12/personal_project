package com.sms.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lecture_halls")
public class LectureHall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "class_name",length = 45, nullable = false)
	String name;
	
	//NB Set does not allow duplucate elements whiles Collection allows duplicate elements
	
	@ManyToMany
	@JoinTable(
			name = "lectureHall_sections",
			joinColumns = @JoinColumn(name ="lectureHall_id"),
			inverseJoinColumns = @JoinColumn(name = "section_id")
			)
	Set<ClassSection> sections = new HashSet<>();
	
	public LectureHall() {
	}
	
	public LectureHall(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ClassSection> getSections() {
		return sections;
	}

	public void setSections(Set<ClassSection> sections) {
		this.sections = sections;
	}

	// method that add section to lecture hall
	public void addSections(ClassSection sections) {
		this.sections.add(sections);
	}

//	@Override
//	public String toString() {
//		return "LectureHall [id=" + id + ", name=" + name + ", sections=" + sections + "]";
//	}
	
	
	
}
