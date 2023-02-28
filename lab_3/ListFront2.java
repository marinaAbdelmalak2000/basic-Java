import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
public class ListFront2 extends Applet{
	
	public void paint(Graphics g){
		
		//g.drawString("Hello World",50,50);
		
		int x=20;
		int y=20;
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		String []fonts = ge.getAvailableFontFamilyNames();
		Font plain;
		for (int i=0;i<fonts.length;i++) {
			
			plain = new Font (fonts[i], Font.PLAIN, 12);
			g.setFont (plain);
			g.drawString(fonts[i],x,y);
			y=y+30;
			
		}
	}
	
}