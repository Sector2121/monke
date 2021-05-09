package monke;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RobotView implements Drawable{
	private int x;
	private int y;
	private View v;
	private JLabel label;
	
	public RobotView(int x, int y, View v) {
		this.x=x;
		this.y=y;
		this.v=v;
		
		label = new JLabel();
		label.setIcon(new ImageIcon("bb8.png"));
	}
	
	@Override
	public void SetCoord(Asteroid a) {
		x = a.GetView().GetX();
		y = a.GetView().GetY();
	}

	@Override
	public void Draw() {
		label.setBounds(x + 20, y - 25, 30, 30);
		v.add(label);
	}
	
	@Override
	public void SetTomb() {
		label.setIcon(new ImageIcon("tombstone.png"));
	}
}
