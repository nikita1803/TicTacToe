package tictactoe;

import java.util.Scanner;

public class Tictactoe 
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome in Tic tac toe game");
		char[] board = createBoard();
		char choice = choose();
		char[] ticBoard = showBoard(board);
		toss();
		move(ticBoard , choice);
		//showBoard(board);
		char win =winnerCheck(board);
		System.out.println("Winner is " + win);
		
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
	public static char choose()
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
		return playerChoose;
	}
	public static char[] showBoard(char[] board)
	{
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("--------------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("--------------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
		System.out.println("--------------");
		return board;
	}
	public static char[] move(char[] board , char choose)
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 3; i++)
		{
			System.out.println("Enter the value between 1 to 9 to move");
			int value = sc.nextInt();
			if(board[value] == ' ')
			{
				board[value] = choose;
				showBoard(board);
			}
			else
			{
				System.out.println("Your desired place is not empty ");
			}
			if(value < 1 || value > 9)
			{
				System.out.println("Invalid input please input the valid digit");
			}
		}
		winnerCheck(board);
		return board;
	}
	public static void toss() 
	{
		int toss = (int) Math.floor(Math.random() * 10) % 2+1;
		switch(toss) 
		{
			case 1://Head
				System.out.println("player 1 win the toss so player 1 play the first");
			break;
			default://Tail
				System.out.println("computer win the toss so the computer play the first");
		}
	}
	public static char winnerCheck(char[] board)
	{
		for( int i = 1; i < 3; i++ )  // For Horizontally
	    {
			for(int j = 1;j <= i; j = j+3)
			{
				if( ( board[j] == 'X') && ( board[i+j] == 'X') && ( board[i+j+1] == 'X' ) )
				{
					return 'X';
				}
				if( ( board[j] == 'O' ) && ( board[i+j] == 'O' ) && ( board[i+j+1] == 'O' ) )
				{
					return 'O';
				}
			}
	    }
	    for( int i = 1; i < 3; i++ )  // For Vertically
	    {
	    	for(int j = 1;j <= i; j++)
	    	{
	    		if( ( board[j] == 'X' ) && ( board[j+i+2] == 'X' ) && ( board[j+i+5] == 'X' ) )
	    		{
	    			return 'X';
	    		}
	        
	    		if( ( board[j] == 'O' ) && ( board[j+i+2] == 'O' ) && ( board[j+i+5] == 'O' ) )
	    		{
	    			return 'O';
	    		}
	    	}
	    }
	    // For Diagonal
	    
	    if( ( board[1] == 'X' ) &&  ( board[5] == 'X' ) &&  ( board[9] == 'X' ) )
	        return 'X';
	    if( ( board[3] == 'X' ) &&  ( board[5] == 'X' ) &&  ( board[7] == 'X' ) )
	    	return 'X';
	    if( ( board[1] == 'O' ) &&  ( board[5] == 'O' ) &&  ( board[9] == 'O' ) )
	    	return 'O';
	    if( ( board[3] == 'O' ) &&  ( board[5] == 'O' ) &&  ( board[7] == 'O' ) )
	    	return 'O';
	    
	    //check for a cell ( no win )
	    for( int i = 1; i < board.length; i++ )
	    {
	    	int  cell=0;
	    	if(board[i]!=' ')
	    	{
	    		cell++;
	    	}
	    	if(cell==9)
	    	{
	    	System.out.println("Match is tie");
	    	}
	    }
		return 0;
	}
}
