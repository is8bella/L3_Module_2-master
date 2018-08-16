package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class assignment4 implements ActionListener{
	
	static String user; 
	static String userremove;
	static String tasksoutput = "";
	static String loadoutput = "";
	static String fileName;
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addtask = new JButton("Add Task");
	JButton removetask = new JButton("Remove Task");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	
	ArrayList<String> tasks = new ArrayList<String>();
	ArrayList<String> loadedTasks = new ArrayList<String>();
	
	/*The add task button will display a JOptionPane to get a task from the user and add it to the list.
	Remove task will remove a task from the list. You can choose your own method of how to select a task from the list.
	The save button will save the current task list to a file.
	The load button will load a new task list into the program and display it.
	The program should automatically load the last saved list from the file at startup and display it.*/
	
	public static void main(String[] args) {
		assignment4 a4 = new assignment4();
		a4.GUI();
		
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
	
	public void addTask() {
		tasks.add(user);
		System.out.println(tasks);
		System.out.println("Task added to list");

	}
	
	public void removeTask() {
		for (int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).equals(userremove)) {
				tasks.remove(i);
			}
		}
		System.out.println("Task removed");
		System.out.println(tasks);
	}
	
	public void saveTask() {
		for (int i = 0; i < tasks.size(); i++) {
			tasksoutput += tasks.get(i) + "\n";
		}
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/assignment4.txt", true);
			
			//System.out.println(user);
			fw.write(tasksoutput); //"\n" + user
				
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Tasks saved");
	}
	
	public void loadTask() {
		//select file
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
		
		//read from file
		System.out.println("Reading from file: " + fileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line = br.readLine();
			while(line != null){
				//System.out.println(line);
				loadedTasks.add(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//displaying file
		for (int i = 0; i < loadedTasks.size(); i++) {
			loadoutput += loadedTasks.get(i) + "\n";
		}
		
		JOptionPane.showMessageDialog(null, fileName + ": " + "\n" + loadoutput);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addtask)) {
			System.out.println("addtask pressed");
			user = JOptionPane.showInputDialog("Add A Task:");
			addTask();
		}
		else if(e.getSource().equals(removetask)) {
			System.out.println("removetask pressed");
			userremove = JOptionPane.showInputDialog("Remove A Task: " + tasks);
			removeTask();
		}
		else if(e.getSource().equals(save)) {
			System.out.println("save pressed");
			saveTask();
		}
		else if(e.getSource().equals(load)) {
			System.out.println("load pressed");
			loadTask();
		}
	}
	
}
