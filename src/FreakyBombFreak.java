/*
 *	Freaky Bomb Freak (Hack the North)
 *
 *	Programmed by Gregory Desrosiers
 *
 *	Start Date: September 19, 2015
 *	End Date: September 20, 2015
 *  
 */

// External Resources
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;

public class FreakyBombFreak
{
	// Controllers
	public static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static MediaTracker mediaTracker;
	
	// Program Variables
	public enum Game_Mode {
		MAIN_MENU, GAME_IN_PROGRESS, GAME_OVER, 
	}
	
	public static Game_Mode currentGameMode;
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new GameFrame();
            }
        });
	}
}

class GameFrame extends JFrame
{
	private static final long serialVersionUID = -6480976988801141129L;
	private Thread gameTimerThread;
	private GamePanel panel;
	
	public GameFrame()
	{	
		
		FreakyBombFreak.mediaTracker = new MediaTracker(this);
		
		panel = new GamePanel();
		panel.setPreferredSize(panel.getDimension());
		add(panel);
		addKeyListener(new GameKeyboardListener());
		
		//gameTimerThread = new Thread(new GameRepaintTimer());
		//gameTimerThread.start();
		
		setTitle("Freaky Bomb Freak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = FreakyBombFreak.toolkit.getScreenSize();
		this.setLocation(dim.width/2 - this.getSize().width/2, 
				dim.height/2 - this.getSize().height/2);
		pack();
		setVisible(true);
		
		
		
	}
	
	class GameKeyboardListener extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			if (FreakyBombFreak.currentGameMode == FreakyBombFreak.Game_Mode.MAIN_MENU)
			{
				
			}
			else if (FreakyBombFreak.currentGameMode == FreakyBombFreak.Game_Mode.GAME_IN_PROGRESS)
			{
				
			}
		}
	}
	
	class GameRepaintTimer implements Runnable
	{
		public void run()
		{
			while(true)
			{
				panel.repaint();
				
				try
				{
					Thread.sleep(1000 / 60);
				}
				catch (InterruptedException ex)
				{
					System.err.println("Timer failure");
				}
			}
		}
	}
}

class GamePanel extends JPanel
{
	private static final long serialVersionUID = -4518316019554037729L;

	// Display Parameters
	Font fontFamily = new Font("Times New Roman", 25, Font.PLAIN);

	
	// Array of Barrier Blocks
	// Screen fits 11 on the short sides, 16 on the long sides.
	// Here, we have a game board that has dimensions 21 x 31. Thus we need 100 Wall Sprites.
	SquareSprite[] gameBorderBlocks = new Barrier[100];
	
	// Array of Barrier Blocks
	// The remaining space is 19 x 29, where a barrier brick goes on every odd row except the
	// borders and every odd columns except the borders. That makes it 9 barrier blocks for every
	// compatible odd column, and 14 barrier blocks for every compatible odd row. 9 x 14 = 126.
	SquareSprite[] gameBarrierBlocks = new Barrier[126];
	
	// Array of Floor Blocks
	// The rest is to be covered as floors, sometimes overlapped with brick blocks. There are 450
	// floor blocks to place on the board.
	SquareSprite[] gameFloorBlocks;
	
	// Array of Brick Blocks
	SquareSprite[] gameBrickBlocks;
	
	public GamePanel()
	{
		//sBackground(Color.WHITE);
		setPreferredSize(getDimension());
		
		
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D graphicsObject = (Graphics2D)g;
		
		
		// Set styling
		graphicsObject.setFont(new Font("Consolas Bold", 13, Font.PLAIN).deriveFont(13.0f));
		graphicsObject.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphicsObject.setColor(Color.BLACK);
		
		//graphicsObject.fillRect(0, 0, 100, 100);
		
		/*if (FreakyBombFreak.currentGameMode == FreakyBombFreak.Game_Mode.MAIN_MENU)
		{
			
		}
		else if (FreakyBombFreak.currentGameMode == FreakyBombFreak.Game_Mode.GAME_IN_PROGRESS)*/
		{
			
			// Game Board
			
			
			
			
			
			
			// Game Header
			//graphicsObject.setFont(new Font("Calibri", 15, Font.PLAIN));
			graphicsObject.setColor(Color.BLACK);
			graphicsObject.fillRect(0, 0, 640, 40);
			
			graphicsObject.setColor(Color.WHITE);
			FontMetrics fmObject = graphicsObject.getFontMetrics();
			graphicsObject.drawString("Time: ", 20, 20 - fmObject.getLeading() / 2);
			graphicsObject.drawString(String.valueOf(GameParameters.game_Time_Limit), 75 - fmObject.stringWidth(String.valueOf(GameParameters.game_Time_Limit)), 
					20 - fmObject.getLeading() / 2);
			
			graphicsObject.drawString("Score: ", 500, 20 - fmObject.getLeading() / 2);
			graphicsObject.drawString(String.valueOf(GameParameters.game_Score), 600 - fmObject.stringWidth(String.valueOf(GameParameters.game_Score)), 
					20 - fmObject.getLeading() / 2);
			
			
		
			
		}
	}
	
	/*public Dimension getPreferredSize()
	{
		return new Dimension(640, 480);
	}*/
	
	public Dimension getDimension()
	{
		return new Dimension(640, 480);
	}
}


