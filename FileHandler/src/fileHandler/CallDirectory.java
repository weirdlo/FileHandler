package fileHandler;

import java.io.IOException;
import java.util.Scanner;

public class CallDirectory {
	public void callDirecotry() throws IOException {
		Directories dir = new Directories();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Make a selection. \n[1]List Current\n[2]Create Directory \n[3]Delete Directory \n[4]List Directories\n[5]Change Directory");
		String selection = sc.nextLine();
		String input;
		
		if(selection.equals("1")) {
			dir.currentDirectory();
		}
		else if(selection.equals("2")) {
			System.out.print("Enter new directory name: ");
			input = sc.nextLine();
			dir.createDirectory(input);
		}
		else if(selection.equals("3")) {
			System.out.print("Enter name of directory to remove: ");
			input = sc.nextLine();
			dir.deleteDirectory(input);
		}
		else if(selection.equals("4")) {
			dir.listDirectories();
		}
		else if(selection.equals("5")) {
			int attempts = 2;
			
			while(attempts > 0) {
				System.out.println("Enter 'cd <directory name>' to go to a directory in this destination or 'cd ..' to go back one destination.");
				input = sc.nextLine();
				String newDir = input;
				if(newDir.contains("cd ..")) {
					dir.changeDirectory(newDir);
					break;
				}
				else if(newDir.contains("cd ")) {
					String trimLetters = "cd ";
					newDir = input.replaceAll(trimLetters, "");
					dir.changeDirectory(newDir);
					break;
				}
				else {
					attempts--;
					System.out.println("Invalid command.");
				}
			}
		}
		else {
			System.out.println("Invalid entry.");
		}
	}//end of callDirectory
}//end of class
