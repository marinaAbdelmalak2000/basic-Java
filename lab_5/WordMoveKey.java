import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*; 
import java.awt.Font;

public class WordMoveKey extends Applet{
	
	int x=300,y=300;
	
	public void init(){
		
		WordKeyListener wordLisener=new WordKeyListener();
		addKeyListener(wordLisener);
		
	}
	
	public void paint(Graphics g){
		
		setForeground(Color.black);
		Font font = new Font("Elephant",Font.ITALIC,20);  
		g.setFont(font); 
		g.drawString("java",x,y);
		
	}
	
   class WordKeyListener implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent e){
			
			switch (e.getKeyCode()) {
					
				case KeyEvent.VK_UP :
					
					y=y-100;
					break;
					
				case KeyEvent.VK_DOWN :
					
					y=y+100;
					break;
					
				case KeyEvent.VK_LEFT:
					
					x=x-100;
					break;
					
				case KeyEvent.VK_RIGHT:
				
					
					x=x+100;
					break;		
				
			}
			repaint();
			
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			return;
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			return;
		}
	
	}
	
}