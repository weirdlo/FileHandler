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
				String relay = input.nextLine();
				
				if(relay.equals("help")||relay.equals("?")) {
					new Commander();
					count = 0;
				}
				else if(relay.equals("pwd")||relay.equals("ls")||relay.equals("cd ..")||relay.equals("ls -l")) {
					new Commander(relay);
					count = 0;
				}
				else if((relay.contains("cd "))||(relay.contains("mkdir "))||(relay.contains("rmdir "))||(relay.contains("rm "))||(relay.contains("vim "))||(relay.contains("vi "))||(relay.contains("cat "))) {
					String[] keywords = {"cd ","mkdir ","rmdir ","cat ","rm ","vim ","vi ",};
					String str1 = "", str2 = "";
					
					for(String word : keywords) {
						if(relay.contains(word)) {
							str1 = word;
							str2 = relay.replaceAll(str1, "");
							break;
						}
					}
					new Commander(str1,str2);
					count = 0;
				}
				else if(relay.equals("exit")) {
					listener = false;
				}
				else if(relay.equals("")) {}
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