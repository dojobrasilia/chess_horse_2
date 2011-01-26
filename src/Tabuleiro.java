import java.awt.Point;


public class Tabuleiro {
	
	private Point ondeEstou;

	public void visita(Point p) {
		ondeEstou=p;
	}

	public Point[] anda(int i) {
		Point p[] = {new Point()};
		
		if(ondeEstou.x-1 > 0 && ondeEstou.y-2 > 0){
			p[0].x = ondeEstou.x-1;
			p[0].y = ondeEstou.y-2;
		}else if (ondeEstou.x+1 < 9 && ondeEstou.y+2 < 9){
			p[0].x = ondeEstou.x+1;
			p[0].y = ondeEstou.y+2;
		}else{
			p[0].x = ondeEstou.x+1;
			p[0].y = ondeEstou.y-2;
		}
		return p;
	}

	public Object getOndeEstou() {
		return new Point(3,3);
	}

	
	
	
}
