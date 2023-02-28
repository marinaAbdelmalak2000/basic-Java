import java.applet.Applet;
import java.awt.*;
import java.lang.Thread; 
import java.awt.event.*;


public class BallDrag extends Applet implements Runnable{
	
	
	private int x=270,y=500;
	private Thread thread ;
	boolean x_axis;
	boolean y_axis;
	
	
	
	public void init(){
		
		MouseListener ballDrag=new MouseListener();
		addMouseMotionListener(ballDrag);

		
	}
	
	public void paint(Graphics g){
		
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x,y,50,62);
		
		
	}
	
	public void run() {
		
		while(true){
			
			try{
				repaint();
				Thread.sleep(100);
				if(x<0){
							
							x_axis=true;
						}
						if(x > getWidth()-80){
							x_axis=false;
						}
						if(x_axis){
							x=x+20;
						}
						else{
							x=x-20;
						}
						
						if(y<0)
							y_axis=true;
						
						if(y>getHeight()-80)
							y_axis=false;
						if(y_axis)
							y=y+20;
						else
							y=y-20;
			}catch(InterruptedException ie){
				ie.printStackTrace();
				
			}
		}		
	}
	
	
	class MouseListener implements MouseMotionListener {
		
		public void mouseDragged(MouseEvent e){
			
			x = e.getX();
			y = e.getY();
			repaint();
			
		}
		
		public void mouseMoved(MouseEvent e){
			
			
		}

	}
		
		
}		

