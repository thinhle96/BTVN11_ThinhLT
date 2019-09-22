package com.topica.edu.itlab.jdbc.tutorial.entity;

import java.util.ArrayList;
import java.util.List;

import com.topica.edu.itlab.jdbc.tutorial.annotation.Column;
import com.topica.edu.itlab.jdbc.tutorial.annotation.OneToMany;
import com.topica.edu.itlab.jdbc.tutorial.annotation.Table;

@Table(name = "class")
public class ClassEntity {

	public ClassEntity(Long id, String name, List<StudentEntity> listStudent) {
		this.id = id;
		this.name = name;
		this.listStudent = listStudent;
	}


	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "student")
	private List<StudentEntity> listStudent;
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentEntity> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<StudentEntity> listStudent) {
		this.listStudent = listStudent;
		listStudent = null;
	}

	@Override
	public String toString() {
		return "ClassEntity [id=" + id + ", name=" + name + "]";
	}
	
}
