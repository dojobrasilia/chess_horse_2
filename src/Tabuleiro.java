import java.awt.Point;


public class Tabuleiro {
	
	private Point ondeEstou;

	public void visita(Point p) {
		ondeEstou=p;
	}

	public Point[] anda(int n) {
		Point p[] = {new Point()};
		
		int[][] movimentos_validos = 
					 {{1, 2},{2, 1},{1, -2},{2, -1},
					  {-1,2},{-2,1},{-1,-2},{-2,-1}};
		
		for (int i=0 ; i<8 ; i++) {
			int x = ondeEstou.x + movimentos_validos[i][0];
			int y = ondeEstou.y + movimentos_validos[i][1];
			if(x>0 && y>0 && x<9 && y <9) {
				p[0].x = x;
				p[0].y = y;
				break;
			}
		}
		
//		if(ondeEstou.x-1 > 0 && ondeEstou.y-2 > 0){
//			p[0].x = ondeEstou.x-1;
//			p[0].y = ondeEstou.y-2;
//		}else if (ondeEstou.x+1 < 9 && ondeEstou.y+2 < 9){
//			p[0].x = ondeEstou.x+1;
//			p[0].y = ondeEstou.y+2;
//		}else{
//			p[0].x = ondeEstou.x+1;
//			p[0].y = ondeEstou.y-2;
//		}
		return p;
	}

	public Object getOndeEstou() {
		return new Point(3,3);
	}

	
	
	
}
