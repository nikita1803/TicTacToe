package tictactoe;

public class Tictactoe 
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome in Tic tac toe game");
		char[] board = createBoard();
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
}
