package monke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View extends JFrame{
	protected JButton first;
	protected JButton second;
	protected JButton third;
	protected JButton back;
	private JPanel p;
	private GUIView gui;
	
	public View() {
		/*this.setTitle("Game");
		this.setResizable(true);
		this.setVisible(true);
		this.setSize(1900, 800);
		this.setLocation(10, 10);
		this.setContentPane(new JLabel(new ImageIcon("test.png")));
		
		JLabel label = new JLabel();  
        label.setIcon(new ImageIcon("asteroid.png"));
        label.setBounds(50,50,200,40);
        this.add(label);
        
        JButton first = new JButton("faszom");
        first.setBounds(50,50,300,300);
        this.add(first);
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		
		gui = new GUIView(this);
			
		p = new JPanel();
		this.add(p);*/
		this.setTitle("Game");
		this.setContentPane(new JLabel(new ImageIcon("test.png")));
		this.setResizable(false);
		JLabel label = new JLabel();  
        label.setIcon(new ImageIcon("asteroid.png"));
        label.setBounds(400,400,200,200);
        this.add(label);
		JButton kaka = new JButton("faszom");
		kaka.setBounds(50,50,300,300);
        this.add(kaka);
		this.first = new JButton("Back");
		this.second = new JButton("Back");
		this.third = new JButton("Back");
		this.back = new JButton("Back");
		this.first.setBounds(200,200,200,40);
		this.second.setBounds(300,220,200,40);
		this.third.setBounds(300,280,200,40);
		this.back.setBounds(300,460,200,40);
		this.add(this.first);
		this.add(this.second);
		this.add(this.third);
		this.add(this.back);
		this.back.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,700);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	/*public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1900, 1000);
	}*/
	
	public void DrawAll() {}
	
	public void RemoveDrawable(Drawable d) {}
	
	public void AddDrawable(Drawable d) {}
}
