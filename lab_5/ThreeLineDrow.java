import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class ThreeLineDrow extends Applet{
	
	int point_x1=0,point_y1=0;
	int point_x2=0,point_y2=0;
	
	int lineCounter=0;
	
	Line lines[];
	Line line;
	
	public void init(){
		
		lines=new Line[3];
		for (int i = 0; i <lines.length; i++) {
            lines[i] = new Line();
        }
		
		LineListener lineLisener=new LineListener();
		addMouseMotionListener(lineLisener);
		addMouseListener(lineLisener);
		
	}
	
	
	public void paint(Graphics g){
		
		for(int i=0;i<lines.length;i++){
			g.drawLine(lines[i].getPintX1(), lines[i].getPintY1(), lines[i].getPintX2(), lines[i].getPintY2());
		}
			/*for(int i=0;i<3;i++){
				g.drawLine(line.getPintX1(),line.getPintY1(),line.getPintX2(),line.getPintY2());
			}*/
		
	}

	class LineListener implements MouseMotionListener, MouseListener {
		
		
		public void mouseDragged(MouseEvent e){
			
			/*line.setPointX2(e.getX());
			line.setPointy2(e.getY());
			repaint();*/
			
			
			lines[lineCounter].setPointX2(e.getX());
			lines[lineCounter].setPointy2(e.getY());
			repaint();
			
		}
		
		public void mouseMoved(MouseEvent e){}
		
		public void mouseClicked(MouseEvent e){}
		
		public void mousePressed(MouseEvent e){
			
			
			lines[lineCounter].setPointX1(e.getX());
			lines[lineCounter].setPointY1(e.getY());
			
			//line.setPointX1(e.getX());
			//line.setPointY1(e.getY());
		
		}

		public void mouseReleased(MouseEvent e){
			
			/*line.setPointX2(e.getX());
			line.setPointy2(e.getY());
		
			repaint();*/
			
				if (lineCounter != lines.length -1) {

					lines[lineCounter].setPointX2(e.getX());
					lines[lineCounter].setPointy2(e.getY());
					lineCounter++;

				}
			
			repaint();

			
		}
		
		public void mouseEntered(MouseEvent e){}
		
		public void mouseExited(MouseEvent e){}

	}
		
	
}

class Line{
	
	private int linePointX1,linePointY1;
	private int linePointX2,linePointY2;
	
	Line(){
		
		linePointX1=0;
		linePointX2=0;
		linePointY1=0;
		linePointY2=0;
		
	}
	
	Line(int linePointX1,int linePointY1,int linePointX2,int linePointY2){
		
		this.linePointX1=linePointX1;
		this.linePointY1=linePointY1;
		this.linePointX2=linePointX2;
		this.linePointY2=linePointY2;
		
	}
	
	public void setPointX1(int x1){
		linePointX1=x1;
	}
	public void setPointY1(int y1){
		linePointY1=y1;
	}
	public void setPointX2(int x2){
		linePointX2=x2;
	}
	public void setPointy2(int y2){
		linePointY2=y2;
	}
	
	public int getPintX1(){
		return linePointX1;
	}
	public int getPintY1(){
		return linePointY1;
	}
	public int getPintX2(){
		return linePointX2;
	}
	public int getPintY2(){
		return linePointY2;
	}
	
	public void display(){
      System.out.println("x1: "+this.linePointX1);
      System.out.println("y1: "+this.linePointY1);
      System.out.println("x2: "+this.linePointX2);
	  System.out.println("y2: "+this.linePointY2);
   }
	
}