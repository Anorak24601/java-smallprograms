package other;

import java.util.*;

public class DiceRoller {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //argsprocessor but not as fancy
		
		//get numbers of everything
		System.out.print("Num of dice: ");
		int numDice = s.nextInt();
		System.out.print("Num of rolls: ");
		int numRolls = s.nextInt();
		s.close(); //done with the scanner, close it
		
		int[][] rolls = new int[numRolls][numDice]; //2d array to store rolls
		System.out.println();//add a space, but this used to be a test
		
		for (int i = 0; i < numRolls; i++) { //loop for the amount of rolls
			for (int j = 0; j < numDice; j++) { //loop for each die inside the roll
				rolls[i][j] = (int)(Math.random()*6 + 1); //roll dice
			}
		}
		
		//print via loop
		for (int i = 0; i < numRolls; i++) {
			System.out.print("Roll " + (i+1) + ": ");
			for (int j = 0; j < numDice; j++) {
				System.out.print("" + rolls[i][j]); //print roll
				if (j<numDice-1) System.out.print(", "); //add a comma if needed
			}
			System.out.println(); //newline
		}
	}
}