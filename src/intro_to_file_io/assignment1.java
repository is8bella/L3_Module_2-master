package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class assignment1 {
	static String user = "";
	public static void main(String[] args) {
		user = JOptionPane.showInputDialog("Type a message:");
		
		
		
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/assignment1");

			fw.write(user);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <String> String encrypt() {
		for (int i = 0; i < user.length(); i++) {
			
		}
		
	}
	
}
