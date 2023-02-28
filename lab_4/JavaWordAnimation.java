import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class JavaWordAnimation extends Applet implements Runnable{
	
	Thread th;
	
	int x=0,y=30;
	
	public void init(){
		
		th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g){
		
		
		setForeground(Color.red);
		Font font = new Font("Elephant",Font.ITALIC,28);  
		g.setFont(font); 
		
		
		g.drawString("Java World", x, y);  
		
		
	}
	public void run(){
		
		while(true){
			
			try{
				
				x=x+30;
				
				if(x<getWidth()-200){
					repaint();
					
					Thread.sleep(300); //you’ll need to catch an exception here
				}
			
				else{
					x=0;
					y=y+30;
				}
					
				}catch(InterruptedException ie){
					ie.printStackTrace();
				
				}
		}
	}
}

