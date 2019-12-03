import javax.swing.*;
import java.awt.*;

public class Game extends JPanel 
{
	static int width,height;
	JLabel con,head;
	static JFrame f;

	MenuPanel mp;
	EasyPanel ep;
	public Game()
	{
		setBackground(Color.black);
		width=900;
		height=550;
		setSize(width,height);
		con=new JLabel(creatImage("images/wall2.png"));
		add(con);
		con.setLayout(null);

		head=new JLabel("Welcome To Game");
		head.setFont(new Font("Curlz MT",Font.BOLD,48));
		head.setForeground(Color.white);
		head.setBounds(250,20,500,100);
		con.add(head);

		mp=new MenuPanel(this);
		mp.setBounds(320,140,mp.width,mp.height);
		con.add(mp);

		ep=new EasyPanel(this);
		ep.setBounds(320,140,ep.width,ep.height);
		con.add(ep);

	}
	public static void create()
	{
		f=new JFrame("Bubble Game");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Game());
		
		f.setSize(width,height);
		f.setVisible(true);
	}
	public static void main(String[] args) 
	{
		create();
	}
	public ImageIcon creatImage(String path)
	{
		java.net.URL url=Game.class.getResource(path);
		return new ImageIcon(url);
	}
}
