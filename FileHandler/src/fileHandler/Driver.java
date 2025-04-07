package fileHandler;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		try {
			CallDirectory cd = new CallDirectory();
			CallFile cf = new CallFile();
			
			String selection;
			boolean listener = true; 
			int counter = 0;
						
			Scanner sc = new Scanner(System.in);
	
			do {
				System.out.println("What do you want to work with? \n[1]Directories  [2]Documents [3]Exit ");
				selection = sc.next();
				
				switch(selection) {
					case "1": cd.callDirecotry(); break;
					case "2": System.out.println(cf.doc); break;
					case "3": System.out.println("Good bye!"); listener = false; break;
					default: System.out.println("Invalid entry."); counter++;				
				}
			}while(listener && counter != 3); 
			
			sc.close();
		}//end of try
		catch(Exception e) {
			e.printStackTrace();
		}//end of catch
		finally {
			System.out.println("Closing program...");
		}//end of finally
	}//end of main
}//end of class