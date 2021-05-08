package monke;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TeleportView implements Drawable {

	private int x;
	private int y;
	private View v;
	private JLabel label;
	
	public TeleportView(int x, int y, View v) {
		this.x=x;
		this.y=y;
		this.v=v;
		label = new JLabel();
		label.setIcon(new ImageIcon("teleport.png"));
	}
	
	@Override
	public void Draw() {
		label.setBounds(x + 10, y - 10, 30, 30);
		v.add(label);
	}

	@Override
	public void SetCoord(Asteroid a) {
		x = a.GetView().GetX();
		y = a.GetView().GetY();
	}

}
