package functional;
import java.util.*;
import java.io.File;

public class DesktopOrganizer {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter folder path: ");
		showFolder(s.nextLine(), "");
		s.nextLine();
		s.close();
	}
	
	public static void showFolder(String path, String prefix) {
		File folder = new File(path);
		
		if (folder.exists()) {
			File[] list = folder.listFiles();
			for (int i = 0; i < list.length; i++) {
				if (list[i].isFile()) System.out.println(prefix + list[i].getName());
				else if (list[i].isDirectory()) {
					System.out.println(prefix + list[i].getName());
					showFolder(path + "\\" + list[i].getName(), prefix + "| ");
				}
			}
		} else System.out.println("Folder does not exist");
	}
}