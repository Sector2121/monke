package monke;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Options extends JFrame{

	private String[] images = new String[5];
	private String[] players;
	JComboBox<String> imgs;
	
	public Options(){
		images[0] = "Boba-fett";
		images[1] = "Darth Vader";
		images[2] = "Steve";
		images[3] = "Private";
		images[4] = "Sweety Belle";
		
		players = new String[10];
		imgs = new JComboBox<String>(images);
		setSize(600, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setLayout(new GridLayout(3,1));
		JPanel p1 = new JPanel();
		p1.add(imgs);
		this.add(p1);
		
		JLabel l1 = new JLabel("Enter player name");
		JTextField name = new JTextField(15);
		JButton add = new JButton("Add");
		JPanel p2 = new JPanel();
		p2.add(l1);
		p2.add(name);
		p2.add(add);
		this.add(p2);
		
		JLabel l2 = new JLabel("Players: " + players.length);
		JPanel p3 = new JPanel();
		p3.add(l2);
		this.add(p3);
		
		
	}
}
