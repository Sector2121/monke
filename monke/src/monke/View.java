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
		gui = new GUIView(this);
		this.setTitle("Game");
		this.setContentPane(new JLabel(new ImageIcon("Background.png")));
		this.setResizable(false);
		JLabel label = new JLabel();  
        label.setIcon(new ImageIcon("private.png"));
        label.setBounds(800,800,400,400);
        this.add(label);
        /*JLabel valami = new JLabel();
        valami.setIcon(new ImageIcon("cyan.png"));
        valami.setBounds(0,700,900,380);
        this.add(valami);*/
		/*JButton kaka = new JButton("faszom");
		kaka.setBounds(50,50,300,300);
        this.add(kaka);
		his.first = new JButton("Back");
		this.second = new JButton("Back");
		this.third = new JButton("Back");
		this.back = new JButton("Back");
		this.first.setBounds(150,150,50,50);
		this.second.setBounds(300,220,200,40);
		this.third.setBounds(300,280,200,40);
		this.back.setBounds(300,460,200,40);
		this.add(this.first);
		this.add(this.second);
		this.add(this.third);
		this.add(this.back);*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setLayout(null);
		this.setVisible(true);
		gui.Draw();
	}
	
	public void DrawAll() {}
	
	public void RemoveDrawable(Drawable d) {}
	
	public void AddDrawable(Drawable d) {}
}
