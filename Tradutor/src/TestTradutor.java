import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTradutor {
	
	private Tradutor t;
	
	@BeforeEach
	public void criarTradutor() {
		t = new Tradutor();
	}

	@Test
	public void tradutorSemPalavras() {
		assertTrue(t.estaVazio());
	}
	
	@Test
	public void umaTraducao() {
		t.adicionaTraducao("bom","good");
		assertFalse(t.estaVazio());
		assertEquals("good", t.traduzir("bom"));
	}
	
	@Test
	public void duasTraducoes() {
		t.adicionaTraducao("bom","good");
		t.adicionaTraducao("mau", "bad");
		assertEquals("good", t.traduzir("bom"));
		assertEquals("bad", t.traduzir("mau"));
	}
	
	@Test
	public void duasTraducoesMesmaPalavra() {
		t.adicionaTraducao("bom","good");
		t.adicionaTraducao("bom", "nice");
		assertEquals("good, nice", t.traduzir("bom"));
	}
	
	@Test
	public void traduzirFrase() {
		t.adicionaTraducao("ler","read");
		t.adicionaTraducao("é", "is");
		t.adicionaTraducao("bom", "good");
		assertEquals("read is good", t.traduzirFrase("ler é bom"));
	}
	
	@Test
	public void traduzirFraseComDuasTraducoesMesmaPalavra() {
		t.adicionaTraducao("ler","read");
		t.adicionaTraducao("é", "is");
		t.adicionaTraducao("bom", "good");
		t.adicionaTraducao("bom", "nice");
		assertEquals("read is good", t.traduzirFrase("ler é bom"));
	}

}
