package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.senac.jogos.TravessiaDeserto;

public class TravessiaDesertoTest {

	TravessiaDeserto caminhao;
	int x;
	int y;
	int z;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	caminhao = new TravessiaDeserto();
	x = 0;
	y = 0;
	z = 0;
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAvancar(){
		
		caminhao.initGame();
		x = caminhao.getPos();
		y = caminhao.getFuel();
		caminhao.avancar();
		assertEquals(caminhao.getPos(), x + 1);
		assertEquals(caminhao.getFuel(), y - 1);
	}
	

	@Test
	public void testVoltar(){
		
		caminhao.initGame();
		caminhao.avancar();
		
		assertTrue(caminhao.getPos() > 0);
		assertTrue(caminhao.getFuel() > 0);
	
		x = caminhao.getPos();
		
		caminhao.voltar();
		assertEquals(caminhao.getPos(), x - 1);
	}
	
	@Test
	public void testCarregar(){
		caminhao.initGame();
		caminhao.avancar();
		caminhao.descarregar();

		assertTrue(caminhao.getFuel() < caminhao.getMaxFuel());
		assertTrue(caminhao.getMap()[caminhao.getPos()] > 0);
		caminhao.carregar();

		caminhao.voltar();
		caminhao.descarregar();

		assertEquals(caminhao.getPos(), 0);
		caminhao.carregar();
	}

	@Test
	public void testDescarregar(){
		caminhao.initGame();		
		x = caminhao.getPos();
		y = caminhao.getFuel();
		
		caminhao.avancar();
		caminhao.descarregar();
		assertEquals(caminhao.getPos(), x + 1, x);
		assertEquals(caminhao.getFuel(), y - 1, y);
	}

	@Test
	public void testGetEndMessage() {
		caminhao.initGame();
		
		caminhao.avancar();
		if(caminhao.getPos() == 10)
			equals(caminhao.getEndMessage());	
	}

	@Test
	public void testIsGameOver() {
		caminhao.initGame();
		caminhao.avancar();

		int[] deposito = caminhao.getMap();
		equals(caminhao.getFuel() == 0);
		assertEquals(deposito[caminhao.getPos()], 0);

	}

	@Test
	public void testIsWinner() {
		caminhao.initGame();
		
		while (caminhao.getFuel() > 0)
			caminhao.avancar();
		
		assertTrue(caminhao.isGameOver());

		caminhao.initGame();
		solucao();
		assertTrue(caminhao.isGameOver());
		}

	@Test
	public void testInitGame() {
		caminhao.initGame();
		assertTrue(caminhao.getPos() == 0);
		assertTrue(caminhao.getFuel() == 6);
		assertEquals(caminhao.getPos(), 0);
	}
	
	 public void mov1(){
		   caminhao.avancar();
		   caminhao.avancar();
		   caminhao.descarregar();
		   caminhao.descarregar();
		   caminhao.voltar();
		   caminhao.voltar();
	   }
	   public void mov2(){
		   caminhao.avancar();
		   caminhao.avancar();
		   caminhao.carregar();
		   caminhao.carregar();
	   }
	   public void mov3(){
		   for (int i=0; i<7;i++)
			   caminhao.carregar();
	   }
	   public void mov4(){
		   for (int i=0; i<7;i++)
			   caminhao.avancar();
	   }
	   
	   public void solucao(){
		      mov1();
		      mov1();
		      mov1();
		      mov1();
		      mov2();
		      mov1();
		      mov3();
		      mov2();
		      mov4();

	   }
}
