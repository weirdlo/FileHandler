package fileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileStorage {
	public void createFile(String name) {
		try {
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
			String checkName =  canonicalPath.substring(canonicalPath.lastIndexOf(File.separator) + 1);
			
			if(file.exists() && checkName.equals(file.getName())) {
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
	
	public void readFile(String name){
		try {
			String filename = name;
			File file = new File(filename);
			
			String readPath = file.getCanonicalPath();
			String checkFile =  readPath.substring(readPath.lastIndexOf(File.separator) + 1);
			
			Scanner reader = new Scanner(file);
			
			if(file.exists() && checkFile.equals(file.getName())) {
				while(reader.hasNextLine()){
					String lines = reader.nextLine();
					System.out.println(lines);
				}
			}
			else {
				System.out.println("The file you've entered does not exist.");
			}
		}
		catch(IOException e) {
			System.out.println("An error occured while trying to read the file.");
		}
	}//end of readFile
}//end of class
