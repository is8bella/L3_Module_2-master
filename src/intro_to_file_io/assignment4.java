package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class assignment4 implements ActionListener{
	
	static String user; 
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addtask = new JButton("Add Task");
	JButton removetask = new JButton("Remove Task");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	
	/*The add task button will display a JOptionPane to get a task from the user and add it to the list.
	Remove task will remove a task from the list. You can choose your own method of how to select a task from the list.
	The save button will save the current task list to a file.
	The load button will load a new task list into the program and display it.
	The program should automatically load the last saved list from the file at startup and display it.*/
	
	public static void main(String[] args) {
		assignment4 a4 = new assignment4();
		a4.GUI();
		
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/assignment4.txt", true);
			
			System.out.println(user);
			fw.write("\n" + user);
				
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void GUI() {
		
		frame.add(panel);
		panel.add(addtask);
		panel.add(removetask);
		panel.add(save);
		panel.add(load);
		
		addtask.addActionListener(this);
		removetask.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		
		frame.pack();
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addtask)) {
			System.out.println("addtask pressed");
			user = JOptionPane.showInputDialog("Add A Task:");
		}
		else if(e.getSource().equals(removetask)) {
			System.out.println("removetask pressed");
		}
		else if(e.getSource().equals(save)) {
			System.out.println("save pressed");
		}
		else if(e.getSource().equals(load)) {
			System.out.println("load pressed");
		}
	}
	
}
