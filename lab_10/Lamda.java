import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Lamda extends Applet {
	
	Thread th;
	
	int x=0,y=0;
	int direction_x=1;
	int direction_y=1;
	
	boolean x_axis;
	boolean y_axis;
	
	public void init(){
		
		//th = new Thread(this);
		//th.start();
		new Thread(runable).start();
	}
	
	public void paint(Graphics g){
		
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x,y,50,62);
		
		
	}
	
	Runnable runable = () -> {   // lambda expression
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
      };
	
	
	/*public void run(){
		
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
	}*/
	
	
}

