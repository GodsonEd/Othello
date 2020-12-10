public class OthelloBoard
{
	private int[][]board;
	private int turn;
	private boolean playing;
	private static final int EMPTY = 0;
	private static final int WHITE =1;
	private static final int BLACK = 2;
	private static final int TIE = 3;
	private static final int PLAYING = 4;
	public static final int WHITE_WINS=5;
	public static final int BLACK_WINS=6;
	public OthelloBoard()
	{
		reset();
	}
	public int getSpot(int c,int r)
	{
		/*for(int ro = 0;ro<board.length;ro++)
		{
			int[]row = board[ro];
			for(int co = 0;co<row.length;co++)
			{
				if(board[r][c] == board[ro][co])
				{
					if(board[ro][co] == 0)
					{
						return EMPTY;
					}
					else if(board[ro][co] == 1)
					{
						return WHITE;
					}
					else if(board[ro][co] ==  2)
					{
						return BLACK;
					}
				}
			}
		}
		return -1;*/
		//Was helped here
		if(isValidMove(c,r)==true)
		{
			return board[r][c];
		}
		
		return -1;
	}
	public boolean getPlaying()
	{
		return playing;
	}
	public void reset()
	{
		playing=true;
		turn=WHITE;
		board=new int[10][10];
		for(int x=0; x<10; x++)
		{
			for(int y=0; y<10; y++)
			{
				board[x][y]=EMPTY;
			}
		}
		board[4][4] = WHITE;
        board[4][5] = BLACK;
        board[5][4] = BLACK;
        board[5][5] = WHITE;
	}
	public void setSpot(int c,int r)
	{
		System.out.println("Spot on board:"+board[r][c]);
		System.out.println("is Valid:"+isValidMove(r,c));
		if(board[r][c] == EMPTY)
		{
			if(isValidMove(r,c))
			{
				board[r][c] = turn;
	            flip(r,c);
	            changeTurn(turn);
	            System.out.println("Changed Turns");
			}
		}
	}
	/*Helped with flip*/
	public boolean flip(int r,int c)
	{
		//up
		boolean f = false;
        int x=r;

        while(true)
        {
            if(x-1==-1)
            {
                break;
            }
            if(board[x-1][c]==EMPTY) {

                break;
            }
            if(board[x-1][c]==turn&&x==r)
            {
                break;
            }
            else if(board[x-1][c]==turn&&x!=r) {
                for(int i=r;i>x-1;i--)
                {
                    board[i][c] = turn;
                }
                f = true;
            }
            x--;

        }
		//left
        x=c;

        while(true)
        {
            if(x-1==-1)
            {
                break;
            }
            if(board[r][x-1]==EMPTY) {

                break;
            }
            else if(board[r][x-1]==turn&&x==c) {
                break;
            }
            else if(board[r][x-1]==turn&&x!=c) {
                for(int i=c;i>x-1;i--)
                {
                    board[r][i] = turn;
                }
                f = true;
            }
            x--;

        }
		//upleft
        x=c;
        int y=r;

        while(true)
        {
            if(x+1==10)
            {
                break;
            }
            if(y-1==-1)
            {
                break;
            }
            if(board[y-1][x+1]==EMPTY) {

                break;
            }
            else if(board[y-1][x+1]==turn&&x==c&&y==r) {
                break;
            }
            else if(board[y-1][x+1]==turn&&x!=c&&y!=r) {
                for(int i=c;i<x+1;i++)
                {
                    board[r - (i-c)][i] = turn;
                }
                f = true;
            }
            x++;
            y--;

        }
        //upright
        x=c;
        y=r;

        while(true)
        {
            if(x-1==-1)
            {
                break;
            }
            if(y-1==-1)
            {
                break;
            }
            if(board[y-1][x-1]==EMPTY) {

                break;
            }
            else if(board[y-1][x-1]==turn&&x==c&&y==r) {
                break;
            }
            else if(board[y-1][x-1]==turn&&x!=c&&y!=r) {
                for(int i=c;i>x-1;i--)
                {
                    board[r - (c-i)][i] = turn;
                }
                f = true;
            }
            x--;
            y--;

        }
        //Down
		x=r;

        while(true)
        {
            if(x+1==10)
            {
                break;
            }
            if(board[x+1][c]==EMPTY) {

                break;
            }
            if(board[x+1][c]==turn&&x==r)
            {
                break;
            }
            else if(board[x+1][c]==turn&&x!=r) {
                for(int i=r;i<x+1;i++)
                {
                  board[i][c] = turn;
                }
                f = true;
            }
            x++;

        }
        //right
        x=c;

        while(true)
        {
            if(x+1==10)
            {
                break;
            }
            if(board[r][x+1]==EMPTY) {

                break;
            }
            else if(board[r][x+1]==turn&&x==c) {
                break;
            }
            else if(board[r][x+1]==turn&&x!=c) {
                for(int i=c;i<x+1;i++)
                {
                    board[r][i] = turn;
                }
                f = true;
            }
            x++;

        }
        //downright
        x=c;
        y=r;

        while(true)
        {
            if(x+1==10)
            {
                break;
            }
            if(y+1==10)
            {
                break;
            }
            if(board[y+1][x+1]==EMPTY) {

                break;
            }
            else if(board[y+1][x+1]==turn&&x==c&&y==r) {
                break;
            }
            else if(board[y+1][x+1]==turn&&x!=c&&y!=r) {
                for(int i=c;i<x+1;i++)
                {
                    board[r+(i-c)][i] = turn;
                }
                f = true;
            }
            x++;
            y++;

        }


        //downleft
        x=c;
        y=r;

        while(true)
        {
            if(x-1==-1)
            {
                break;
            }
            if(y+1==10)
            {
                break;
            }
            if(board[y+1][x-1]==EMPTY) {

                break;
            }
            else if(board[y+1][x-1]==turn&&x==c&&y==r) {
                break;
            }
            else if(board[y+1][x-1]==turn&&x!=c&&y!=r) {

                for(int i=c;i>x-1;i--)
                {
                    board[r +(c-i)][i] = turn;
                }
                f = true;
            }
            x--;
            y++;

        }
        
        return f;
	}
	public boolean isValidMove(int r, int c)
	{
		//down
        int x=r;

        while(true)
        {
            if(x+1==10)
            {
                break;
            }
            if(board[x+1][c]==EMPTY) {

                break;
            }
            if(board[x+1][c]==turn&&x==r)
            {
                break;
            }
            else if(board[x+1][c]==turn&&x!=r) 
            {
                return true;
            }
            x++;

        }
		//up
         x=r;

        while(true)
        {
            if(x-1==-1)
            {
                break;
            }
            if(board[x-1][c]==EMPTY)
            {

                break;
            }
            if(board[x-1][c]==turn&&x==r)
            {
                break;
            }
            else if(board[x-1][c]==turn&&x!=r) 
            {
                return true;
            }
            x--;

        }
        //left
        x=c;

        while(true)
        {
            if(x-1==-1)
            {
                break;
            }
            if(board[r][x-1]==EMPTY) {

                break;
            }
            else if(board[r][x-1]==turn&&x==c) {
                break;
            }
            else if(board[r][x-1]==turn&&x!=c) {
                return true;
            }
            x--;

        }
        //right
        x=c;

        while(true)
        {
            if(x+1==10)
            {
                break;
            }
            if(board[r][x+1]==EMPTY) {

                break;
            }
            else if(board[r][x+1]==turn&&x==c) {
               break;
            }
            else if(board[r][x+1]==turn&&x!=c) {
                return true;
            }
            x++;

        }
        //downright
        x=c;
        int y=r;

        while(true)
        {
            if(x+1==10)
            {
                break;
            }
            if(y+1==10)
            {
                break;
            }
            if(board[y+1][x+1]==EMPTY) {

                break;
            }
            else if(board[y+1][x+1]==turn&&x==c&&y==r) {
                break;
            }
            else if(board[y+1][x+1]==turn&&x!=c&&y!=r) {
                return true;
            }
            x++;
            y++;

        }


        //downleft
        x=c;
         y=r;

        while(true)
        {
            if(x-1==-1)
            {
                break;
            }
            if(y+1==10)
            {
                break;
            }
            if(board[y+1][x-1]==EMPTY) {

                break;
            }
            else if(board[y+1][x-1]==turn&&x==c&&y==r) {
                break;
            }
            else if(board[y+1][x-1]==turn&&x!=c&&y!=r) {
                return true;
            }
            x--;
            y++;

        }

        //upright
        x=c;
        y=r;

        while(true)
        {
            if(x-1==-1)
            {
                break;
            }
            if(y-1==-1)
            {
                break;
            }
            if(board[y-1][x-1]==EMPTY) {

                break;
            }
            else if(board[y-1][x-1]==turn&&x==c&&y==r) {
                break;
            }
            else if(board[y-1][x-1]==turn&&x!=c&&y!=r) {
                return true;
            }
            x--;
            y--;

        }

        //downleft
        x=c;
        y=r;

        while(true)
        {
            if(x+1==10)
            {
                break;
            }
            if(y-1==-1)
            {
                break;
            }
            if(board[y-1][x+1]==EMPTY) {

                break;
            }
            else if(board[y-1][x+1]==turn&&x==c&&y==r) {
                break;
            }
            else if(board[y-1][x+1]==turn&&x!=c&&y!=r) {
                return true;
            }
            x++;
            y--;

        }
        return false;
	}
	public int[][] getBoard()
	{
		return board;
	}
	public int getTurn()
	{
		return turn;
	}
	public void changeTurn(int player)
	{
		if(player==WHITE)
		{
			System.out.println("change to black");
			turn=BLACK;
		}
		else if(player==BLACK)
		{
			turn=WHITE;
		}
	}
	public boolean canMove(int player)
	{
		for(int x=0; x<10; x++)
		{
			for(int y=0; y<10; y++)
			{
				if(isValidMove(x,y) == true)
				{
					if(turn == player)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	public int whiteCount()
	{
		int whiteCount=0;
		for(int x=0; x<10; x++)
		{
			for(int y=0; y<10; y++)
			{
				if(board[x][y]==WHITE)
				{
					whiteCount++;
				}
			}
		}
		return whiteCount;
	}
	public int blackCount()
	{
		int blackCount=0;
		for(int x=0; x<10; x++)
		{
			for(int y=0; y<10; y++)
			{
				if(board[x][y]==BLACK)
				{
					blackCount++;
				}
			}
		}
		return blackCount;
	}
	public int otherTurn()
	{
		if(turn==WHITE)
		{
			return BLACK;
		}
		else if(turn==BLACK)
		{
			return WHITE;
		}
		return -1;
	}
	public int winner()
	{
		//return gameState;
		if(isFull() == true||canMove(turn)==false && canMove(otherTurn())==false)
		{
			if(whiteCount()>blackCount())
			{
				return WHITE_WINS;
			}
			else if(blackCount()>whiteCount())
			{
				return BLACK_WINS;
			}
			else if(blackCount()==whiteCount())
			{
				return TIE;
			}
		}
			return PLAYING;
	} 
	public int getEmpty()
	{
		return EMPTY;
	}
	public int getWhite()
	{
		return WHITE;
	}
	public int getBlack()
	{
		return BLACK;
	}
	public int getTie()
	{
		return TIE;
	}
	public int getPlayings()
	{
		return PLAYING;
	}
	public boolean isFull()
	{
		if(blackCount()+whiteCount() == 100)
		{
			return true;
		}
		return false;
	}
		
}