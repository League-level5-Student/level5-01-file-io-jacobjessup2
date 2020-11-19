package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame = new JFrame("To Do List");
	JPanel panel = new JPanel();
	JButton addT = new JButton("Add Task");
	JButton viewT = new JButton("View Tasks");
	JButton revT = new JButton("Remove Task");
	JButton saveL = new JButton("Save List");
	JButton loadL = new JButton("Load List");
	ArrayList<String> list = new ArrayList<String>();
	
	
	void setup() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(addT);
		panel.add(viewT);
		panel.add(revT);
		panel.add(saveL);
		panel.add(loadL);
		frame.pack();
		//add
		addT.addActionListener((e->{
		 	String temp = JOptionPane.showInputDialog("Add a Task");
			list.add(temp);
		}));
		//view
		viewT.addActionListener((e->{
			String temp = "";
			for (int i = 0; i < list.size(); i++) {
				temp += "#" + (i+1) + " " + list.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, temp);
		}));
		//remove
		revT.addActionListener((e->{
			String[] stuff = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				stuff[i] = list.get(i);
			}
			int input =JOptionPane.showOptionDialog(null, "Remove a Task", "Tasks", 0, -1, null, stuff, 0);
			list.remove(input);
		}));
		//save
		saveL.addActionListener((e->{
			String temp = "";
			for (int i = 0; i < list.size()-1; i++) {
				temp += list.get(i)+"\n";
			}
			temp+= list.get(list.size()-1);
			String message = temp;
			
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/TaskList.txt");
				
				fw.write(message);
					
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}));
		//load
		loadL.addActionListener((e->{
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/TaskList.txt"));
				list.clear();
				String line = br.readLine();
				list.add(line);
				while(line != null){
					System.out.println(line);
					line = br.readLine();
					list.add(line);
				}
				list.remove(list.size()-1);
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}));
	}
	
	public static void main(String[] args) {
		ToDoList e = new ToDoList();
		e.setup();
	}
	
}

//Copyright © 2020 Jacob Jessup