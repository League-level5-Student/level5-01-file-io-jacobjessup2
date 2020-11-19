package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/EncryptMessage.txt"));
			
			String line = br.readLine();
			while(line != null){
				System.out.println(decrypt(line,4));
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
	public static String decrypt(String str, int shifts) {
		int shift = -shifts;
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			char c = (char)(str.charAt(i) + shift);
			if(c < 'a'&& c> 'a'+shift-1||c < 'A'&& c> 'A'+shift-1) {
				s += (char)(str.charAt(i) - (26-shift)+52);			
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