import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Expert extends Base implements Runnable,KeyListener,MouseMotionListener,MouseListener
{
	int speed,range;
	Bubble b[];
	char c[];
	Game l;
	public Expert(int range,Game l)
	{
		super(range,30,l);
		speed=30;
		this.range=range;
		this.l=l;
	}
	public static void create(int range,Game l)
	{
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Expert s=new Expert(range,l);
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
