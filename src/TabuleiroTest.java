import static junit.framework.Assert.*;

import java.awt.Point;

import org.junit.Test;

//	tabuleiro.visita(x,y)
//	[] tabuleiro.anda(3)

public class TabuleiroTest {

	@Test
	public void deve_andar_um_movimento_valido(){
		Tabuleiro t = new Tabuleiro();
		Point p1 = new Point(4,4);
		
		t.visita(p1);
		Point[] caminho = t.anda(1);
		
		assertEquals(1, caminho.length);
		assert_movimento_valido(p1, caminho[0]);
	}
	
	@Test
	public void deve_andar_um_outro_movimento_valido(){
		Tabuleiro t = new Tabuleiro();
		Point p1 = new Point(3,3);
		
		t.visita(p1);
		Point[] caminho = t.anda(1);
		
		assertEquals(1, caminho.length);
		assert_movimento_valido(p1, caminho[0]);
	}

	@Test
	public void nao_deve_sair_canto_0_0(){
		Tabuleiro t = new Tabuleiro();
		Point p1 = new Point(1,1);
		
		t.visita(p1);
		Point[] caminho = t.anda(1);
		
		assertEquals(1, caminho.length);
		assert_movimento_valido(p1, caminho[0]);
	}
	
	@Test
	public void deve_visitar_uma_casa_inicial(){
		Tabuleiro t  = new Tabuleiro();
		Point p1 = new Point(3,3);
		t.visita(p1);
		
		assertEquals(p1,t.getOndeEstou());
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
