import java.awt.Point;


public class Tabuleiro {
	
	private Point ondeEstou;

	public void visita(Point p) {
		ondeEstou=p;
	}

	public Point[] anda(int n) {
		Point ps[] = {null};
		
		ps[0]= primeiro_movimento_valido();
		
		return ps;
	}

	private Point primeiro_movimento_valido() {
		Point p = new Point();
		int[][] movimentos_validos = 
					 {{1, 2},{2, 1},{1, -2},{2, -1},
					  {-1,2},{-2,1},{-1,-2},{-2,-1}};
		
		for (int i=0 ; i<8 ; i++) {
			int x = ondeEstou.x + movimentos_validos[i][0];
			int y = ondeEstou.y + movimentos_validos[i][1];
			if(x>0 && y>0 && x<9 && y <9) {
				p.x = x;
				p.y = y;
				break;
			}
		}
		return p;
	}

	public Object getOndeEstou() {
		return new Point(3,3);
	}

	
	
	
}
