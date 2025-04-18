package fileHandler;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		try {
			System.out.println("Welcome.  Enter a command to get started.");
			Scanner input = new Scanner(System.in);
			boolean listener = true;
			int count = 0;
						
			do {
				System.out.print(">> ");
				String relay = input.nextLine().toLowerCase();
				
				if(relay.equals("pwd")||relay.equals("ls")||relay.equals("cd ..")) {
					Commander cmd = new Commander(relay);
					count = 0;
				}
				else if((relay.contains("cd "))||(relay.contains("mkdir "))||(relay.contains("rmdir "))||(relay.contains("rm "))||(relay.contains("vim "))||(relay.contains("vi "))||(relay.contains("cat "))) {
					//Separate string into two, one having the command only.
					String[] keywords = {"cd ","mkdir "};
					String str1 = "", str2 = "";
					
					for(String word : keywords) {
						if(relay.contains(word)) {
							str1 = word;
							str2 = relay.replaceAll(str1, "");
							break;
						}
					}
					Commander cmd = new Commander(str1,str2);
					count = 0;
				}
				else if(relay.equals("exit")) {
					listener = false;
				}
				else {
					System.out.println("Invalid command.");
					count++;			
				}
			}
			while(listener && count != 3);
			
			input.close();
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		finally {
			System.out.println("Closing program...");
		}//finally
	}//main	
}//class





/*

CallDirectory cd = new CallDirectory();
CallFile cf = new CallFile();
CommandLine cmd = new CommandLine();

String selection;
boolean listener = true; 
int counter = 0;
			
Scanner sc = new Scanner(System.in);

////Test Values
String testOne = "First choice";
String testTwo = "Second choice";

do {
	System.out.println();
	//selection = sc.nextLine();
	selection = cmd.getCommand();
	
	switch(selection) {
		case "1": System.out.println(testOne); break;
		case "2": System.out.println(testTwo); break;
		case "exit": listener = false; break;
		default: System.out.println("Invalid entry."); counter++;				
	}
}while(listener && counter != 3); 

sc.close();

*/