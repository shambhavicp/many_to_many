package com.ty.many_to_many_person_language_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.many_to_many_person_language_uni.dao.LanguageDao;
import com.ty.many_to_many_person_language_uni.dao.PersonDao;
import com.ty.many_to_many_person_language_uni.dto.Language;
import com.ty.many_to_many_person_language_uni.dto.Person;

public class LanguageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		LanguageDao languageDao = new LanguageDao();

		PersonDao personDao = new PersonDao();

		Person person = new Person();

		boolean flag = true;

		do {
			System.out.println("do you want to \n 1.save person \n 2.add language \n 3.update person \n 4.remove person \n 5.getone \n 6.get all \n 7.exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {

				System.out.println("enter the id");
				int id = scanner.nextInt();

				System.out.println("enter the name");
				String name = scanner.next();

				System.out.println("enter the phone");
				long phone = scanner.nextLong();

				System.out.println("enter the address");
				String address = scanner.next();

				person.setId(id);
				person.setName(name);
				person.setAddress(address);
				person.setPhone(phone);
				personDao.savePerson(person);

				boolean repeat = true;

				do {

					System.out.println("do you want to add language details click on 1.to add 2.exit");

					int select = scanner.nextInt();
					switch (select) {

					case 1: {
						System.out.println("enter the id to be inserted");
						int language_id = scanner.nextInt();

						System.out.println("enter the language name :");
						String language_name = scanner.next();

						System.out.println("enter the origin");
						String origin = scanner.next();

						System.out.println("enter the country");
						String country = scanner.next();

						Language language = new Language();
						language.setId(language_id);
						language.setName(language_name);
						language.setOrigin(origin);
						language.setCountry(country);


						List<Language> list = new ArrayList<Language>();
						list.add(language);
						person.setList(list);

					
					}
					break;

					case 2: {
						repeat = false;

						System.out.println("Thank you");

					}
					break;

					default:System.out.println("Invalid choice");

					}

				} while (repeat);

			}
			break;

			case 2: {
				boolean repeat = true;

				do {
					System.out.println("do you want to add language details click on 1.to add 2.exit");
					int select = scanner.nextInt();

					switch (select) {
					case 1: {

						System.out.println("enter the person id");
						int id = scanner.nextInt();

						System.out.println("enter the id to be inserted");
						int language_id = scanner.nextInt();
						
						System.out.println("enter the language name :");
						String language_name = scanner.next();

						System.out.println("enter the origin");
						String origin = scanner.next();

						System.out.println("enter the country");
						String country = scanner.next();

						Language language = new Language();
						person.setId(id);
						language.setId(language_id);
						language.setName(language_name);
						language.setOrigin(origin);
						language.setCountry(country);
						languageDao.saveLanguage(language, person.getId());



					}
					break;

					case 2: {
						repeat = false;

						System.out.println("Thank you");

					}
					break;

					default:System.out.println("Invalid choice");

					}

				} while (repeat);

			}
			break;

			case 3: {

				boolean choose1 = true;

				do {

					System.out.println("do you want to update 1.person 2.language 3.exit");

					int key = scanner.nextInt();

					switch (key) {

					case 1: {

						System.out.println("enter the person id to be updated");
						int person_id = scanner.nextInt();

						System.out.println("enter the name");
						String name = scanner.next();

						System.out.println("enter the phone");
						long phone = scanner.nextLong();

						System.out.println("enter the address");
						String address = scanner.next();

						person.setId(person_id);
						person.setName(name);
						person.setAddress(address);
						person.setPhone(phone);
						personDao.updatePerson(person_id, person);

						

					}
					break;

					case 2: {

						System.out.println("enter the language id to be updated");
						int language_id = scanner.nextInt();

						System.out.println("enter the language name :");
						String language_name = scanner.next();

						System.out.println("enter the origin");
						String origin = scanner.next();

						System.out.println("enter the country");
						String country = scanner.next();

						Language language = new Language();
						person.setId(language_id);
						language.setId(language_id);
						language.setName(language_name);
						language.setOrigin(origin);
						language.setCountry(country);
						languageDao.updateLanguage(language_id);

						

					}
					break;

					case 3: {
						choose1 = false;

						System.out.println("Thank you");

					}
					break;

					default:System.out.println("Invalid choice");

					}

				} while (choose1);

			}
			break;

			case 4: {

				boolean exit = true;

				do {

					System.out.println("do you want to remove 1.person 2.employee 3.exit");
					System.out.println("choose any one");

					int key = scanner.nextInt();
					switch (key) {

					case 1: {
						System.out.println("enter the id to be removed");
						int person_id = scanner.nextInt();
						person.setId(person_id);
						personDao.removePerson(person_id);

						

					}
					break;

					case 2: {
						System.out.println("enter the language id to be removed");
						int language_id = scanner.nextInt();
						Language language = new Language();
						languageDao.removeLanguage(language_id);
					
					}
					break;


					case 3: {
						exit = false;

						System.out.println("THANK YOU");

					}
					break;

					default: {
						System.out.println("Invalid");

					}
					break;

					}

				} while (exit);

			}
			break;

			case 5: {

				System.out.println("enter the id to be updated");

				int person_id = scanner.nextInt();
				person.setId(person_id);
				personDao.getPerson(person_id);

			}
				break;

			case 6: {
				personDao.getAllPerson();

			}
			break;

			case 7: {
				flag = false;

				System.out.println("THANK YOU");

			}
			break;

			default:System.out.println("Invalid choice");

			}

		} while (flag);
	}

}
