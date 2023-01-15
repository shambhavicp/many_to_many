package com.ty.many_to_many_person_language_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.many_to_many_person_language_uni.dto.Language;
import com.ty.many_to_many_person_language_uni.dto.Person;

public class LanguageDao {
	
	public EntityManager getEntityManager() {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");

		return entityManagerFactory.createEntityManager();

		}

		public void saveLanguage(Language language,int person_id) {

		EntityManager entityManager=getEntityManager();

		EntityTransaction entityTransaction=entityManager.getTransaction();

		Person person=entityManager.find(Person.class, person_id);

		person.setId(person_id);

		entityTransaction.begin();

		entityManager.persist(language);

		entityTransaction.commit();

		}

		public void updateLanguage(int language_id) {

		EntityManager entityManager=getEntityManager();

		EntityTransaction entityTransaction=entityManager.getTransaction();

		entityTransaction.begin();

		Language language=entityManager.find(Language.class, language_id);

		if(language!=null) {

		language.setId(language_id);

		entityManager.merge(language);

		}

		entityTransaction.commit();

		}

		public void removeLanguage(int language_id) {

		EntityManager entityManager=getEntityManager();

		EntityTransaction entityTransaction=entityManager.getTransaction();

		entityTransaction.begin();

		Language language=entityManager.find(Language.class, language_id);

		if(language!=null) {

		entityManager.remove(language);

		}

		entityTransaction.commit();

		}

		public Language getOneLanguage(int language_id) {

		EntityManager entityManager=getEntityManager();

		EntityTransaction entityTransaction=entityManager.getTransaction();

		entityTransaction.begin();

		Language language=entityManager.find(Language.class, language_id);

		return language;

		}

		public List<Language> getAllLanguage(){

		EntityManager entityManager=getEntityManager();

		EntityTransaction entityTransaction=entityManager.getTransaction();

		entityTransaction.begin();

		Query query=entityManager.createQuery("select l from Language l");

		return query.getResultList();

		}

}
