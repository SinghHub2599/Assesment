package com.ATDevServices.Student2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
private static Scanner sc;
private static Session ss;
	static
	{
		sc=new Scanner(System.in);
		Configuration cf= new Configuration();
			cf.configure();
		SessionFactory sf =cf.buildSessionFactory();
			ss=sf.openSession();
	}
	//Inserted Student
	void insertStudent()
	{
		System.out.println("Enter the Student Id,Name,Branch,Mob No,Address");
		Student stud= new Student();
		stud.setSid(sc.nextInt());
		stud.setSname(sc.next());
		stud.setSbrance(sc.next());
		stud.setSmob(sc.nextLong());
		stud.setAddress(sc.next());
		try
		{
			Transaction tr =ss.beginTransaction();
			ss.save(stud);
			tr.commit();
		}catch (Exception e) {
			System.out.println("Student detail is already Exits in DataBase");
			return;
		}
		System.out.println("Sucessfully Inserted...");
	}
	//Delete Student
	
	void deleteStudent()
	{
		System.out.println("Enter the Id to Delete:");
		int id=sc.nextInt();
		try
		{
			Student stud=(Student)ss.load(Student.class, id);
			Transaction tr=ss.beginTransaction();
			ss.delete(stud);
			tr.commit();
		}
		catch (Exception e) {
			System.out.println("Student detail is already Exits in DataBase");
			return;
		}
		System.out.println("SucessFully Deleted...");
	}
	//Update Student
	void updateStudent()
	{
		System.out.println("Enter the Id to Update");
		int id =sc.nextInt();
		try
		{
			Student stud=(Student)ss.load(Student.class, id);
			Transaction tr=ss.beginTransaction();
			System.out.println("1.update Id 2.update Name 3.update Branch 4.update MobNo 5.update Address");
			int key=sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter to the new id to the Student");
				stud.setSid(sc.nextInt());
				break;
				
			case 2:
				System.out.println("Enter to the new Name to the Student");
				stud.setSname(sc.next());
				break;

			case 3:
				System.out.println("Enter to the new Branch to the Student");
				stud.setSname(sc.next());
				break;
				
			case 4:
				System.out.println("Enter to the new Mob no. to the Student");
				stud.setSmob(sc.nextLong());
				break;
				
			case 5:
				System.out.println("Enter to the new Address to the Student");
				stud.setSname(sc.next());
				break;
			default:
				System.out.println("your wrong.......");
				break;
			}
			tr.commit();
		}catch (Exception e) {
			System.out.println("this id Student is not exist to Database");
			return;
		}
		System.out.println("SuccessFully Modified");
	}
	//Display Student
	void readStudent()
	{
		System.out.println("Enter the id to read:");
		int id=sc.nextInt();
		try {
			Student stud=(Student)ss.load(Student.class, id);
			System.out.println("Student info:");
			System.out.println("student ID:"+stud.getSid());
			System.out.println("student Name:"+stud.getSname());
			System.out.println("student Branch:"+stud.getSbrance());
			System.out.println("student MobNo:"+stud.getSmob());
			System.out.println("student Address:"+stud.getAddress());
		}
		catch (Exception e) {
			System.out.println("this Student id is already exits in DataBase");
			return;
		}
		System.out.println("SuccessFully Read The Student");
	}
}
