import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Easy extends Base implements Runnable,KeyListener,MouseMotionListener,MouseListener
{
	int speed,range;
	Bubble b[];
	char c[];
	Game l;
	static JFrame f;
	public Easy(int range,Game l)
	{
		super(range,100,l);
		speed=60;
		this.range=range;
		this.l=l;
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		
	}
	public static void create(int range,Game l)
	{
		f=new JFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Easy s=new Easy(range,l);
		f.add(s);
		f.addKeyListener(s);
		f.addMouseListener(s);
		f.addMouseMotionListener(s);
		f.setSize(1050,700);
		f.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
	public void keyTyped(KeyEvent e){
		super.keyTyped(e);
	}
	public void keyPressed(KeyEvent e)
	{
	}
	public void keyReleased(KeyEvent e){}
	public void mouseDragged(MouseEvent me){}
	public void mouseMoved(MouseEvent e)
	{
		super.mouseMoved(e);
	}

	public void mouseClicked(MouseEvent me)
	{
		if(score>sclim)
		{
			mouseIn=false;
			f.setVisible(false);
			Medium.create(47,l);
			
		}
		super.mouseClicked(me);
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me)
	{}
	public void mousePressed(MouseEvent me)
	{}
	public void mouseReleased(MouseEvent me)
	{}
}
