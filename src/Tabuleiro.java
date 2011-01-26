import java.awt.Point;


public class Tabuleiro {
	
	private Point ondeEstou;

	public void visita(Point p) {
		ondeEstou=p;
	}

	public Point[] anda(int i) {
		Point p[] = null;
		if(ondeEstou.x-1>0 && ondeEstou.y-2 > 0)
			p = new Point[] {new Point(ondeEstou.x-1,ondeEstou.y-2)};
		else {
			p = new Point[] {new Point(ondeEstou.x+1,ondeEstou.y+2)};
		}
		return p;
	}

	public Object getOndeEstou() {
		return new Point(3,3);
	}

	
	
	
}
