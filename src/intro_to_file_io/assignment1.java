package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class assignment1 {
	static String userans = "";

	public static void main(String[] args) {
		assignment1 a1 = new assignment1();

		userans = JOptionPane.showInputDialog("Type a message:");

		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/assignment1");

			fw.write(a1.encrypt(userans));

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileReader fr = new FileReader("src/intro_to_file_io/assignment1");
			int c = fr.read();
			while (c != -1) {
				System.out.print((char) c);
				c = fr.read();

			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String encrypt(String user) {

		return user.replace("a", "f").replace("e", "m").replace("i", "o").replace("o", "er").replace("u", "q")
				.replace("t", "W").replace("n", "y").replace("s", "vi").replace("h", "a").replace("r", "oo")
				.replace("d", "wee").replace("l", "ie");

	}

}
