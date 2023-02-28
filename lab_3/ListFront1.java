import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;
public class ListFront1 extends Applet{
	
	public void paint(Graphics g){
		
		//g.drawString("Hello World",50,50);
		
		int x=20;
		int y=20;
		
		String []fonts = Toolkit.getDefaultToolkit().getFontList();
		Font plain;
		for (int i=0;i<fonts.length;i++) {
			
			plain = new Font (fonts[i], Font.PLAIN, 12);
			g.setFont (plain);
			g.drawString(fonts[i],x,y);
			y=y+30;
			
		}
	}
	
}