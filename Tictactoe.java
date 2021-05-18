package tictactoe;

import java.util.Scanner;

public class Tictactoe 
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome in Tic tac toe game");
		char[] board = createBoard();
		choose();
		showBoard(board);
	}
	public static char[] createBoard()
	{
		char[] board = new char[10];
		for(int i = 1; i < board.length; i++)
		{
			board[i] = ' ';
		}
		return board;
	}
	public static void choose()
	{
		Scanner sc = new Scanner(System.in);
		char computerVariable = 0 ;
		System.out.println("Enter the characater 'X' OR 'O' to play");
		char playerChoose =  sc. next().charAt(0);
		if(playerChoose == 'X')
		{
			computerVariable = 'O';
			System.out.println("Player input is :" +playerChoose);
			System.out.println("Computer input is :" +computerVariable);
		}
		else if(playerChoose == 'O')
		{
			computerVariable = 'X';
			System.out.println("Player input is :" +playerChoose);
			System.out.println("Computer input is :" +computerVariable);
		}
		else
		{
			System.out.println("Invalid input please input the valid charcter");
		}
		
	}
	public static void showBoard(char[] board)
	{
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("--------------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("--------------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
		System.out.println("--------------");
	}
}
