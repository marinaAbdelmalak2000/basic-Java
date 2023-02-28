import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class DateTimeApp extends Applet implements Runnable{
	
	Thread th;
	
	public void init(){
		
		th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g){
		
		Date d = new Date();
		
		g.drawString(d.toString(), 200, 270);
		
	}
	public void run(){
		
		while(true){
			
			try{
				repaint();
				Thread.sleep(1000); //you’ll need to catch an exception here
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
		}
	}
}