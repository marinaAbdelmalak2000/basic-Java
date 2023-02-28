import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;

public class limitFrontFormat extends Applet{
	
	 private int getHeight (Font f) {
            FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(f);
            return fm.getHeight();
        }
        private int getWidth (Font f, String s) {
            FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(f);
            return fm.stringWidth(s);
        }
	
	public void paint(Graphics g){
		
		/*g.drawString("Hello World",50,50);
		
		g.drawLine( 40, 60, 150, 60);
		g.drawRect(70, 80, 200, 100);
		g.fillRect(90,100,100,50);
		g.drawOval(150,90,80,90);
		g.setColor(Color.GREEN);
		g.fillOval(150,150,80,90);
		g.setColor(Color.GREEN);
		
		g.drawRect(300,150,200,100);
      g.setColor(Color.yellow);   
      g.fillRect( 300,150, 200, 100 );
      g.setColor(Color.magenta);
      g.drawString("Rectangle",500,150);*/
	  
		g.setColor(Color.GREEN);
		g.drawOval(300,100,80,90);
		g.setColor(Color.MAGENTA);
		g.fillOval(300,200,80,90);
		//setColor(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		
		setForeground(Color.red);
 g.drawString("Foreground color set to red", 50, 50);
		
		
		//font
		
		Font f1 = new Font("Arial",Font.BOLD,18);    
      Font f2 = new Font("Forte",Font.PLAIN,24);    
      Font f3 = new Font("Elephant",Font.ITALIC,28);  
		//g.drawString("Senthil",50,50);    
    
      g.setFont(f1);     
      g.drawString("Velan",50,80);    
    
      g.setFont(f2);     
      g.drawString("Vicky",50,110);    
    
      g.setFont(f3);     
      g.drawString("Vignesh",50,140);
		
		/*String format[] = new String [10]; 
		Toolkit t= Toolkit.getDefaultToolkit();
		String[] s = t.getFontList();
		s.show();
		for (int i = 0; i < s.length; i++)
            format.add(s[i]);*/
		
		String []fonts = Toolkit.getDefaultToolkit().getFontList();
		int x = 0;
        int y = 0;
		for (int i=0;i<fonts.length;i++) {
            Font plain = new Font (fonts[i], Font.PLAIN, 12);
            Font bold = new Font (fonts[i], Font.BOLD, 12);
            Font italic = new Font (fonts[i], Font.ITALIC, 12);
            Font bolditalic = new Font (fonts[i], Font.BOLD | Font.ITALIC, 12);
            g.setFont (plain);
           /* y += getHeight (plain);
            g.drawString (fonts[i] + " PLAIN", x, y);
            g.setFont (bold);
            y += getHeight (bold);
            g.drawString (fonts[i] + " BOLD", x, y);
            g.setFont (italic);
            y += getHeight (italic);
            g.drawString (fonts[i] + " ITALIC", x, y);
            g.setFont (bolditalic);
            y += getHeight (bolditalic);*/
            g.drawString (fonts[i] + " BOLDITALIC", x, y);
        }
		
		
 
		
		
		
		//color.setColor("Red");
		//Toolkit t= Toolkit.getDefaultToolkit();
		//String[] s = t.getFontList();
		
		
	}
}