package intro_to_file_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class assignment2 {
	static String fileName;
public static void main(String[] args) {
	
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		fileName = jfc.getSelectedFile().getAbsolutePath();
		System.out.println(fileName);
	}
	
	try {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String line = br.readLine();
		while(line != null){
			System.out.println(line);
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
	
} 



}
