import java.awt.*;
import javax.swing.*;
public class Bubble
{
	
	int x,y,dx,dy,r=40;
	Image i;
	boolean b;
	JPanel a;
	String ch;
	boolean flg;
	Color c;
	public Bubble(Color c,int x,int y,Image i,int dx,int dy,String ch,JPanel s)
	{
		flg=true;
		this.c=c;
		this.x=x;
		this.y=y;	
		this.ch=ch;
		this.i=i;
		this.dx=dx;
		this.dy=dy;
		
		a=s;
		b=true;
	
	}
	
	public void update()
	{
		move();
	}

	public void move()
	{
		if((x-r)<0||x+r>900)
			dx=-dx;
		if((y+r)>700||y<0)
			dy=-dy;
		x+=dx;
		y+=dy;
		/*if(x-r<0||x+r>900)
			dx=-dx;*/
		//if(y+r>400)
		//	dy=-dy;
		//x+=dx;
		//y+=dy;
	}
	public void paint(Graphics g)
	{
		g.setFont(new Font("Curlz MT",Font.BOLD,36));
		g.setColor(c);
		
		g.drawImage(i,x-r,y-r,r*2,r*2,a);
		if(flg)
		g.drawString(ch,x-10,y);
		
	}
	
}
