import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class lamp extends Applet{
	
	public void paint(Graphics g){
		
		setForeground(Color.red);
		Font font = new Font("Elephant",Font.ITALIC,28);  
		g.setFont(font); 
		g.drawString("Lamp :)", 50, 50);  
		
		g.setColor(Color.yellow);
		//g.darker();
		g.fillOval(145,48,280,62);
		g.fillRect(136,465,280,55);
		
		g.fillOval(129,152,43,130);
		g.fillOval(235,130,84,210);
		g.fillOval(385,152,43,130);
		
		g.setColor(Color.black);
		g.drawLine( 145, 78, 76, 283);
		g.drawLine( 424, 78, 469, 279);
		g.drawArc(76,200,393,162,180,180);
		
		g.drawLine( 266, 362,243,465);
		g.drawLine( 290, 362,312,465);
		
		g.drawRect(136,465,280,55);
		
		g.drawOval(145,48,280,62);
		
		g.drawOval(129,152,43,130);
		g.drawOval(235,130,84,210);
	
		g.drawOval(385,152,43,130);
		
		
		
		
		
		
	}
}