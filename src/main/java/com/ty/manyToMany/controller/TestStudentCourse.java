package com.ty.manyToMany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manyToMany.dto.Course;
import com.ty.manyToMany.dto.Student;

public class TestStudentCourse {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Student student1 = new Student();
		student1.setName("Karthick");
		student1.setAge(23);
		Student student2 = new Student();
		student2.setName("Manoj");
		student2.setAge(24);
		Student student3 = new Student();
		student3.setName("Pavan");
		student3.setAge(25);
		Student student4 = new Student();
		student4.setName("Shiva");
		student4.setAge(23);
		Student student5 = new Student();
		student5.setName("Bhaskar");
		student5.setAge(24);
		
		List<Student> students = new ArrayList<Student>();
		students.add(student2);
		students.add(student3);
		students.add(student4);
		List<Student> students1 = new ArrayList<Student>();
		students1.add(student1);
		students1.add(student5);
		
		Course course = new Course();
		course.setName("java");
		course.setCost(30000);
		course.setStudent(students);
		Course course1 = new Course();
		course1.setName("WebTechnology");
		course1.setCost(31000);
		course1.setStudent(students1);
		
		transaction.begin();
		manager.persist(course);
		manager.persist(course1);
		manager.persist(student1);
		manager.persist(student2);
		manager.persist(student3);
		manager.persist(student4);
		manager.persist(student5);
		transaction.commit();
	}

}
