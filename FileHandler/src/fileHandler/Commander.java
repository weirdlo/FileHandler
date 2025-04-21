package fileHandler;

import java.io.IOException;

public class Commander{
	FileStorage documents = new FileStorage();
	Directories folders = new Directories();
	
	protected String command;
	protected String title;
	
	Commander(){
		System.out.println("ls - List all files and directories under current location.");
		System.out.println("ls l - List all files and directoried under current location with file and folder descriptions and permissions.");
		System.out.println("cd - list current directory.");
		System.out.println("mkdir <directory_name> - Creates new directory.");
		System.out.println("rmdir <directory_name> - Deletes directory if empty.");
		System.out.println("vim <filename> - To create new file or edit existing one.");
		System.out.println("vi <filename> - To create new file or edit existing one.");
		System.out.println("cat <filename> - To read file.");
		System.out.println("rm <filename> - To delete file.");
		System.out.println("exit - To close command line.");
	}//Commander()
	
	Commander(String command) throws IOException {
		this.command = command;
		
		switch(command) {
			case "pwd": folders.currentDirectory(); break;
			case "ls": folders.listContents(); break;
			case "cd ..": folders.changeDirectory(command); break;
			case "ls -l": documents.listInfo();
		}
	}//Commander(String)
	
	Commander(String command, String title) throws IOException {
		this.command = command;
		this.title = title;
		
		switch(command) {
			case "cd ": folders.changeDirectory(title); break;
			case "mkdir ": folders.createDirectory(title); break;
			case "rmdir ": folders.deleteDirectory(title); break;
			case "vim ": documents.createFile(title); break;
			case "vi ": documents.createFile(title); break;
			case "cat ": documents.readFile(title); break;
			case "rm ":documents.deleteFile(title); break;
		}
	}//Commander(String,String)
}//Commander
