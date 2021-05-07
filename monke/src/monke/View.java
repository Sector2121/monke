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
import java.util.ArrayList;

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
	private ArrayList<Drawable> dbs;
	
	public View() {
		dbs = new ArrayList<Drawable>();
		gui = new GUIView(this);
		this.setTitle("Game");
		this.setContentPane(new JLabel(new ImageIcon("Background.png")));
		this.setResizable(false);
		JLabel label = new JLabel();  
        label.setIcon(new ImageIcon("private.png"));
        label.setBounds(800,800,400,400);
        this.add(label);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setLayout(null);
		this.setVisible(true);
		gui.Draw();
		DrawAll();
	}
	
	public void DrawAll() {
		
	}
	
	public void RemoveDrawable(Drawable d) {}
	
	public void AddDrawable(Drawable d) {
		dbs.add(d);
	}
}
