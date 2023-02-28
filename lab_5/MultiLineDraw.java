import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; 

public class MultiLineDraw extends Applet{
	
	int point_x1=0,point_y1=0;
	int point_x2=0,point_y2=0;
	
	int lineCounter=0;
	
	//Line lines[]=new Line[4];
	ArrayList<Line> lines ;
	Line line;
	
	public void init(){
		
        line= new Line(0,0,0,0);
        lines= new ArrayList<Line>();
		
		LineListener lineLisener=new LineListener();
		addMouseMotionListener(lineLisener);
		addMouseListener(lineLisener);
		
	}
	
	
	public void paint(Graphics g){
		
		for (int i = 0 ; i < lines.size(); i++){
			g.drawLine(lines.get(i).getPintX1(), lines.get(i).getPintY1(), lines.get(i).getPintX2(),lines.get(i).getPintY2());
		}
			
		
	}

	class LineListener implements MouseMotionListener, MouseListener {
		
		int x1=0,y1=0;
		int x2=0,y2=0;
		
		public void mouseDragged(MouseEvent e){
			
			line.setPointX2(e.getX());
			line.setPointy2(e.getY());
			repaint();
			
			/*x2=e.getX();
			y2=e.getY();
			line=new Line(x1,y1,x2,y2);
			lines.add(lineCounter,line);
			
			repaint();*/
			
		}
		
		public void mouseMoved(MouseEvent e){}
		
		public void mouseClicked(MouseEvent e){}
		
		public void mousePressed(MouseEvent e){
			
			//line.setPointX1(e.getX());
			//line.setPointY1(e.getY());
			x1=e.getX();
			y1=e.getY();
			line=new Line(x1,y1,point_x2,point_y2);
			
			lines.add(lineCounter,line);
			
		
		}

		public void mouseReleased(MouseEvent e){
			
			line.setPointX2(e.getX());
			line.setPointy2(e.getY());
			
			//line=new Line(x1,y1,e.getX(),e.getY());
			
			//lines.add(lineCounter,line);
			lineCounter++;
			
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