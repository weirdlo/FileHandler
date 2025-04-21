package fileHandler;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FileStorage {
	Directories directory = new Directories();
	String pwd = directory.pwd;
	
	public void createFile(String name) throws IOException {
		String filename = name;
		File newfile = new File(pwd+"\\"+filename);
		
		if(newfile.createNewFile())
			System.out.println("File "+newfile.getName()+" has been created.");
		else
			editFile(filename);
	}//createFile
	
	public void editFile(String name) throws IOException {		
		String filename = name;
		File viewfile = new File(pwd+"\\"+filename);
		String text;
		
		LocalDateTime clock = LocalDateTime.now();
		DateTimeFormatter clockFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String time = clock.format(clockFormat);
		
		if(viewfile.exists()) {
			try	(BufferedWriter scribe = new BufferedWriter(new FileWriter(viewfile, true))) {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("Edit file here: ");
				text = sc.nextLine();
				scribe.write("\n"+time+"\n"+text+"\n");
				System.out.println("\nThe file "+viewfile.getName()+" has been updated.");
			}//try
			catch(IOException e) {
				System.out.println("File editing error occured.");
			}//catch				
		}
		else {
			System.out.println("The file does not exist.");
		}
	}//editFile()
	
	public void readFile(String name){
		try {
			String filename = name;
			File file = new File(pwd+"\\"+filename);
			Scanner reader = new Scanner(file);
			
			if(file.exists()) {
				while(reader.hasNextLine()){
					String lines = reader.nextLine();
					System.out.println(lines);
				}
				reader.close();
			}
			else 
				System.out.println("The file you've entered does not exist.");
		}//try
		catch(IOException e) {
			System.out.println("An error occured while trying to locate the file. \nCheck folder.");
		}//catch
	}//readFile()
	
	public void deleteFile(String name) throws IOException {
		String filename = name;
		File file = new File(pwd+"\\"+filename);
		
		if(file.exists()) {
			if(file.delete()) 
				System.out.println(file.getName()+" was successfully deleted.");
			else 
				System.out.println("Cannot delete file "+file.getName());
		}
		else 
			System.out.println("File: "+file.getName()+" does not exist.");
	}//deleteFile()
	
	public void listInfo() {
		File dir = new File(pwd);
		File[] files = dir.listFiles();
		int count = 0;
		
		System.out.println(pwd);
		if(files != null) {
			for(File file : files) {
				String isRead = (file.canRead()) ? "r" : "-r";
				String isWrite = (file.canWrite()) ? "w" : "-w";
				String isExecutable = (file.canExecute()) ? "x" : "-x";
				char charCheck = file.getName().charAt(0);
				if(charCheck == '.')
					continue;
				else if(file.isFile() ) 
					System.out.println(isRead+isWrite+isExecutable+"   "+file.length()+"B   "+file.getName());
				else if(file.isDirectory()) 
					System.out.println(isRead+isWrite+isExecutable+"   "+file.length()+"B   "+file.getName()+"\\  ");
				count++;
			}
		}
		System.out.println("Total: "+count+"\n");
	}//listFiles()
}//FileStorage
