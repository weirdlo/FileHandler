package fileHandler;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		try {
			CallDirectory cd = new CallDirectory();
			CallFile cf = new CallFile();
			
			String selection;
			boolean listener = true; 
						
			Scanner sc = new Scanner(System.in);
	
			do {
				System.out.println("What do you want to work with? \n[1]Directories  [2]Documents [3]Exit ");
				selection = sc.nextLine();
				
				switch(selection) {
					case "1": System.out.println(cd.option); break;
					case "2": System.out.println(cf.doc); break;
					case "3": System.out.println("Good bye!"); listener = false; break;
					default: System.out.println("Invalid entry."); listener = false;				
				}
				
				if(listener) {
					System.out.print("Would you like to perform another operation? \n[1]Yes  [2]No ");
					selection = sc.nextLine();
					switch(selection) {
						case "1": listener = true; break;
						case "2": System.out.println("Good bye!"); listener = false; break;
						default: System.out.println("Invalid entry."); listener = false;
					}
				}
			}while(listener); 
			
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