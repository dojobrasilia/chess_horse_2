import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Tabuleiro {
	
	private Point ondeEstou;
	private boolean[][] jaEstiveAqui;

	public Tabuleiro() {
		jaEstiveAqui = new boolean[9][9];
	}
	
	public void visita(Point p) {
		jaEstiveAqui[p.x][p.y]= true;
		ondeEstou=p;
	}

	public Point[] anda(int n){
		Point ps[] = new Point[n];
		
		tenta_andar_casa(ps, 0, n);
		
		return ps;
	}

	private void tenta_andar_casa(Point[] posicoes_visitadas, int passo_atual, int n) {
		Point[] posicoes_validas = obtem_movimentos_valido();
		
		
		for (int j = 0; j < posicoes_validas.length ; j++){
			visita(posicoes_validas[j] );
			posicoes_visitadas[passo_atual] = posicoes_validas[j];
			try {
				if (passo_atual+1 < n){
					tenta_andar_casa(posicoes_visitadas, passo_atual+1, n);
				}
				return;
			} catch (NaoTemMaisMovimentoValidoException e) {} // Será?
		}
		throw new NaoTemMaisMovimentoValidoException();
	}
	
	private Point[] obtem_movimentos_valido() {
		List<Point> movi_validos = new ArrayList<Point>();
		int[][] movimentos_validos = 
					 {{1, 2},{2, 1},{1, -2},{2, -1},
					  {-1,2},{-2,1},{-1,-2},{-2,-1}};
		
		for (int i=0 ; i<8 ; i++) {
			int x = ondeEstou.x + movimentos_validos[i][0];
			int y = ondeEstou.y + movimentos_validos[i][1];
			if(x>0 && y>0 && x<9 && y <9 && !jaEstiveAqui[x][y]) {
				movi_validos.add(new Point(x, y));
			}
		}
		
		if (movi_validos.isEmpty()) 
		  throw new NaoTemMaisMovimentoValidoException();
		else
			return movi_validos.toArray(new Point[movi_validos.size()]);
	}
	
}
