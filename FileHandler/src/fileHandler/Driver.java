package fileHandler;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		try {
			Directories dir = new Directories();
			
			//Displaying current file path
			System.out.println("Welcome");
			dir.currentDirectory();
			
			//Creating new directory
			Scanner newFolder = new Scanner(System.in);
			System.out.print("Enter new folder name: ");
			String dirName = newFolder.nextLine();
			dir.createDirectory(dirName);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Closing program...");
		}
	}

}
