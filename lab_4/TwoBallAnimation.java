import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class TwoBallAnimation extends Applet implements Runnable{
	
	Thread th;
	
	int x1=0,y1=0,x2=80,y2=80,r1=50,r2=50;
	
	
	boolean x1_direction, x2_direction;
	boolean y1_direction, y2_direction;
	
	public void init(){
		
		th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g){
		
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x1,y1,r1,62);
		g.setColor(Color.GRAY);
		g.fillOval(x2,y2,r2,62);
		
		
	}
	public void run(){
		
		while(true){
			
			try{
						repaint();
						Thread.sleep(100);
					
					//first ball
						if(x1<0){
							
							x1_direction=true;
						}
						if(x1 > getWidth()-80){
							x1_direction=false;
						}
						if(x1_direction){
							x1=x1+20;
						}
						else{
							x1=x1-20;
						}
						
						if(y1<0)
							y1_direction=true;
						
						if(y1>getHeight()-80)
							y1_direction=false;
						if(y1_direction)
							y1=y1+20;
						else
							y1=y1-20;
						
					//second ball
						if(x2<0){
							
							x2_direction=true;
						}
						if(x2 > getWidth()-80){
							x2_direction=false;
						}
						if(x2_direction){
							x2=x2+5;
						}
						else{
							x2=x2-5;
						}
						
						if(y2<0)
							y2_direction=true;
						
						if(y2>getHeight()-80)
							y2_direction=false;
						if(y2_direction)
							y2=y2+5;
						else
							y2=y2-5;
						
					//collision:
					//case 1
					int xr1=x1+r1;
					if((xr1-10)==x2){
						x1_direction=true;
						x2_direction=false;
					}
					if(x1_direction){
						x1=x1+5;
					}
					else{
						x1=x1-5;
					}
					if(x2_direction){
						x2=x2+5;
					}
					else{
						x2=x2-5;
					}
					
					//case 2:
					int xr2=x2+r2;
					if((xr2-10)==x1){
						x2_direction=true;
						x1_direction=false;
					}
					if(x2_direction){
						x2=x2+5;
					}
					else{
						x2=x2-5;
					}
					if(x1_direction){
						x1=x1+5;
					}
					else{
						x1=x1-5;
					}
					
					
					
					//case3:
					int yr1=y1+r1;
					if((yr1+10)==y2){
						y1_direction=true;
						y2_direction=false;
					}
					if(y1_direction)
						y1=y1+5;
					else
						y1=y1-5;
					if(y2_direction)
						y2=y2+5;
					else
						y2=y2-5;
					
					//case 4:
					int yr2=y2+r2;
					if((yr2+10)==y1){
						y2_direction=true;
						y1_direction=false;
					}
					if(y2_direction)
						y2=y2+5;
					else
						y2=y2-5;
					if(y1_direction)
						y1=y1+5;
					else
						y1=y1-5;
					
					
			}catch(InterruptedException ie){
					ie.printStackTrace();
				
			}	
		}
	}
}

