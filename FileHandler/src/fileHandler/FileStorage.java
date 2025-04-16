package fileHandler;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FileStorage {
	Directories directory = new Directories();
	String pwd;
	
	public void createFile(String name) throws IOException {
		String filename = name;
		pwd = directory.pwd;
		if(pwd == null) {
			pwd = directory.defaultDir;
		}
		
		File newfile = new File(pwd+"\\"+filename);
		
		if(newfile.createNewFile())
			System.out.println("File "+newfile.getName()+" has been created.");
		else
			System.out.println("The file "+newfile.getName()+" already exists.");
	}//end of createFile
	
	public void editFile(String name) throws IOException {		
		String filename = name;
		File file = new File(filename);
		String text;
		
		//Adding time tracker
		LocalDateTime clock = LocalDateTime.now();
		DateTimeFormatter clockFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String time = clock.format(clockFormat);
		
		//To make the filename checks case sensitive.
		String canonicalPath = file.getCanonicalPath();
		String checkName =  canonicalPath.substring(canonicalPath.lastIndexOf(File.separator) + 1);
		
		if(file.exists() && checkName.equals(file.getName())) {
			try	(BufferedWriter scribe = new BufferedWriter(new FileWriter(filename, true))) {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("Edit file here: ");
				text = sc.nextLine();
				scribe.write("\n"+time+"\n"+text+"\n");
				System.out.println("\nThe file "+file.getName()+" has been updated.");
			}//end try
			catch(IOException e) {
				System.out.println("File editing error occured.");
			}//end catch				
		}
		else {
			System.out.println("The file does not exist.");
		}		
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
				reader.close();
			}
			else {
				System.out.println("The file you've entered does not exist.");
			}
		}//end of try
		catch(IOException e) {
			System.out.println("An error occured while trying to locate the file. \nCheck folder.");
		}//end of catch
	}//end of readFile
	
	public void deleteFile(String name) {
		try {
			String filename = name;
			File file = new File(filename);
			
			String filepath = file.getCanonicalPath();
			String checking = filepath.substring(filepath.lastIndexOf(File.separator) + 1);
			
			if(file.exists() && checking.equals(file.getName())) {
				if(file.delete()) {
					System.out.println(file.getName()+" was successfully deleted.");
				}
				else {
					System.out.println("Cannot delete file "+file.getName());
				}
			}
			else {
				System.out.println("File: "+file.getName()+" does not exist.");
			}
		}//end of try
		catch(IOException e) {
			System.out.println("An error occured while trying to delete the file.");
			e.printStackTrace();
		}//end of catch
	}//end of deleteFile
	
	public void listFiles() {
		pwd = directory.pwd;
		if(pwd == null) {
			pwd = directory.defaultDir;
		}
		
		File dir = new File(pwd);
		File[] files = dir.listFiles();
		
		System.out.println(pwd);
		if(files != null) {
			for(File file : files) {
				if(file.isFile()) {
					String isRead = (file.canRead()) ? "r" : "-r";
					String isWrite = (file.canWrite()) ? "w" : "-w";
					String isExecutable = (file.canExecute()) ? "x" : "-x";
					System.out.println(">> "+file.getName()+"  "+file.length()+"B  "+isRead+isWrite+isExecutable);
				}
			}
		}
	}//end of listFiles
}//end of class
