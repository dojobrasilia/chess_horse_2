import static junit.framework.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

//	tabuleiro.visita(x,y)
//	[] tabuleiro.anda(3)

public class TabuleiroTest {

	private Tabuleiro t;

	@Before
	public void setUp() {
		t = new Tabuleiro();
	}
	
	@Test
	public void nao_deve_sair_das_bordas(){
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				assert_anda_1(t, new Point(i,j));
			}
		}
	}
	
	@Test//Testa o getter
	public void deve_visitar_uma_casa_inicial(){
		Point p1 = new Point(3,3);
		t.visita(p1);
		
		assertEquals(p1,t.getOndeEstou());
	}
	

	private void assert_anda_1(Tabuleiro t, Point p1) {
		t.visita(p1);
		Point[] caminho = t.anda(1);
		
		assertEquals(1, caminho.length);
		
		assert_movimento_valido(p1, caminho[0]);
	}

	private void assert_movimento_valido(Point pi, Point pf) {
		int mov_x = Math.abs(pf.x-pi.x);
		int mov_y = Math.abs(pf.y-pi.y);
		assertTrue(pf.x>0 && pf.x<9);
		assertTrue(pf.y>0 && pf.y<9);
		assertEquals(3, mov_x+mov_y );
		assertNotSame(0, mov_x);
		assertNotSame(0, mov_y);
	}
	
}
