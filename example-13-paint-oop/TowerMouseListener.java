import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class TowerMouseListener extends MouseMotionAdapter {
	private MainWindow window;

	public TowerMouseListener(MainWindow window) {
		this.window = window;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		window.getTank().turnTower(e.getX(), e.getY());
	}
}
