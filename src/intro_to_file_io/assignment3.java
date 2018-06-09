package intro_to_file_io;

import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class assignment3 {
	
	//new list that contains all .java files
	//iterate through 
	
	static String fileName;
	
public static void main(String[] args) {
	//String user = JOptionPane.showInputDialog("How many files would you like to write to?");
	//int usernum = Integer.parseInt(user);

	//for (int i = 0; i < usernum; i++) {
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		fileName = jfc.getSelectedFile().getAbsolutePath();
		System.out.println(fileName);
	}
	try {
		FileWriter fw = new FileWriter(fileName, true);
		
		fw.write("\n \n//Copyright © 2018 by Bill Jobs");
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	//}
	
}

}
