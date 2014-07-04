package wumpus.journey;

import wumpus.xml_parsing.WumpusWorldParser;


/**
 * @author Stamatis Pitsios
 */
public class GameBoard 
{
	/**
	 * The symbol that indicates that a square is OK.
	 */
	private final String Ok = "OK";
	
	/**
	 * The symbol that indicates that a square contains a pit.
	 */
	private final String Pit = "P";
	
	/**
	 * The symbol that indicates that a square contains a breeze.
	 */
	private final String Breeze = "B";
	
	/**
	 * The symbol that indicates that a square contains a stench.
	 */
	private final String Stench = "S";
	
	/**
	 * The symbol that indicates that a square contains the Wumpus.
	 */
	private final String Wumpus = "W";
	
	/**
	 * The symbol that indicates that a square contains the gold.
	 */
	private final String Gold = "G";
	
	/**
	 * The original board of the game.
	 */
	private String[][] board;
	
	/**
	 * The agent's initial position.
	 */
	private Position position;
	
	/**
	 * The size of the world.
	 */
	private int size;
	
	
	/**
	 * Constructor.
	 * 
	 * @param fileName The file that contains information about the world.
	 */
	public GameBoard(String fileName)
	{
		WumpusWorldParser parser = new WumpusWorldParser(fileName);
		Object[] contents = parser.parse();
		
		this.board = (String[][])contents[0];
		this.position = (Position)contents[1];
		this.size = board.length;
		
		this.AddRest();
		this.AddOk();
	}
	
	
	/**
	 * @return size The size of the current world
	 */
	public int getSize()
	{
		return this.size;
	}
	
	
	/**
	 * @return position The agent's initial position.
	 */
	public Position getInitialPosition()
	{
		return this.position;
	}
	
	
	/**
	 * Returns the contents of the specified position of the board.
	 * 
	 * @param row The row of the board.
	 * @param col The column of the board.
	 * 
	 * @return board[row][col] The contents of the board specific cell.
	 */
	public String GetData(int row , int col)
	{
		return board[row][col];
	}
	
	
	/**
	 * Removes the Wumpus and the stenches from the map. This method is called after the wumpus has died.
	 */
	public void RemoveWumpus()
	{
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				if(board[i][j].contains(this.Wumpus))
				{
					if(!board[i][j].contains(this.Gold) && !board[i][j].contains(this.Ok) && !board[i][j].contains(this.Pit) && !board[i][j].contains(this.Breeze))
					{
						board[i][j] = board[i][j].replace(this.Wumpus , this.Ok);
					}
					
					else
					{
						if(board[i][j].contains(","+this.Wumpus)) board[i][j] = board[i][j].replace(","+this.Wumpus , "");
						else if(board[i][j].contains(this.Wumpus+","))   board[i][j] = board[i][j].replace(this.Wumpus+"," , "");
					}
				}
				
				else if(board[i][j].contains(this.Stench))
				{
					if(!board[i][j].contains(this.Gold) && !board[i][j].contains(this.Ok) && !board[i][j].contains(this.Pit) && !board[i][j].contains(this.Breeze))
					{
						board[i][j] = board[i][j].replace(this.Stench , this.Ok);
					}
					
					else
					{
						if(board[i][j].contains(","+this.Stench))       board[i][j] = board[i][j].replace(","+this.Stench , "");
						else if(board[i][j].contains(this.Stench+","))  board[i][j] = board[i][j].replace(this.Stench+"," , "");
					}
				}
			}
		}
	}
	
	
	/**
	 * Adds the Breeze and Stench tags on the board.
	 */
	private void AddRest()
	{
		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				if(board[i][j].contains(Wumpus))
				{
					//we must place the Stench tag up , down , right and left of the wumpus.
					
					//Up!
					int row =i-1;
					if(row>=0)
					{
						if(board[row][j].equals(""))             board[row][j]+=Stench;
						else if(!board[row][j].contains(Stench)) board[row][j]+= (","+Stench);
					}
					
					
					//Down!
					row = i+1;
					if(row<size)
					{
						if(board[row][j].equals(""))             board[row][j]+=Stench;
						else if(!board[row][j].contains(Stench)) board[row][j]+= (","+Stench);
					}
					
					
					//Right!
					int col = j+1;
					if(col<size)
					{
						if(board[i][col].equals(""))             board[i][col]+=Stench;
						else if(!board[i][col].contains(Stench)) board[i][col]+= (","+Stench);
					}
					
					
					//Left!
					col = j-1;
					if(col>=0)
					{
						if(board[i][col].equals(""))              board[i][col]+=Stench;
						else if(!board[i][col].contains(Stench))  board[i][col]+= (","+Stench);
					}
				}
				
				
				if(board[i][j].contains(Pit))
				{
					//we must place the Breeze tag up , down , right and left of the Pit.
					
					//Up!
					int row =i-1;
					if(row>=0)
					{
						if(board[row][j].equals(""))          board[row][j]+=Breeze;
						else if(!board[row][j].contains(Breeze)) board[row][j]+= (","+Breeze);
					}
					
					
					//Down!
					row = i+1;
					if(row<size)
					{
						if(board[row][j].equals(""))             board[row][j]+=Breeze;
						else if(!board[row][j].contains(Breeze)) board[row][j]+= (","+Breeze);
					}
					
					
					//Right!
					int col = j+1;
					if(col<size)
					{
						if(board[i][col].equals(""))             board[i][col]+=Breeze;
						else if(!board[i][col].contains(Breeze)) board[i][col]+= (","+Breeze);
					}
					
					
					//Left!
					col = j-1;
					if(col>=0)
					{
						if(board[i][col].equals(""))             board[i][col]+=Breeze;
						else if(!board[i][col].contains(Breeze)) board[i][col]+= (","+Breeze);
					}
				}
			}
		}
	}
	
	
	/**
	 * Add the OK tag to the empty positions.
	 */
	private void AddOk()
	{
		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				if(board[i][j].equals(""))
				{
					board[i][j]=Ok;
				}
			}
		}
	}
	
	
	/**
	 * Prints the board that the agent has explored.
	 */
	public void printBoard() 
	{		  
		for(int i=0; i< board.length; i++)
		{
			System.out.print("\t"+String.valueOf(i));
		}
			   
		System.out.println();
			  
		for(int i=0; i< board.length; i++)
		{
			System.out.print("\t*");
		}
			   
		System.out.println();
			  
	    for (int row = 0; row < board.length; row++) 
	    {
	    	System.out.print("     "+String.valueOf(row)+"*");
		         
	    	for (int col = 0; col <  board.length; col++) 
	        {
	    		System.out.print("\t" + board[row][col]); // print each of the cells
	        }
		         
	    	System.out.print(" *");
		    	 
	        System.out.println("\n");
	    }
		      
	    for(int i=0; i< board.length; i++)
		{
	    	System.out.print("\t*");
		}
	    
		System.out.println("\n\n\n\n\n");	      
	}	
}