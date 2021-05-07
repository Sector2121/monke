package monke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIView extends JFrame implements Drawable{
	private View view;
	private JPanel[] p;
	private JButton[] buttons;
	JLabel[] labels;
	
	public GUIView(View v) {
		view = v;
		this.setTitle("Player's turn");
		this.setResizable(true);
		this.setVisible(true);
		this.setSize(1900, 200);
		this.setLocation(10, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(5, 1));
		
		Init();  
	}
	
	public void Init() {
		buttons = new JButton[7];
		buttons[0] = new JButton("Move");
		buttons[1] = new JButton("Drill");
		buttons[2] = new JButton("Mine");
		buttons[3] = new JButton("Replace");
		buttons[4] = new JButton("Build");
		buttons[5] = new JButton("Skip");
		buttons[6] = new JButton("Give up");
		
		p = new JPanel[5];
		for(int i=0;i<5;i++) {
			p[i] = new JPanel();
			this.add(p[i]);
		}
		
		for(int i=0;i<7;i++) {
			p[1].add(buttons[i]);
		}
		
		labels = new JLabel[5];
		labels[0] = new JLabel("Boba-feta                                               ");
		labels[1] = new JLabel("                 : 1");
		labels[2] = new JLabel("                 : 2");
		labels[3] = new JLabel("                 : 0");
		labels[4] = new JLabel("                 : 3");
		
		for(int i=0;i<5;i++) {
			p[0].add(labels[i]);
		}
	}
	
	/*public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 1900, 200);
	}*/
	
	public void Draw() {}
}
