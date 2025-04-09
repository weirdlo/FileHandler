package fileHandler;

import java.io.File;
import java.io.IOException;

public class Directories {
	public void currentDirectory() {
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
	}//end of currentDirectory
	
	public void createDirectory(String newFolder) {
		try {
			String folder = newFolder;
			File directory = new File(folder);
			
			String dirName = directory.getCanonicalPath();
			String checking = dirName.substring(dirName.lastIndexOf(File.separator) + 1);
			
			if(directory.isDirectory()) {
				System.out.println("A directory named '"+checking+"' already exists.");
			}
			else if(directory.mkdir()) {
				System.out.println("New directory "+directory.getName()+" has been created.");
			}
		}//end of try
		catch(IOException e) {
			System.out.println("An error occured while trying to create the folder.");
			e.printStackTrace();
		}
	}//end of createDirectory
	
	public void deleteDirectory(String folderName){
		try {
			String folder = folderName;
			File directory = new File(folder);
			
			String dirName = directory.getCanonicalPath();
			String checking = dirName.substring(dirName.lastIndexOf(File.separator) + 1);
			
			if(directory.isDirectory()) {
				if(directory.delete()) {
					System.out.println(checking+" has been removed.");
				}
				else {
					System.out.println("Failed to delete the folder.  Make sure it's empty.");
				}
			}
			else {
				System.out.println("Folder does not exist.");
			}
		}//end of try
		catch(IOException e) {
			System.out.println("An error occured while trying to remove the folder.");
			e.printStackTrace();
		}//end of catch
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
}//end of class
