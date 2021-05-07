package monke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIView implements Drawable{
	private View view;
	private JButton[] buttons;
	private JLabel[] labels;
	private JLabel[] pictures;
	
	public GUIView(View v) {
		view = v;
		
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
		
		labels = new JLabel[8];
		labels[0] = new JLabel(": 1");
		labels[1] = new JLabel(": 2");
		labels[2] = new JLabel(": 0");
		labels[3] = new JLabel(": 3");
		labels[4] = new JLabel("Boba-feta");
		labels[5] = new JLabel("Asteroid: ");
		labels[6] = new JLabel("Resource: ");
		labels[7] = new JLabel("Other creatures: ");
		labels[0].setFont(new Font("Serif", Font.PLAIN, 30));
		labels[1].setFont(new Font("Serif", Font.PLAIN, 30));
		labels[2].setFont(new Font("Serif", Font.PLAIN, 30));
		labels[3].setFont(new Font("Serif", Font.PLAIN, 30));
		labels[4].setFont(new Font("Serif", Font.BOLD, 30));
		labels[5].setFont(new Font("Serif", Font.PLAIN, 30));
		labels[6].setFont(new Font("Serif", Font.PLAIN, 30));
		labels[7].setFont(new Font("Serif", Font.PLAIN, 30));
		labels[0].setForeground(Color.white);
		labels[1].setForeground(Color.white);
		labels[2].setForeground(Color.white);
		labels[3].setForeground(Color.white);
		labels[4].setForeground(Color.white);
		labels[5].setForeground(Color.white);
		labels[6].setForeground(Color.white);
		labels[7].setForeground(Color.white);
		
		String thermo="thermometer1.png";
		pictures = new JLabel[5];
		pictures[0] = new JLabel();
		pictures[1] = new JLabel();
		pictures[2] = new JLabel();
		pictures[3] = new JLabel();
		pictures[4] = new JLabel();
        pictures[0].setIcon(new ImageIcon("iron.png"));	
        pictures[1].setIcon(new ImageIcon("coal.png"));	
        pictures[2].setIcon(new ImageIcon("uranium.png"));	
        pictures[3].setIcon(new ImageIcon("waterice.png"));
        pictures[4].setIcon(new ImageIcon(thermo));
	}
	
	public void Draw() {
		for(int i=0;i<4;i++) {
			pictures[i].setBounds(300+i*120, 700, 100, 50);
			view.add(pictures[i]);
		}
		for(int i=0;i<4;i++) {
			labels[i].setBounds(352+i*120, 700, 100, 50);
			view.add(labels[i]);
		}
		for(int i=0;i<7;i++) {
			buttons[i].setBounds(50+i*120, 780, 100, 50);
			view.add(buttons[i]);
		}
		labels[4].setBounds(50, 700, 200, 50);
		view.add(labels[4]);
		pictures[4].setBounds(775, 835, 200, 200);
		view.add(pictures[4]);
		int n = 0;
		for(int i=5;i<8;i++) {
			labels[i].setBounds(50, 850+n*50, 700, 50);
			n++;
			view.add(labels[i]);
		}
	}
}
