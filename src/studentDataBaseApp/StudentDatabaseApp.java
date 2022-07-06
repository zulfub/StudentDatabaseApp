package studentDataBaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		//Ask How many student will added to course
		System.out.print("Enter the number of new students : ");
		Scanner scan = new Scanner(System.in);
		int numsofStudent = scan.nextInt();
		Student[] students = new Student[numsofStudent];
		
		//Create N number of student
		for(int n=0;n<numsofStudent;n++) {
			students[n] = new Student();
			students[n].enrollCourse();
			students[n].payTuition();
			System.out.println(students[n].toString());
		}
		//Total Info of Students
		for(int i =0;i<numsofStudent;i++) {
			System.out.println(students[i].toString());
		}

	}

}
