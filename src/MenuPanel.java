import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuPanel extends JPanel implements ActionListener
{
	int width,height;
	Game l;
	JButton easy,medium,hard,exit;
	public MenuPanel(Game l)
	{
		this.l=l;
		width=250;
		height=300;
		setLayout(new GridLayout(4,0,0,10));
		setFont(new Font("Curlz MT",Font.BOLD,30));

		setBackground(Color.black);
		easy=new JButton("easy");
		medium=new JButton("medium");
		hard=new JButton("hard");
		exit=new JButton("exit");

		easy.setFont(new Font("Curlz MT",Font.BOLD,30));
		medium.setFont(new Font("Curlz MT",Font.BOLD,30));
		hard.setFont(new Font("Curlz MT",Font.BOLD,30));
		exit.setFont(new Font("Curlz MT",Font.BOLD,30));

		easy.setBackground(Color.white);
		medium.setBackground(Color.white);
		hard.setBackground(Color.white);
		exit.setBackground(Color.white);

		easy.setForeground(Color.black);
		medium.setForeground(Color.black);
		hard.setForeground(Color.black);
		exit.setForeground(Color.black);

		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		exit.addActionListener(this);

		add(easy);
		add(medium);
		add(hard);
		add(exit);

	}
	public void actionPerformed(ActionEvent e)
	{
		JButton b=(JButton)e.getSource();
		if(b==easy)
		{
			setVisible(false);
		}
		else if(b==medium)
		{
			Medium.create(47,l);
		}
		else if(b==hard)
			Expert.create(47,l);
		else
			Game.f.setVisible(false);
	
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
