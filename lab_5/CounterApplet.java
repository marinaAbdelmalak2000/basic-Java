
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*; 


public class CounterApplet extends Applet{
	
	private Button incrementBtn;
	private Button decrementBtn;
	private int counter;
	
	public void init(){
		
		counter=0;
		
		// button increment
		incrementBtn =new Button("Increment");
		incrementBtn.addActionListener(new MyButtonListener());
		add(incrementBtn);
		
		//button decrement
		decrementBtn=new Button("decrement");
		decrementBtn.addActionListener(new ActionListener(){  //Anonymous Inner Class
				public void actionPerformed(ActionEvent ev){
						counter-- ;
						repaint() ;
				}
		});
		
		add(decrementBtn);
		
	}
	
	public void paint(Graphics g){
		
		g.drawString("Counter = "+counter,getWidth()/2,getHeight()/2);
		
	}
	
	//Normal inner class button increment listener
	class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			
			counter++ ;
			repaint() ;
		}
		
	}
	
}