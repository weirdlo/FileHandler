package fileHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileStorage {
	public void createFile(String name) {
		try {
			/**
			 * Need to implement a method that will check to see what kind of file we are creating (.txt, .pdf, .word, etc.).
			 */
			String filename = name+".txt";
			File file = new File(filename);
			
			if(file.createNewFile()) {
				System.out.println("File "+file.getName()+" has been created.");
			}
			else {
				System.out.println("The file already exists.");
			}
		}
		catch(IOException e) {
			System.out.println("An error occured when trying to create the file.");
			e.printStackTrace();
		}
	}//end of createFile
	
	public void editFile(String name) {
		try {
			String filename = name;
			File file = new File(filename);
			
			//To make the filename checks case sensitive.
			String canonicalPath = file.getCanonicalPath();
			String editFile =  canonicalPath.substring(canonicalPath.lastIndexOf(File.separator) + 1);
			
			if(file.exists() && editFile.equals(file.getName())) {
				String text;
				FileWriter scribe = new FileWriter(file);
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Edit file here: ");
				text = sc.nextLine();
				
				scribe.write(text);
				scribe.close();
				System.out.println("The file "+file.getName()+" has been updated.");
			}
			else {
				System.out.println("The file does not exist.");
			}
		}//end of try
		catch(IOException e) {
			System.out.println("An error occured when trying to write to the file.");
			e.printStackTrace();
		}//end of catch
	}//end of editFile
}//end of class
