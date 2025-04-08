package fileHandler;

import java.io.IOException;
import java.util.Scanner;

public class CallDirectory {
	public void callDirecotry() throws IOException {
		Directories dir = new Directories();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Make a selection. \n[1]List Current Directory \n[2]Create Directory \n[3]Delete Directory \n[4]List Directories ");
		String selection = sc.nextLine();
		
		String input = "";
		
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
		else {
			System.out.println("Invalid entry.");
		}
	}//end of callDirectory
}//end of class
