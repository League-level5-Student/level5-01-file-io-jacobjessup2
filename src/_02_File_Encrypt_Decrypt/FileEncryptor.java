package _02_File_Encrypt_Decrypt;import java.io.FileWriter;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a messager.
	 * Use any key you want (1 - 25) to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
String message = JOptionPane.showInputDialog("Save a message to a file");
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/EncryptMessage.txt");
			
			fw.write(cipher(message,4));
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String cipher(String str, int shift) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			char c = (char)(str.charAt(i) + shift);
			if(c > 'z'&& c< 'z'+shift+1||c > 'Z'&& c< 'Z'+shift+1) {
				s += (char)(str.charAt(i) - (26-shift));
			}
			else if(c>='A'+shift&&c<='Z'+shift||c>='a'+shift &&c<='z'+shift){
				s += (char)(str.charAt(i) + shift);
			}
			else {
				s += (char)(str.charAt(i));
			}
		}
		return s;
	}
}

//Copyright © 2020 Jacob Jessup