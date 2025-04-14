package fileHandler;

import java.io.File;
import java.io.IOException;

public class Directories {
	static DirMemory dm = new DirMemory();
	private String defaultDir = System.getProperty("user.dir");
	
	public void currentDirectory() throws IOException {
		String pwd = dm.getDirectory();
		if(pwd == null) {
			dm.setDirectory(defaultDir);
			pwd = dm.getDirectory();
		}
		else {
			File path = new File(pwd);
			//String checkPath = path.getCanonicalPath();
			if(!path.exists()) 
				System.out.println("That folder isn't in this destination");
		}
		
		System.out.println(pwd);
		
	}//end of currentDirectory
	
	public void createDirectory(String newFolder) throws IOException {
		String pwd = dm.getDirectory();
		if(pwd == null) {
			dm.setDirectory(defaultDir);
			pwd = dm.getDirectory();
		}
		
		String folder = newFolder;
		File directory = new File(pwd+"\\"+folder);
		
		if(directory.isDirectory()) {
			System.out.println(directory.getName()+" already exists under this destination.");
		}
		else if(directory.mkdir()) {
			System.out.println("New directory "+directory.getName()+" has been created.");
		}
		else {
			System.out.println("Error: Couldn't create directory.");
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
		String pwd = dm.getDirectory();
		if(pwd == null) {
			dm.setDirectory(defaultDir);
			pwd = dm.getDirectory();
		}
		
		File dir = new File(pwd);
		File[] folders = dir.listFiles();
		int folderCount = 0, totalFolders = 0;
		if(folders != null) {
			for(File folder : folders) {
				if(folder.isDirectory()) {
					totalFolders++;
					char charCheck = folder.getName().charAt(0);
					if(charCheck == '.')
						continue;
					else {
						System.out.print(folder.getName()+"/   ");
						folderCount++;
					}
				}
			}
			System.out.println();
		}
		System.out.println("Folders: "+folderCount+"/"+totalFolders);
	}//end of listDirectories
	
	public void changeDirectory(String destination) {
		String navigator = destination;
		String rmDir, newPath;
		
		String pwd = dm.getDirectory();
		if(pwd == null) {
			dm.setDirectory(defaultDir);
			pwd = dm.getDirectory();
		}
		
		if(navigator.equals("cd ..")) {
			rmDir = pwd.substring(pwd.lastIndexOf(File.separator));
			newPath = pwd.replace(rmDir,"");
			dm.setDirectory(newPath);
			pwd = dm.getDirectory();
		}
		else {
			newPath = pwd+"\\"+navigator;
			File folder = new File(newPath);
			if(folder.exists()) {
				dm.setDirectory(newPath);
				pwd = dm.getDirectory();
			}
			else
				System.out.println("This folder doesn't live in this destination.");			
		}
		
		System.out.println(pwd);
	}//end changeDirectory
}//end of class
