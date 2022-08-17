package com.ty.manyToMany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manyToMany.dto.Subject;
import com.ty.manyToMany.dto.Teacher;

public class SaveTeacherSubject {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		Subject subject3 = new Subject();
		subject3.setName("Kannada");
		subject3.setDays(124);
		Subject subject1 = new Subject();
		subject1.setName("Design of machinary element");
		subject1.setDays(150);
		Subject subject2 = new Subject();
		subject2.setName("Computer Aided Design");
		subject2.setDays(45);
		Subject subject4 = new Subject();
		subject4.setName("English");
		subject4.setDays(124);

		Teacher teacher1 = new Teacher();
		teacher1.setName("Rajesh");
		teacher1.setAge(36);
		Teacher teacher2= new Teacher();
		teacher2.setName("Shamila");
		teacher2.setAge(24);
		

		List<Subject> subjects1 = new ArrayList<Subject>();
		subjects1.add(subject1);
		subjects1.add(subject2);
		subjects1.add(subject3);
		teacher1.setSubject(subjects1);
		
		List<Subject> subjects2 = new ArrayList<Subject>();
		subjects2.add(subject3);
		subjects2.add(subject2);
		subjects2.add(subject4);
		teacher2.setSubject(subjects2);

		transaction.begin();

		entityManager.persist(subject1);
		entityManager.persist(subject2);
		entityManager.persist(subject3);
		entityManager.persist(teacher1);
		entityManager.persist(subject4);
		entityManager.persist(teacher2);

		transaction.commit();

	}

}
