package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Save a message to a file");
		
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/Message1.txt", true);
			
			fw.write(message);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
