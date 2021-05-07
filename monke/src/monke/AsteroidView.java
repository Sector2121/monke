package monke;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AsteroidView implements Drawable{
	private int x;
	private int y;
	private View v;
	private JLabel[] pictures;
	private JLabel label;
	
	AsteroidView(int x, int y, View v) {
		this.x=x;
		this.y=y;
		this.v=v;
		pictures = new JLabel[2];
		pictures[0] = new JLabel();
		pictures[1] = new JLabel();
		pictures[0].setIcon(new ImageIcon("asteroid.png"));	
        pictures[1].setIcon(new ImageIcon("asteroid2.png"));
        label = pictures[0];
	}

	@Override
	public void Draw() {
		label.setBounds(x, y, 50, 50);
		v.add(label);
		
	}
	
	
}
