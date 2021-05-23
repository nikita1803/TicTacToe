package tictactoe;

import java.util.Scanner;

public class Tictactoe 
{
	static char[] board = new char[10];
	
	public static void main(String[] args) 
	{
		char player;
		System.out.println("Welcome in Tic tac toe game");
		toss();
	}
	/*
	 * create board is function having character return type
	 * board is a character array of length 10.
	 * return board
	 */
	
	public static char[] createBoard()
	{
		char[] board = new char[10];
		for(int i = 1; i < board.length; i++)
		{
			board[i] = ' ';
		}
		return board;
	}
	/**
	 * choose is a function of character type  
	 * here we choose the value from input to select X or O 
	 * @return computer variable 
	 */
	public static char choose()
	{
		Scanner sc = new Scanner(System.in);
		char computerVariable = 0 ;
		System.out.println("Enter the characater 'X' OR 'O' to play");
		char playerChoose =  sc. next().charAt(0);
		if(playerChoose == 'X' || playerChoose == 'x' )
		{
			computerVariable = 'O';
			System.out.println("Player input is :" +playerChoose);
			System.out.println("Computer input is :" +computerVariable);
			return computerVariable;
		}
		else if(playerChoose == 'O' || playerChoose == 'o' )
		{
			computerVariable = 'X';
			System.out.println("Player input is :" +playerChoose);
			System.out.println("Computer input is :" +computerVariable);
		}
		else
		{
			System.out.println("Invalid input please input the valid charcter");
		}
		return computerVariable;
	}
	/**
	 * show board is a function of character type 
	 * this function is use to show the board like tic tac toe 
	 * @param board
	 * @return board
	 */
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
	/**
	 * move is a function of character type who moves the player 
	 * take the move value from user using scanner function
	 * @param board
	 * @param choose
	 * @return board value
	 */
	public static char[] move(char[] board , char choose)
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 1; i++)
		{
			System.out.println("Enter the value between 1 to 9 to move");
			int value = sc.nextInt();
			if(board[value] == ' ')
			{
				board[value] = choose;
				
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
	/**
	 * toss is a function of void type which return nothing
	 * here i use random function to toss 
	 * if random function generate 1 which means HEAD then player 1 move else computer move
	 * if player 1 win the toss then move function call and in that ask to the user to choose the position.
	 * if computer win the toss then comp move function call and it place automatically comp variable in the the board 
	 */
	public static void toss() 
	{
		char player;
		char[] board = createBoard();
		char[] ticBoard = showBoard(board);
		char choice = choose();
		if(choice=='O') {
			player='X';
		}
		else
		{
			player='O';
		}
		int toss = (int) Math.floor(Math.random() * 10) % 2+1;
		switch(toss) 
		{
			case 1://Head
				System.out.println("player 1 win the toss so player 1 play the first");
				move(ticBoard , player);
				showBoard(board);
			break;
			default://Tail
				System.out.println("computer win the toss so the computer play the first");
				compMove(choice,ticBoard);
				showBoard(board);
		}
	}
	/**
	 * winner check is a function of character type check that player win the match or not
	 * here i check for 4 conditions , for horizontal , vertical , diagonal and tie .
	 * @param board
	 * @return null
	 */
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
	/**
	 * winner computer is a function to check that computer is winning or not
	 * here also we check the 4 condition horizontal , vertical , diagonal , and for tie
	 * @param board
	 * @param computerChoice
	 * @return null
	 */
	// computer case 
	public static char[] winnerComputer(char[] board, char computerChoice)
	{
		for( int i = 1; i < 3; i++ )  // For Horizontally
	    {
			for(int j = 1;j <= i; j = j+3)
			{
				if( ( board[j] == computerChoice) && ( board[i+j] == computerChoice) )
				{
					board[i+j+1]= computerChoice;
					return board;
				}
				
			}
	    }
	    for( int i = 1; i < 3; i++ )  // For Vertically
	    {
	    	for(int j = 1;j <= i; j++)
	    	{
	    		if( ( board[j] == computerChoice ) && ( board[j+i+2] == computerChoice ) )
	    		{
	    			board[j+i+5] = computerChoice;
	    			return board;
	    		}
	    	}
	    }
	    // For Diagonal
	    
	    if( ( board[1] == computerChoice ) &&  ( board[5] == computerChoice ) )
	    {
	    	board[9] = computerChoice;
	        return board;
	    }
	    if( ( board[3] == computerChoice ) &&  ( board[5] == computerChoice ) )
	    {
	    	board[7] = computerChoice;
	    	return board;
	    }
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
		return board;
	}
	/**
	 * computer move is function of void type 
	 * check where the board cell is empty then comp. place automatically to the value in empty cell.
	 * @param computerChoice
	 * @param board
	 */
	public static void compMove(char computerChoice,char[] board) 
	{
		for (int l=0; l<board.length; l++) 
		{
			if(board[l] == ' ') 
			{
				board[l] = computerChoice;	
				break;
			}
		}
	}
}
