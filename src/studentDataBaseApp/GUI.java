package studentDataBaseApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel label;
	private static JTextField inputText;
	private static JButton resetButton;
	private static JButton conformButton;
	private static JLabel errorMsg;
	
	public static void GUI() {
	
	//Creating the Frame and Panel
	frame = new JFrame("Student Enrollment");
	panel = new JPanel();
	frame.setSize(240,250);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	
	panel.setLayout(null);
	//Label
	errorMsg = new JLabel("");
	errorMsg.setBounds(20,110,250,25);
	panel.add(errorMsg);
	
	////Label
	label = new JLabel("Enter the number of new students : ");
	label.setBounds(10,20,250,25);
	panel.add(label);
	
	//Text Field for User Input
	inputText = new JTextField(20);
	inputText.setBounds(20, 50, 177, 25);
	panel.add(inputText);
	
	//Button For Conformation 
	conformButton = new JButton("Conform");
	conformButton.setBounds(20, 80, 85, 25);
	conformButton.addActionListener(new GUI());
	panel.add(conformButton);
	
	frame.setVisible(true);
	
	}	
	
	public void actionPerformed(ActionEvent e) {
		int numsofStudent=0;
		try {
			numsofStudent=Integer.parseInt(inputText.getText()); 
		} catch (Exception e2) {
			errorMsg.setText("Invalid input");
		}
		
		
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
