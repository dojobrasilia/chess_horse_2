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
				t = new Tabuleiro();
			}
		}
	}
	
	@Test
	public void deve_ir_pra_uma_posicao_quando_nao_tem_opcao_com_um_passo(){
		t.visita(new Point(2, 3));
		t.visita(new Point(1, 1));
		Point ret[] = t.anda(1);
		
		assertEquals(new Point(3,2),ret[0]);
	}

	@Test
	public void deve_ir_para_uma_posicao_quando_nao_tem_opcao_com_dois_passos(){
		t.visita(new Point(2, 3));
		t.visita(new Point(1, 3));
		t.visita(new Point(2, 4));
		t.visita(new Point(5, 1));
		t.visita(new Point(5, 3));
		t.visita(new Point(1, 1));
		
		Point ret[] = t.anda(2);
		
		assertEquals(new Point(3,2),ret[0]);
		assertEquals(new Point(4,4),ret[1]);
	}

	@Test(expected = NaoTemMaisMovimentoValidoException.class)
	public void deve_lancar_excecao_quando_nao_houver_mais_caminho_valido(){
		t.visita(new Point(1,1));
		t.anda(64);
	}
	
	@Test
	public void deve_retornar_um_movimento_com_rollback_a_partir_de_uma_situacao_montada(){
		t.visita(new Point(1,5));
		t.visita(new Point(3,1));
		t.visita(new Point(3,5));
		t.visita(new Point(4,4));
		t.visita(new Point(4,2));
		t.visita(new Point(1,1));
		
		Point ret[] = t.anda(2);
		

		assertEquals(new Point(3,2),ret[0]);
		assertEquals(2, ret.length);
	}
	
	public void deve_retornar_dois_movimentos_com_rollback_a_partir_de_uma_situacao_montada(){
		
	}
	
	@Test
	public void deve_concluir_o_dojo_sem_lancar_exception(){
		t.visita(new Point(1,1));
		t.anda(63);
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
