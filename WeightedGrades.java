package functional;
import java.util.*;

public class WeightedGrades {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Are you looking for [w]eighted quarter grades or [e]xam calculator: ");
		char option = s.next().charAt(0);
		
		
		//only continue with valid input
		while (option != 'w' && option != 'e') {
			
			//in case the option was the wong case
			if (option < 97) option += 56;
			
			//get new input
			if (option != 'w' && option != 'e') {
				System.out.println("INVALID INPUT");
				System.out.print("Are you looking for [w]eighted quarter grades or [e]xam calculator: ");
				option = s.next().charAt(0);
			}
		}
		
		//weighted grades
		if (option == 'w') {
			System.out.print("How many types of grade are there: ");
			int types = s.nextInt();
			
			//array for weight and grades
			double distribution[][] = new double[types][2];
			for (int j = 0; j < types; j++) Arrays.fill(distribution[j], 0);
			
			//get weights, making sure it doesn't exceed 100 percent
			double total = 0.0;
			for (int i = 0; i < types; i++) {
				System.out.print("Weight given to category " + (i + 1) + ": ");
				distribution[i][0] = s.nextDouble();
				total += distribution[i][0];
				
				//check if total is too high
				if (total > 100) {
					System.out.println("ERROR: total value exceeds 100 (" + total + ")");
					i--;
				}
			}
			
			//get grades in category
			for (int i = 0; i < types; i++) {
				System.out.print("Grade in category " + (i + 1) + ": ");
				distribution[i][1] = s.nextDouble();
			}
			
			//array where grades are calculation
			double grades[] = new double[types];
			Arrays.fill(grades, 0);
			
			//calculation
			for (int k = 0; k < types; k++) grades[k] = (distribution[k][0]/100)*distribution[k][1];
			
			//add it together
			total = 0.0;
			for (int k = 0; k < types; k++) total += grades[k];
			
			//display
			System.out.println("Grade: " + total);
			
			for (int k = 0; k < types; k++) System.out.println("Contribution from category " + (k+1) + ": " + grades[k]);
		}
		
		//exam calculator
		else if (option == 'e') {
			
			System.out.print("Grade point scale (integer): ");
			
			int scale = (int)(s.nextDouble());
			
			System.out.print("Q1 grade: ");
			double q1 = s.nextDouble();
			System.out.print("Q2 grade: ");
			double q2 = s.nextDouble();
			
			double semester = ((q1+q2)/2);
			
			System.out.print("Exam weight:");
			double weight = s.nextDouble();
			
			double check = 99.5;
			for (int i = 0; i < 5; i++) {
				check -= scale;
				
				char grade = ' ';
				if (i == 0) grade = 'A';
				else if (i == 1) grade = 'B';
				else if (i == 2) grade = 'C';
				else if (i == 3) grade = 'D';
				else if (i == 4) grade = 'F';
				
				
				double gradeNeeded = (check - ((100-weight)/100)*semester)/(weight/100);
				
				System.out.println("Grade needed to get " + grade + ": " + (int)(gradeNeeded + 1));
			}
			
		}
		s.close();
	}
}