package fileHandler;

import java.io.IOException;

public class Commander{
	FileStorage documents = new FileStorage();
	Directories folders = new Directories();
	
	protected String command;
	protected String title;
	
	public Commander(String command) throws IOException {
		this.command = command;
		
		switch(command) {
			case "pwd": folders.currentDirectory(); break;
			case "ls": folders.listContents(); break;
			case "cd ..": folders.changeDirectory(command); break;
			case "ls -l": documents.listInfo();
		}
	}//Commander(String)
	
	public Commander(String command, String title) throws IOException {
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
