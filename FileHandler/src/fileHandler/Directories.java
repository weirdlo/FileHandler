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
	
	public void deleteDirectory(String folderName) {
		String folder = folderName;
		File directory = new File(folder);
		
		if(directory.isDirectory()) {
			if(directory.delete()) {
				System.out.println(directory.getName()+" has been removed.");
			}
			else {
				System.out.println("Failed to delete the folder.  Make sure it's empty.");
			}
		}
		else {
			System.out.println("Folder does not exist.");
		}
	}//end of deleteDirectory
	
	public void listDirectories() {
		String currentDir = System.getProperty("user.dir");
		File dir = new File(currentDir);
		File[] folders = dir.listFiles();
		
		if(folders != null) {
			for(File folder : folders) {
				if(folder.isDirectory()) {
					System.out.print(folder.getName()+"/   ");
				}
			}
			System.out.println();
		}
	}//end of listDirectories
	
	/*
	public void changeDirectory() {
			
	}//end of changeDirectory
	*/
	
}//end of class
