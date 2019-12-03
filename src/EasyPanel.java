import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EasyPanel extends JPanel implements ActionListener
{
	int width,height;
	Game l;
	JButton lower,upper,digit,all;
	public EasyPanel(Game l)
	{
		this.l=l;
		width=200;
		height=300;
		setLayout(new GridLayout(4,0,0,5));
		setFont(new Font("Curlz MT",Font.BOLD,48));

		setBackground(Color.black);
		lower=new JButton("Lower");
		upper=new JButton("Upper");
		digit=new JButton("Digit");
		all=new JButton("All");

		lower.setFont(new Font("Curlz MT",Font.BOLD,26));
		upper.setFont(new Font("Curlz MT",Font.BOLD,26));
		digit.setFont(new Font("Curlz MT",Font.BOLD,26));
		all.setFont(new Font("Curlz MT",Font.BOLD,26));

		lower.setBackground(Color.white);
		upper.setBackground(Color.white);
		digit.setBackground(Color.white);
		all.setBackground(Color.white);

		lower.setForeground(Color.black);
		upper.setForeground(Color.black);
		digit.setForeground(Color.black);
		all.setForeground(Color.black);

		lower.addActionListener(this);
		upper.addActionListener(this);
		digit.addActionListener(this);
		all.addActionListener(this);

		add(lower);
		add(upper);
		add(digit);
		add(all);

	}
	public void actionPerformed(ActionEvent e)
	{
		setVisible(false);
		JButton b=(JButton)e.getSource();
		if(b==lower)
		Easy.create(97,l);
		else if(b==upper)
		Easy.create(65,l);
		else if(b==digit)
		Easy.create(48,l);
		else
		Easy.create(47,l);

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
}
