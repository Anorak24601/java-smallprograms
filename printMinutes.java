package other;

public class printMinutes {
	public static void print_min(double mins) {
		int min = (int)mins;
		int secs = (int)((mins - min)*60);
		System.out.print(mins + " minutes is equal to " + min + " minutes and " + secs + " seconds");
	}
	
	public static void main(String[] args) {
		print_min(3.25);
	}
}
