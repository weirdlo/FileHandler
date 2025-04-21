package fileHandler;

import java.io.File;
import java.io.IOException;

public class Directories {
	static DirMemory dm = new DirMemory();
	protected String defaultDir = System.getProperty("user.dir");
	protected String pwd;
	
	public Directories() {
		pwd = dm.getDirectory();
		if(pwd == null) {
			dm.setDirectory(defaultDir);
			pwd = dm.getDirectory();
		}
	}
	
	public void currentDirectory() throws IOException {
		System.out.println(pwd);
	}//currentDirectory
	
	public void createDirectory(String newFolder) throws IOException {
		String folder = newFolder;
		File directory = new File(pwd+"\\"+folder);
		
		if(directory.isDirectory()) 
			System.out.println(directory.getName()+" already exists under this destination.");
		else if(directory.mkdir()) 
			System.out.println("New directory "+directory.getName()+" has been created.");
		else 
			System.out.println("Error: Couldn't create directory.");
	}//createDirectory
	
	public void deleteDirectory(String folderName){
		String folder = folderName;
		File directory = new File(pwd+"\\"+folder);
		
		if(directory.isDirectory()) {
			if(directory.delete()) 
				System.out.println(directory+" has been removed.");
			else 
				System.out.println("Failed to delete the folder.  Make sure it's empty.");
		}
		else 
			System.out.println("Folder does not exist.");
	}//deleteDirectory
	
	public void listContents() {
		System.out.println(pwd);
		File dir = new File(pwd);
		File[] folders = dir.listFiles();
		int folderCount = 0, fileCount = 0;
		
		if(folders != null) {
			for(File content : folders) {
				char charCheck = content.getName().charAt(0);
				if(charCheck == '.')
					continue;
				else if(content.isDirectory()) {
						System.out.print(content.getName()+"/   ");
						folderCount++;
				}
				else if(content.isFile()) {
					System.out.print(content.getName()+"  ");
					fileCount++;
				}
			}
			System.out.println();
		}
		System.out.println("Folders: "+folderCount+"\nFiles: "+fileCount+"\n");
	}//listDirectories
	
	public void changeDirectory(String destination) {
		String navigator = destination;
		String rmDir, newPath;
		
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
	}//changeDirectory
}//Directories
