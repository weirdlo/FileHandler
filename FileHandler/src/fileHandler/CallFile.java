package fileHandler;

import java.io.IOException;
import java.util.Scanner;

public class CallFile {
	public void callFiles() throws IOException {
		FileStorage docs = new FileStorage();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Make a selection. \n[1]Create New File \n[2]Edit File \n[3]Read File \n[4]Delete Files \n[5]List Files ");
		String selection = sc.nextLine();
		
		String input = "";
		
		if(selection.equals("1")) {
			System.out.print("Enter new file name: ");
			input = sc.nextLine();
			docs.createFile(input);
		}
		else if(selection.equals("2")) {
			System.out.print("Enter new file name: ");
			input = sc.nextLine();
			docs.editFile(input);
		}
		else if(selection.equals("3")) {
			System.out.print("Enter new file name: ");
			input = sc.nextLine();
			docs.readFile(input);
		}
		else if(selection.equals("4")) {
			System.out.print("Enter new file name: ");
			input = sc.nextLine();
			docs.deleteFile(input);
		}
		else if(selection.equals("5")) {
			docs.listFiles();
		}
		else {
			System.out.println("Invalid entry.");
		}
	}
}//end of class
