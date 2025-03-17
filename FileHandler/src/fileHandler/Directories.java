package fileHandler;

import java.io.File;

public class Directories {
	public void currentDirectory() {
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
	}//end of currentDirectory
	
	public void createDirectory(String newFolder) {
		String folder = newFolder;
		File directory = new File(folder);
		
		if(directory.isDirectory()) {
			System.out.println("This directory already exists. \n"+directory.getAbsolutePath());
		}
		else if(directory.mkdir()) {
			System.out.println("New directory "+directory.getName()+" has been created.");
		}
		else {
			System.out.println("Couldn't create directory.");
		}
	}//end of createDirectory
	
	/*
	public void deleteDirectory() {
		
	}//end of deleteDirectory
	
	public void listDirectories() {
		
	}//end of listDirectories
	
	public void changeDirectory() {
			
	}//end of changeDirectory
	*/
	
}
