package com.sms.common.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class_sections")
public class ClassSection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	 
	@Column(length = 40, nullable = false, unique = true)
	String name;
	
	public ClassSection() {
		
	}

	public ClassSection(String name) {
		this.name = name;
	}
	public ClassSection(Integer id, String name) {
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassSection other = (ClassSection) obj;
		return Objects.equals(id, other.id);
	}

	//toString method that display the section in a readable format
	@Override
	public String toString() {
		//String stringWithBrackets = this.name.replace(",", "");
		//String removeBrakets = stringWithBrackets.replace("[\\[\\]]", "");
		//System.out.println("Class section = " + stringWithBrackets);
		String classrooms = this.name;
		System.out.println("Class section = " + classrooms);
		return  classrooms;
	}
	
	
	
	
	
}
