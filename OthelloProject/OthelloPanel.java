import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

public class OthelloPanel extends JPanel implements MouseListener,KeyListener
{
	public OthelloBoard game;
	public boolean oneTurn;
	public OthelloPanel()
	{
		super();
		setSize(600,600);
		addMouseListener(this);
        addKeyListener(this);
        game = new OthelloBoard();
        oneTurn = false;
	}
	public void paint(Graphics g)
	{
		/*g.setColor(Color.BLUE);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(new Color(139,69,19));
		g.fillRect(0,500,getWidth(),100);
		g.setColor(Color.BLACK);
		for(int x = 50;x <= 450;x+=50)
		{
			g.drawLine(x,0,x,500);
		}
		for(int x = 50;x <= 450;x+=50)
		{
			g.drawLine(0,x,500,x);
		}*/
		g.setColor(Color.BLUE);
        g.fillRect(0,0,getWidth(),getHeight());
        
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,getWidth(),30);
        g.setColor(new Color(218,112,214));
        String str = "Click N to reset game";
        g.drawString(str,300,20);
        int possible=0;
        
        for(int y=0;y<game.getBoard().length;y++)
        {
            for(int x=0;x<game.getBoard()[0].length;x++)
            {
                g.setColor(Color.YELLOW);
                g.drawRect(x*50,y*50 +30,50,50);
                if(game.getBoard()[y][x]==game.getEmpty() && game.isValidMove(y,x))
                {
                    possible++;
                    if(game.getTurn()==game.getWhite()) {
                        g.setColor(Color.WHITE);
                    }
                    if(game.getTurn()==game.getBlack()) {
                        g.setColor(Color.BLACK);
                    }

                    g.fillOval(x*50+20,y*50+20+30,15,15);
                }
                if(game.getBoard()[y][x] == game.getWhite())
                {
                   
                    g.setColor(Color.WHITE);
                    g.fillOval(x*50+10,y*50+10+30,30,30);
                }
                else if(game.getBoard()[y][x] == game.getBlack())
                {
                   
                    g.setColor(Color.BLACK);
                    g.fillOval(x*50+10,y*50+10+30,30,30);
                }
            }
        }

        if(game.winner()!=game.getPlayings())
        {
            oneTurn=false;
			Font f = new Font("Times New Roman", Font.BOLD, 32);
			g.setColor(Color.YELLOW);
            if(game.blackCount()==game.whiteCount()) 
            {
                g.drawString("Tied game", 200, 20);
            }
            if(game.whiteCount()>game.blackCount()) 
            {
                g.drawString("WHITE WINS!", 200, 20);
            }
            if(game.blackCount()>game.whiteCount()) 
            {
                g.drawString("BLACK WINS!", 200, 20);
            }
        }
        else if(oneTurn && possible!=0)
        {
            oneTurn=false;
        }
       else if(possible==0)
        {
            oneTurn=true;
            game.changeTurn(game.getTurn());
        }


        g.setColor(Color.WHITE);
        g.drawString("White: "+game.whiteCount() , 540,580);
        g.drawString("Black: "+game.blackCount() , 20,580);
        if(game.winner()==game.getPlayings()) {
            if (game.getTurn() == game.getWhite())
                g.drawString("Turn: White", 200, 580);
            else if (game.getTurn() == game.getBlack())
                g.drawString("Turn: Black", 200, 580);
        }
        /*if(game.winner()==game.getTie()) {
        	System.out.print("aa");
            g.drawString("TIE!", 100, 40);
        }
        if(game.winner()==game.WHITE_WINS) {
        	System.out.print("bb");
            g.drawString("WHITE WINS!", 100, 40);
        }
        if(game.winner()==game.BLACK_WINS) {
        	System.out.print("cc");
            g.drawString("BLACK WINS!", 100, 40);
        }*/

	}
	public void mousePressed(MouseEvent e)
	{
		int x=e.getX()/50;
    	int y=(e.getY()-30)/50;
    	System.out.println("turn: "+game.getTurn());
        if(e.getButton()==e.BUTTON1&& game.winner()==game.getPlayings()) 
        {
        	System.out.println("set spot");
            game.setSpot(x,y);
            
        }
        repaint();
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseExited(MouseEvent e)
	{
		
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	public void keyPressed(KeyEvent e)
	{
		char key = e.getKeyChar();
        if( key=='n')
        {
            game.reset();
        }
        repaint();
	}
	public void keyReleased(KeyEvent e)
	{
		
	}
	public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
}