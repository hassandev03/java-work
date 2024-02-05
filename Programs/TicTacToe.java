import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;

public class TicTacToe {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int[] num = new int[4];
//		num[0]=toss, num[1]=move, num[2]=player1_score, num[3]=player2_score

		String[] str = new String[2];
//		String player1,String player2

		char[] ch = new char[2];
//		char player1_symbol,char player2_symbol

		boolean Move = false;
		boolean game = true;
		
		System.out.println("======================");
	    System.out.println("Welcome to TIC TAC TOE");
	    System.out.println("======================\n");
	
		while (game == true) {
			char Grid[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
			int WinningCombinations[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 },
					{ 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };
			int SideMoves[] = { 1, 3, 5, 7 };
			int CornerMoves[] = { 0, 2, 6, 8 };

			Toss(num, str, ch);
			
			User(num, str, ch, Grid, WinningCombinations, Move);

			System.out
					.print("If you want to restart the game, press 1.\nIf you want to end the game, press any number:");

			int restart = input.nextInt();
			if (restart == 1)
				game = true;
			else
				game = false;

		}
	}


	public static void User(int[] num, String[] str, char[] ch, char[] Grid, int[][] WinningCombinations,
			boolean Move) {
		Scanner input = new Scanner(System.in);
		int toss = num[0];
		int move = num[1];
		int player1_score = num[2];
		int player2_score = num[3];
		String player1 = str[0];
		String player2 = str[1];
		char player1_symbol = ch[0];
		char player2_symbol = ch[1];
		boolean won = false;
		int turn = toss;

		for (int i = 0; i < 9; i++) {
			if (turn == 0) {
				turn = 1;
				System.out.print("Enter the box number where you want to play: ");
				move = input.nextInt();
				while (move < 1 || move > 9) {
					System.out.println("Invalid move, try again!");
					System.out.print("Enter the box number where you want to play: ");
					move = input.nextInt();
				}

				while (Grid[move - 1] == player1_symbol || Grid[move - 1] == player2_symbol) {
					System.out.print("Invalid move, try again!");
					System.out.print("Enter the box number where you want to play: ");
					move = input.nextInt();
				}
				Grid[move - 1] = player1_symbol;
				won = false;
				for (int[] k : WinningCombinations) {
					boolean winCombo = true;
					for (int t : k) {
						if (Grid[t] != player1_symbol) {
							winCombo = false;
							break;
						}
					}
					if (winCombo) {
						won = true;
						break;
					}
				}

				System.out.printf(
						"\n%s's turn: \n" + "  %s |  %s  | %s \n" + "----+-----+----\n" + "  %s |  %s  | %s \n"
								+ "----+-----+----\n" + "  %s |  %s  | %s \n\n\n",
						player1, Grid[0], Grid[1], Grid[2], Grid[3], Grid[4], Grid[5], Grid[6], Grid[7], Grid[8]);

				if (won) {
					System.out.printf("Congratulations!!!! %s Won the match.\n", player1);
					player1_score = player1_score + 5;
					break;
				}
			} else {
				turn = 0;
				System.out.print("Enter the box number where you want to play: ");
				move = input.nextInt();
				while (1 > move && move > 9) {
					System.out.println("Invalid move, try again!\n");
					System.out.print("Enter the box number where you want to play: ");
					move = input.nextInt();
				}

				while (Grid[move - 1] == player1_symbol || Grid[move - 1] == player2_symbol) {
					System.out.println("Invalid move, try again!\n");
					System.out.print("Enter the box number where you want to play: ");
					move = input.nextInt();
				}

				Grid[move - 1] = player2_symbol;
				won = false;
				for (int[] k : WinningCombinations) {
					boolean winCombo = true;
					for (int t : k) {
						if (Grid[t] != player2_symbol) {
							winCombo = false;
							break;
						}
					}
					if (winCombo) {
						won = true;
						break;
					}
				}

				System.out.printf(
						"\n%s's turn: \n" + "  %s |  %s  | %s \n" + "----+-----+----\n" + "  %s |  %s  | %s \n"
								+ "----+-----+----\n" + "  %s |  %s  | %s \n\n\n",
						player2, Grid[0], Grid[1], Grid[2], Grid[3], Grid[4], Grid[5], Grid[6], Grid[7], Grid[8]);

				if (won) {
					System.out.printf("Congratulations!!!! %s Won the match.\n", player2);
					player2_score = player2_score + 5;
					break;
				}

			}
			int x = 0;
			for (int j = 0; j < 9; j++) {
				if (won != true && (Grid[j] == player1_symbol || Grid[j] == player2_symbol)) {
					x++;
				}
			}
			if (x == 9) {
				System.out.println("Its a Draw!");
				break;
			}
		}
		num[2] = player1_score;
		num[3] = player2_score;
		System.out.println(player1 + " Score: " + player1_score);
		System.out.println(player2 + " Score: " + player2_score);
	}

	

	public static void Toss(int[] num, String[] str, char[] ch) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int upperbound = 2;
		int toss = num[0];
		String player1 = str[0];
		String player2 = str[1];
		char player1_symbol = ch[0];
		char player2_symbol = ch[1];

		
		System.out.print("Enter player1 name: ");
		player1 = input.next();
		System.out.print("Enter player2 name: ");
		player2 = input.next();
		toss = rand.nextInt(upperbound);
		if (toss == 0) {
			System.out.printf("%s won the toss.\n", player1);
			System.out.print("Choose a symbol (x or o): ");
			char symbol = input.next().charAt(0);
			if (symbol == 'x') {
				player1_symbol = 'x';
				player2_symbol = 'o';
			} else {
				player1_symbol = 'o';
				player2_symbol = 'x';
			}
			System.out.printf("%s chose %s \n", player1, player1_symbol);
			System.out.printf("%s got %s \n", player2, player2_symbol);
		} else {
			System.out.printf("%s won the toss.\n", player2);
			System.out.print("Choose a symbol (x or o): ");
			char symbol = input.next().charAt(0);
			if (symbol == 'x') {
				player2_symbol = 'x';
				player1_symbol = 'o';
			} else {
				player2_symbol = 'o';
				player1_symbol = 'x';
			}
			System.out.printf("%s chose %s \n", player2, player2_symbol);
			System.out.printf("%s got %s \n", player1, player1_symbol);
		}

		
		num[0] = toss;
		str[0] = player1;
		str[1] = player2;
		ch[0] = player1_symbol;
		ch[1] = player2_symbol;
	}
}