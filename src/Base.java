import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Base extends JPanel implements Runnable,KeyListener
{
	int speed;
	int limit=50;
	int sclim=100;
	int score;
	Bubble b[],out;
	char ch[];
	int range;
	Random r;
	Game l;

	boolean gameOver,mouseIn;
	boolean flg,alOvr;
	Thread t;
	int k,cnt;
	Image ii,bub,win,sp,lose,bak,star;
	Graphics doubleG;
	Base(int range,int speed,Game l)
	{
		cnt=0;
		bub=creatImage("images/b5.png").getImage();
		limit=50;
		score=0;
		gameOver=false;
		mouseIn=false;
		/*win=creatImage("images/anim5.gif").getImage();
		sp=creatImage("images/anim8.gif").getImage();
		lose=creatImage("images/anim7.gif").getImage();*/
		star=creatImage("images/star.gif").getImage();
		
		if(this instanceof Easy)
		{
			bak=creatImage("images/easy.png").getImage();
			
			limit=10;
			
		}
		else if(this instanceof Medium)
		{
			limit=15;
			bak=creatImage("images/medium.png").getImage();

			r=new Random();
			out=new Bubble(Color.white,r.nextInt(850),700-50,bub,10,10,""+(char)(r.nextInt(10)+48),this);
			
			
		}
		else
		{
			bak=creatImage("images/hard.png").getImage();
			limit=20;
		}
		
		
		t=new Thread(this);
		flg=true;
		this.l=l;
		this.range=range;
		this.speed=speed;
		setSize(l.getWidth(),l.getHeight());
		init();
		t.start();
	}
	public void init()
	{
		k=1;
		cnt=0;
		ch=new char[10];
		b=new Bubble[10];
		for(int i=0;i<b.length;i++)
		{
			
			r=new Random();
			if(!(this instanceof Easy))
			{
				bub=creatImage("images/color/"+(r.nextInt(7)+1)+"t.png").getImage();
			}
			if(range==48)
			{
				ch[i]=(char)(r.nextInt(10)+range);
			}
			else if(range==47)
			{
				ch[i]=(char)(r.nextInt(75)+range);
			}
			else
				ch[i]=(char)(r.nextInt(26)+range);
			if(this instanceof Easy)
			b[i]=new Bubble(Color.white,100+r.nextInt(300),100+r.nextInt(300),bub,10,10,""+ch[i],this);
			else if(this instanceof Medium)
			b[i]=new Bubble(Color.black,r.nextInt(850),700-50,bub,0,-10,""+ch[i],this);
			else
			b[i]=new Bubble(Color.black,r.nextInt(850),700-100,bub,0,-10,""+ch[i],this);
		}
	}
	public void run()
	{
		while(flg)
		{
			repaint();
			if(limit==0)
				gameOver=true;
			
			for(int i=0;i<k;i++)
			{
				
				if(b[i]!=null)
				{
					if(b[i].flg==false&&(b[i].y)<0)
					{
						System.out.println("lkkdfj");
						
						b[i]=null;
					}
					else if(b[i].flg&&(b[i].y)<0)
					{
						limit--;
						b[i]=null;
					}
					else
						b[i].update();
				}

			}
			if(out!=null)
			{
				out.update();
				if(out.y<0)
				out=new Bubble(Color.white,r.nextInt(850),700-50,bub,10,10,""+(char)(r.nextInt(10)+48),this);
			}
			

			alOvr=true;	
			for(int i=0;i<b.length;i++)
			{

				if(b[i]!=null&&b[i].flg!=false)
				{
					alOvr=false;
				}
			}
			if(alOvr&&!gameOver)
			{	
				init();
			}
			cnt++;
			if(cnt>20)
			{
				cnt=0;
				k++;
				if(k>10)
					k=10;
			}
			
			try
			{
				
				Thread.sleep(speed);
			}
			catch (Exception e)
			{
			}
		}
	}
	public void update(Graphics g)
	{
		if(ii==null)
		{
			ii=createImage(this.getSize().width,this.getSize().height);
			doubleG=ii.getGraphics();
		}

		doubleG.setColor(getBackground());
		doubleG.fillRect(0,0,getSize().width,getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		g.drawImage(ii,0,0,this);
	}
	public void paint(Graphics g)
	{
		
		//g.setColor(Color.white);					
		//g.drawString(""+score,getWidth()-100,50);//score is not repaint again use statement after drawImage(bak)
		
		if(bak!=null)
			g.drawImage(bak,0,0,getWidth(),700,this);
		for(int i=0;i<k;i++)
		{
			if(b[i]!=null)
			b[i].paint(g);
		}
		if(out!=null)
		out.paint(g);
		g.setFont(new Font("Forte",Font.BOLD,30));
		g.drawImage(star,getWidth()-100,10,this);
		g.setColor(Color.white);
		if(this instanceof Expert)
			g.setColor(Color.blue);
		g.drawString("score:",getWidth()-100,100);
		g.drawString(""+score,getWidth()-100,150);
		g.setColor(Color.white);
		g.drawLine(getWidth()-150,0,getWidth()-150,getHeight());
		g.setColor(Color.red);
		g.drawString("chance:",getWidth()-100,200);
		g.drawString(""+limit,getWidth()-100,250);

		if(gameOver)
		{
			if(this instanceof Expert||(score<=sclim))
			{
				for(int i=0;i<b.length;i++)
					b[i]=null;
				out=null;
				g.setColor(Color.black);
				g.drawImage(lose,160,250,100,150,this);
				g.drawString("GAME OVER",300-2,300-2);
				g.setColor(Color.blue);

				g.drawString("GAME OVER",300,300);
				g.drawRect(290,320,210,40);
				if(mouseIn)
				{
					g.setColor(Color.red);
					g.drawString("Play Again?",310,350);
				}
				else
				{
					g.setColor(Color.white);
					g.drawString("Play Again?",310,350);
				}
			}
		}
		if(score>sclim&&!(this instanceof Expert))
		{

			for(int i=0;i<b.length;i++)
			{
				gameOver=true;
				b[i]=null;
			}
			out=null;
			
			g.drawImage(win,200,250,100,150,this);
			//g.drawImage(sp,getWidth()-200,20,100,100,this);
			//g.drawImage(sp,0,0,getWidth()-100,getHeight(),this);
			g.drawString("Well Done!!",300-2,300-2);
			g.drawRect(290,320,210,40);
			if(mouseIn)
			{
				g.setColor(Color.red);
				g.drawString("next stage?",310,350);
			}
			else
			{
				g.setColor(Color.white);
				g.drawString("next stage?",310,350);
			}
		}
		
	}
	public ImageIcon creatImage(String path)
	{
		java.net.URL url=Game.class.getResource(path);
		return new ImageIcon(url);
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
	public void keyTyped(KeyEvent e){
		char c=e.getKeyChar();
		if(c!=KeyEvent.CHAR_UNDEFINED)
		{
			for(int l=0;l<k;l++)
			{
				if(ch[l]==c&&ch[l]!=0)
				{
					ch[l]=0;

					if(b[l]!=null)
					{
						b[l].i=creatImage("images/anim1.gif").getImage();
						b[l].flg=false;
					}
					score+=10;
				}
			}
			if(out!=null&&c==out.ch.charAt(0))
			{
				out.i=creatImage("images/anim11.gif").getImage();
				out.flg=false;
				score=0;
			}
		}
	}
	public void keyPressed(KeyEvent e)
	{
	}
	public void keyReleased(KeyEvent e){}
	public void mouseMoved(MouseEvent e)
	{
		
		if(e.getX()>290&&e.getX()<400)
		{
			if(e.getY()>320&&e.getY()<360)
				mouseIn=true;
		}
		else
			mouseIn=false;
		/*if(e.getX()<290||e.getX()>400)
			mouseIn=false;
		if(e.getY()>320||e.getY()<360)
			mouseIn=false;*/
	}
	public void mouseClicked(MouseEvent me)
	{

		System.out.println(sclim+" score:"+score);
		if(mouseIn&&score<=sclim)
		{

			mouseIn=false;
			score=0;
			gameOver=false;
			limit=20;
			init();
			
		}
	}

}
