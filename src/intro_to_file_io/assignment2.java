package intro_to_file_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class assignment2 {
	static String fileName;
	static String line;
public static void main(String[] args) {
	assignment2 a2 = new assignment2();
	
	//filechooser
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		fileName = jfc.getSelectedFile().getAbsolutePath();
		System.out.println(fileName);
	}
	
	//filereader
	try {
		FileWriter fw = new FileWriter("src/intro_to_file_io/assignment2.txt");
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		line = br.readLine();
		while(line != null){
			System.out.println(line);
			fw.write(a2.decrypt(line));
			line = br.readLine();
		}
		
		fw.close();
		br.close();
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	
}

//decryption method
public String decrypt(String linetxt) {
	
	return linetxt.replace("f", "a").replace("m", "e").replace("o", "i").replace("er", "o").replace("q", "u")
			.replace("W", "t").replace("y", "n").replace("vi", "s").replace("a", "h").replace("oo", "r")
			.replace("wee", "d").replace("ie", "l");
	
}



}
