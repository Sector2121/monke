package monke;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIView extends JFrame implements Drawable{
	private View view;
	private JPanel p;
	
	public GUIView(View v) {
		view = v;
		this.setTitle("Player");
		this.setResizable(true);
		this.setVisible(true);
		this.setSize(1900, 200);
		this.setLocation(10, 820);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 1900, 200);
	}
	
	public void Draw() {}
}
