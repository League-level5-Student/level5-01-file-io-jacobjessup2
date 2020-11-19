package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
			File directory = new File("src/");
			File[] files = directory.listFiles();
			if(files != null) {
				for(File f : files) {
				  System.out.println(f.getAbsolutePath());
				  if(f.isDirectory()) {
					  File directory1 = new File(f.getAbsolutePath());
					  File[] files1 = directory1.listFiles();
					  if(files1 != null) {
							for(File f1 : files1) {
								System.out.println("  " +f1.getAbsolutePath());
								if(f1.getAbsolutePath().contains(".java")) {
									try {
										FileWriter fw = new FileWriter(f1.getAbsolutePath(),true);
										fw.write("\n//Copyright © 2020 Jacob Jessup");
										fw.close();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				  }
				}
			}
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	}


//Copyright © 2020 Jacob Jessup