import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class OneLineDrow extends Applet{
	
	int point_x1=0,point_y1=0;
	int point_x2=0,point_y2=0;

	
	public void init(){
		
		LineListener lineLisener=new LineListener();
		addMouseMotionListener(lineLisener);
		addMouseListener(lineLisener);
		
	}
	
	
	public void paint(Graphics g){
		
		g.drawLine(point_x1,point_y1,point_x2,point_y2);
	}

	class LineListener implements MouseMotionListener, MouseListener {
		
		public void mouseDragged(MouseEvent e){
			
			point_x2=e.getX();
			point_y2 = e.getY();
			
			repaint();
			
		}
		
		public void mouseMoved(MouseEvent e){}
		
		public void mouseClicked(MouseEvent e){}
		
		public void mousePressed(MouseEvent e){
			
			point_x1=e.getX();
			point_y1 = e.getY();
			
			
			
		}

		public void mouseReleased(MouseEvent e){
			point_x2=e.getX();
			point_y2 = e.getY();
			
			repaint();
			
		}
		
		public void mouseEntered(MouseEvent e){}
		
		public void mouseExited(MouseEvent e){}

	}
		
	
}