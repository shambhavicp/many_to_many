package com.ty.many_to_many_person_language_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.many_to_many_person_language_uni.dto.Person;

public class PersonDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
		}

		//to save
		public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		}

		//to update
		public void updatePerson(int id,Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Person person1=entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.merge(person1);
		entityTransaction.commit();
		}

		//to remove
		public void removePerson(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Person person=entityManager.find(Person.class, id);
		if(person!=null) {
		entityTransaction.begin();

		entityManager.remove(person);
		entityTransaction.commit();
		}
		else
		System.out.println("invalid");

		}

		//to select
		public Person getPerson(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);

		return person;
		}

		//to select all
		public List<Person> getAllPerson(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Person e");
		List<Person> list=query.getResultList();
		return list;
		}

}
