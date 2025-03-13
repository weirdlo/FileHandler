package fileHandler;

public class Driver {

	public static void main(String[] args) {
		try {
			Directories dir = new Directories();
			
			dir.currentDirectory();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Closing program...");
		}
	}

}
