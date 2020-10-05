package games;

public class Backgammon {

	
	static void printScreen(int[][][] boardIn) {
		
		//make an array that equals the boardIn array so it can be manipulated
		int[][][] board = boardIn;
		
		/* Prints like:
		* Side1 | Side2
		* XXXXX | OOOOO
		* 	    |
		*	    |
		*	    |
		* OOO   |   XXX
		*  	    |
		-------------
		* OOOOO | XXXXX
		* 	    |
		*	    |
		*	    |
		*	    |
		* XXX   |   OOO
		*/

		//Do each row
		for (int j = 0; j < 12; j++) {
			//print side one things
			for (int i = 0; i < 5; i++) {

				//Find what char type to print
				char spaceType = ' ';
				if (board[0][j][0] == 1) spaceType = 'X';
				else if (board[0][j][0] == 2) spaceType = 'O';

				//if too big, print how many more it has in the backmost space
				if (board[0][j][1] > 5) {
					System.out.print(board[0][j][1] - 4);
					board[0][j][1] = 5;
				}

				else if (spaceType != ' ' && board[0][j][1] > i) System.out.print(spaceType);
				else System.out.print(" ");
			}

			//separate the sides
			System.out.print(" | ");

			//print side two things
			for (int i = 4; i >=0; i--) {

				//Find what char type to print
				char spaceType = ' ';

				if (i == 0 && board[1][j][1] > 5) System.out.print(board[1][j][1] - 4);
				if (board[1][j][0] == 1) spaceType = 'X';
				else if (board[1][j][0] == 2) spaceType = 'O';

				if (spaceType != ' ' && board[1][j][1] > i) System.out.print(spaceType);
				else System.out.print(" ");
			}

			//newline
			System.out.println();

			//bar between sides
			if (j == 6) System.out.println("-------------");
		}
		
		
	}
}
