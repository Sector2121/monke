package monke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JFrame{
	private JPanel p;
	private GUIView gui;
	
	public View() {
		this.setTitle("Game");
		this.setResizable(true);
		this.setVisible(true);
		this.setSize(1900, 800);
		this.setLocation(10, 10);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		
		gui = new GUIView(this);
			
		p = new JPanel();
		this.add(p);
		JButton move = new JButton("Move");
		//move.setBounds(50, 850, 150, 100);
		move.setLocation(new Point(50, 850));
		p.add(move);
		
	}
	
	public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1900, 1000);
	}
	
	public void DrawAll() {}
	
	public void RemoveDrawable(Drawable d) {}
	
	public void AddDrawable(Drawable d) {}
}
