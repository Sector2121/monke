package monke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	
	private Game game;
	private GUIView gui;
	private ArrayList<Drawable> dbs;
	
	public View(Game g) {
		game = g;
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
		
		DrawAll();
	}
	
	public Game GetGame() {
		return game;
	}
	
	public GUIView GetGUI() {
		return gui;
	}
	
	public void Win() {
		JLabel win = new JLabel("You won!");
		win.setFont(new Font("Serif", Font.PLAIN, 50));
		win.setForeground(Color.white);
		win.setBounds(800,500,300,50);
		this.add(win);
	}
	
	public void Lose() {
		JLabel lose = new JLabel("You lost!");
		lose.setFont(new Font("Serif", Font.PLAIN, 50));
		lose.setForeground(Color.white);
		lose.setBounds(800,500,300,50);
		this.add(lose);
	}
	
	public void DrawAll() {
		gui.Draw();
		for(Drawable d : dbs) {
			d.Draw();
		}
	}
	
	public void SetPlayer(Settler s) {
		gui.SetPlayer(s);
	}
	
	public void RemoveDrawable(Drawable d) {
		dbs.remove(d);
	}
	
	public void AddDrawable(Drawable d) {
		dbs.add(d);
	}
}
