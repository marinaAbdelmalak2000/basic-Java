import java.applet.Applet;
import java.awt.*;
import java.lang.Thread; 
import java.awt.event.*;


public class BallMoveButton extends Applet implements Runnable{
	
	private Button btnStart;
	private Button btnStop;
	private int x=270,y=500;
	private Thread thread ;
	boolean x_axis;
	boolean y_axis;
	boolean flag = false ;
	
	
	public void init(){
		
		thread = new Thread(this);

		flag = false ;
		
		//start button
		btnStart = new Button("Start");
		StartListener startListener = new StartListener();
		btnStart.addActionListener(startListener);
		add(btnStart);
		
		//stop button
		btnStop = new Button("Stop");
		StopListener stopListener = new StopListener();
		btnStop.addActionListener(stopListener);
		add(btnStop);
		
		
		
		
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
	
	
	class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(flag == false){
				thread.start();
				flag = true ;
			}
			
			
			if(flag == true ){
				thread.resume();
			}
		}
	}
		
		class StopListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			thread.suspend();
			}
		}
}		

