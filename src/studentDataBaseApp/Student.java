package studentDataBaseApp;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private String courses = null;
	private int tutionBalance=0;
	private static int courseFeeAmt = 600;
	private static int id = 1000;
	
	//Constructor : User to enter Student Name and Year
	public Student() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter First Name of Student :: ");
		this.firstName = scan.nextLine();
		
		System.out.println("Enter Last Name of Student :: ");
		this.lastName= scan.nextLine();
		
		System.out.println("1 - Fresgman \n2 for Sophmore\n3 for Junior \n4 for Junior \n5 for Senior student class : ");
		this.gradeYear = scan.nextInt();
		
		generateStudentId();
		
		System.out.println(firstName + " " + lastName +" " + gradeYear + " " + studentId);
		
		//Recorsive for Id generation testing
		if(gradeYear == 0)
		StudentDatabaseApp.main(null);
	}
	
	//Generate ID
	private void generateStudentId () {
		id++;
		//Grade Level + ID
		this.studentId = gradeYear + "" + id;
	}
	
	//Enroll Courses
	public void enrollCourse() {
		do {
		System.out.print("Enter Quit for Quit ");
		Scanner scan = new Scanner(System.in);
		String course = scan.nextLine();
		if(!course.equalsIgnoreCase("quit" )) {
			if(courses == null) {
				courses = course;
				tutionBalance = tutionBalance + courseFeeAmt;
			}
			else {
			courses = courses + "\n" + course;
			tutionBalance = tutionBalance + courseFeeAmt;
			}
		}
		else break;
		

		}while(true);

		System.out.println("Tuition Fee of total is ::: " + tutionBalance);
	}
	//View balance
	public void viewBalance() {
		System.out.println("Your balance is :: $" + tutionBalance);
		
	}
	//PAy Tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter Your Payment :: ");
		Scanner scan = new Scanner(System.in);
		int payment = scan.nextInt();
		tutionBalance = tutionBalance - payment;
		System.out.println("Your payment Amt : " + payment + "\nCurrent Amt of Balance : " + tutionBalance);
		viewBalance();
	}
	
	//Show status
	@Override
	public String toString() {
		return "Name : " + firstName + " " + lastName + 
				"\nGrade Level : " + gradeYear +
				"\nStudent ID : " + studentId +
				"\nCourses Enrolled : " + courses +
				"\nBalance : $" + tutionBalance;
	}
}
