/*
 *  Future version(s) may include:
 * -Better high score tracking, possibly use a server to make it competitive?
 */
package games;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.time.Instant;
import java.time.Duration;

public class masterMind {
	//central program
	public static void main(String[] args) {
		System.out.println("MASTERMIND v.8");
		wait(1);
		
		//find and print high score
		int[] highScore = checkHighScore();
		System.out.println("Current best game is " + highScore[0] + " in " + highScore[2] + " achieved at a total difficulty of " + highScore[1]);
		
		Scanner n = new Scanner(System.in);
		//boolean to keep playing
		boolean cont = true;
		
		//loop game so long as the bool to keep playing is true
		while (cont) {
			//set gamemode
			System.out.print("Pick gamemode. Would you like to [p]lay or have [c]omputer play itself: ");
			char gm = n.next().charAt(0);
			
			//peg options
			System.out.print("Pick a peg level (how many different possible pegs, 4 is normal): ");
			int pegs = n.nextInt();
			char[] options = new char[pegs];
			
			//populate array to start, then add in user's choice of characters
			Arrays.fill(options, '?');
			System.out.println("Pick your favorite characters as pegs, but don't choose '?'. (Mine is the ~)");
			for (int i = 0; i < options.length; i++) {
				System.out.print("Character " + (i + 1) + ": ");
				char choice = n.next().charAt(0);
				
				//make sure that none of the pegs are the same or spaces
				boolean okChar = true;
				for (char j : options) {
					if (choice == j) okChar = false;
				}
				
				if (okChar) options[i] = choice;
				else {
					System.out.println("Either you've already chosen this as an option, or it's a space. Either way, choose again");
					i--;
				}
			}
			
			//difficulty, total difficulty is total possible combinations
			System.out.print("Pick a difficulty level (an int 2-10, 4 being normal): ");
			int difficulty = n.nextInt();
			int totalDifficulty = pegs*difficulty;
			System.out.println("Your total difficulty is: " + totalDifficulty);
			
			//create the computer's array, win con, and score variables
			char[] compRand = compGen(options, difficulty);
			boolean win = false;
			int turns = 1;
			
			//computer game mode
			if (gm == 'c') {
				//first turn
				char[] compChoice = compGen(options, difficulty);
				
				//keep playing until win con is met
				while (!win) {
					int correct = check(compRand, compChoice);
					
					//show what the computer chose
					System.out.print("Computer choices: ");
					for(char i : compChoice) {
						System.out.print(i + " ");
					}
					System.out.println();
					
					System.out.print("Computer got " + correct + " pegs correct. (");
					
					//print which pegs the computer got correct
					char[] correctPegs = keepCorrect(compRand, compChoice);
					for(char i : correctPegs) {
						System.out.print(i + " ");
					}
					System.out.println(")");
					
					//check if win con has been met
					if (correct == compRand.length) win = true;
					else {
						System.out.println("Pick new pegs.\n");
						turns++;
						
						//computer keeps previous correct pegs as it makes a new choice
						//correct pegs declared earlier
						compChoice = compGen(options, difficulty);
						for (int j = 0; j < correctPegs.length; j++) {
							if (correctPegs[j] != '?') compChoice[j] = correctPegs[j];
						}
					}
					wait(1);
				}
				//only prints after win = true
				System.out.println("\nComputer has won!");
				System.out.println("It only took " + turns + " turns.");
			}
			
			//player game mode
			else {
				//start game timer, set variable to allow hint
				Instant startGame = Instant.now();
				System.out.println("Enter your guesses when it says \"Pick peg\". If you type '?' you will see a hint");
				System.out.println("as to what one of your previously correct choices were. It will only display the hint");
				System.out.println("if you got at least 1 correct on the previous choice. Good luck to you!");
				boolean hasHint = true;
				
				//first picking of pegs, set array for hints
				char[] answers = new char[difficulty];
				char[] correctPegs = new char[difficulty];
				Arrays.fill(correctPegs, '?');
				
				//picking the pegs
				for(int i = 0; i < answers.length; i++) {
					System.out.print("Pick peg " + (i + 1) + ": ");
					char next = n.next().charAt(0);
					
					//check if the picked peg is within the options
					boolean isAvailable = true;
					for (char j : options) {
						if (next == j) {
							isAvailable = true;
							break;
						}
						else isAvailable = false;
					}
					//only count choice if it is within options
					if (isAvailable) answers[i] = next;
					else {
						System.out.println("Improper input, that peg is not available");
						i--;
					}
				}
				
				//keep playing until win con is met
				while (!win) {
					//find how many were correct, save correct answers for hint
					int correct = check(compRand, answers);
					correctPegs = keepCorrect(compRand, answers);
					System.out.println("You got " + correct + " pegs correct.");
					
					//checks if player has won
					if (correct == compRand.length) win = true;
					else {
						//next turn, pick new pegs
						turns++;
						System.out.println("Pick new pegs.\n");
						wait(1);
						
						//for loop to pick new pegs
						for(int i = 0; i < answers.length; i++) {
							System.out.print("Pick peg " + (i + 1) + ": ");
							char next = n.next().charAt(0);
							
							//bool that will check if the picked peg is within the options
							boolean isAvailable = true;
							
							//if not choosing a hint
							if (next != '?') {
								
								//make sure it is an available option
								for (char j : options) {
									if (next == j) {
										isAvailable = true;
										break;
									}
									else isAvailable = false;
								}
								
								//only count answer if it is an available option
								if (isAvailable) answers[i] = next;
								else {
									System.out.println("Improper input, that peg is not available");
									i--;
								}
							}
							
							//if it is a hint
							else {
								//has to have a previous correct
								if (correct > 0) {
									//has to have their hint available
									if (hasHint) {
										int randHint = (int)(Math.random()*correctPegs.length);
										char hint = correctPegs[randHint];
										
										//hint has to actually be a character
										while(hint == '?') {
											randHint = (int)(Math.random()*correctPegs.length);
											hint = correctPegs[randHint];
										}
										
										System.out.println("Peg " + (randHint + 1) + " is '" + hint + "'");
										hasHint = false;
									}
									
									else {
										System.out.println("You have already used your hint. Cannot provide another");
									}
								}
								
								else {
									System.out.println("You did not have any correct on the previous try, cannot display hint");
								}
								
								i--;
							}//get hints
						}//for loop to get new pegs
					}//getting new inputs
				}//win con
				
				//only happens once win = true
				System.out.println("\nYou have won!");
				
				//ends timer
				Instant finishGame = Instant.now();
				int timeElapsed = (int)(Duration.between(startGame, finishGame).toSeconds());
				
				//print stats
				System.out.print("It only took " + turns + " turns and " + timeElapsed + " seconds");
				
				
				//only saves high score if it was the player playing
				saveHighScore(totalDifficulty, turns, timeElapsed);
			}
			
			//sees if player wants to keep going
			System.out.print("Would you like to [c]ontinue or [s]top playing: ");
			char choose = n.next().charAt(0);
			if (choose == 'c') cont = true;
			else cont = false;
		}
		n.close();
	}
	
	//computer choices
	public static char[] compGen(char[] options, int difficulty) {
		char[] ans = new char[difficulty];
		
		//pick a random number from the options multiple times
		for (int i = 0; i < ans.length; i++) {
			int rand = (int)(Math.random()*options.length);
			char thisAns = options[rand];
			ans[i] = thisAns;
		}
		return ans;
	}
	
	//store the correct answers
	public static char[] keepCorrect(char[] a, char[] b) {
		//array that will store which pegs are correct
		char[] currentCorrect = new char[a.length];
		Arrays.fill(currentCorrect, '?');
		
		//if there is a match, store the match
		for (int i = 0; i < a.length; i++) {
			if (a[i] == b[i]) currentCorrect[i] = a[i];
		}
		
		return currentCorrect;
	}
	
	//check the similarity of the two arrays
	public static int check(char[] rands, char[] choices) {
		int numCorrect = 0;
		
		//if there is a match, tick up how many were correct
		for (int i = 0; i < rands.length; i++) {
			if (rands[i] == choices[i]) numCorrect++;
		}
		
		return numCorrect;
	}
	
	//wait method
	public static void wait(int secs) {
		try {
			TimeUnit.SECONDS.sleep(secs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//checks high scores
	public static int[] checkHighScore() {
		//array that will house score and total difficulty
		int[] scoreDiff = new int[3];
		
		//get computer's username so can save high scores
		String user = System.getProperty("user.name");
		try {
			//loads up high score file, makes sure it exists
			File highscores = new File("C:\\Users\\" + user + "\\MasterMindScores.txt");
			if (highscores.exists()) {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\MasterMindScores.txt");
				BufferedReader readFile = new BufferedReader(fw);
				
				//puts highscore and that difficulty into the array
				scoreDiff[0] = Integer.parseInt(readFile.readLine());
				scoreDiff[1] = Integer.parseInt(readFile.readLine());
				scoreDiff[2] = Integer.parseInt(readFile.readLine());
				readFile.close();
			}
			
			//if it doesn't exist, the high scores are 0
			else {
				scoreDiff[0] = 0;
				scoreDiff[1] = 0;
				scoreDiff[2] = 0;
			}
		//needed so that working with files actually works
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return scoreDiff;
	}
	
	public static void saveHighScore(int diff, int score, int secs) {
		//total score = turns - difficulty + (time taken/5)
		int currentScore = score - diff + (int)(secs/5);
		int[] prevHigh = checkHighScore();
		int prevScore = prevHigh[0] - prevHigh[1] + prevHigh[2];
		
		//different actions for better, equal, or less than the previous best
		//lower score = better. like golf!
		
		//for first time playing or for better than previous best
		if (prevHigh[0] == 0|| currentScore < prevScore) {
			System.out.println("\nNew best game!");
			
			String user = System.getProperty("user.name");
			try {
				File highscores = new File("C:\\Users\\" + user + "\\MasterMindScores.txt");
				//delete old scores
				if (highscores.exists()) highscores.delete();
				
				//write new score and difficulty
				FileWriter fw = new FileWriter("C:\\Users\\" + user + "\\MasterMindScores.txt");
				BufferedWriter writeFile = new BufferedWriter(fw);
				
				writeFile.write(Integer.toString(score));
				writeFile.newLine();
				writeFile.write(Integer.toString(diff));
				writeFile.newLine();
				writeFile.write(Integer.toString(secs));
				writeFile.close();
				
			//needed so that working with files actually works
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		else if (currentScore == prevScore) System.out.println("\nEqual to best game. So close!");
		else System.out.println("\nNot quite at your best game. Better luck next time!");
	}
}