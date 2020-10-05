package other;

public class Test {
	public static void main(String[] args) {
		System.out.print(function(2));
	}
	
	public static double function(int num) {
		if (num > 0)  return (1.0/num) + function(num-1);
		else return 0;
	}
}
