package packageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import spy2fy.Musica;
import spy2fy.Playlist;

public class PlaylistTest {

	Musica musica;
	Musica musica2;
	Musica musica3;

	@Before
	public void inicializaVariaveisGlobais() throws Exception {

		this.musica = new Musica("Chandelier", 3, "Pop");
		this.musica2 = new Musica("Elastic Heart", 3, "Eletro");
		this.musica3 = new Musica("Cellophane", 4, "Pop");

	}

	@Test
	public void testConstrutor() {

		try {

			Playlist pop = new Playlist("pop");

		} catch (Exception e) {
			fail(); // nao deve falhar

		}

		try {
			Playlist eletro = new Playlist("eletro");

		} catch (Exception e) {
			fail(); // nao deve falhar

		}

	}

	@Test
	public void testConstrutorInvalido() {

		try {

			Playlist pop = new Playlist("");

			fail(); // nao deve chegar aqui

		} catch (Exception e) {
			assertEquals("Artista do album nao pode ser nulo ou vazio.",
					e.getMessage());

		}

		try {

			Playlist pop = new Playlist("  ");

			fail(); // nao deve chegar aqui

		} catch (Exception e) {
			assertEquals("Artista do album nao pode ser nulo ou vazio.",
					e.getMessage());

		}

		try {
			Playlist eletro = new Playlist(null);

			fail(); // nao deve falhar

		} catch (Exception e) {

			assertEquals("Artista do album nao pode ser nulo ou vazio.",
					e.getMessage());

		}

	}

	@Test
	public void testAddMusica() {

		try {

			Playlist pop = new Playlist("pop");
			Playlist eletro = new Playlist("eletro");

			try {

				assertTrue(pop.addMusica(this.musica));

			} catch (Exception e) {
				fail(); // nao deve falhar
			}

			try {

				assertTrue(eletro.addMusica(this.musica2));

			} catch (Exception e) {

				fail(); // nao deve falhar

			}

			try {
				assertTrue(pop.addMusica(this.musica3));

			} catch (Exception e) {

				fail(); // nao deve falhar

			}

		} catch (Exception e) {
			fail(); // nao deve falhar

		}
	}

	@Test
	public void testAddMusicaInvalida() {
		try {

			Playlist pop = new Playlist("pop");

			pop.addMusica(this.musica);
			pop.addMusica(this.musica3);

			try {
				pop.addMusica(null);

			} catch (Exception e) {
				assertEquals("Musica nao pode ser null", e.getMessage());
			}
			try {
				assertFalse(pop.addMusica(this.musica));

			} catch (Exception e) {
				fail(); // nao deve falhar

			}

		} catch (Exception e) {

			fail(); // nao deve falhar

		}

	}

	@Test
	public void testVerificaMusica() {

		try {

			Playlist pop = new Playlist("pop");
			Playlist eletro = new Playlist("eletro");

			pop.addMusica(this.musica);
			pop.addMusica(this.musica3);
			eletro.addMusica(this.musica2);

			try {

				assertTrue(pop.verificaMusica(this.musica));
				assertTrue(pop.verificaMusica(this.musica3));
				assertTrue(eletro.verificaMusica(this.musica2));

			} catch (Exception e) {
				fail(); // nao deve falhar

			}

			try {

				assertFalse(pop.verificaMusica(this.musica2));
				assertFalse(eletro.verificaMusica(this.musica));
				assertFalse(eletro.verificaMusica(this.musica3));

			} catch (Exception e) {

				fail(); // nao deve falhar

			}

			try {

				assertTrue(pop.verificaMusica("Chandelier"));
				assertTrue(pop.verificaMusica("Cellophane"));
				assertTrue(eletro.verificaMusica("Elastic Heart"));

			} catch (Exception e) {
				fail(); // nao deve falhar

			}

			try {

				assertFalse(pop.verificaMusica("Elastic Heart"));
				assertFalse(eletro.verificaMusica("Chandelier"));
				assertFalse(eletro.verificaMusica("Cellophane"));

			} catch (Exception e) {

				fail(); // nao deve falhar

			}

		} catch (Exception e) {
			fail(); // nao deve falhar
		}

	}

	@Test
	public void testVerificaMusicaInvalida() {
		
		try {

			Playlist pop = new Playlist("pop");
			Playlist eletro = new Playlist("eletro");

			pop.addMusica(this.musica);
			pop.addMusica(this.musica3);
			eletro.addMusica(this.musica2);

			try {
				
				String string = null;
				
				assertTrue(pop.verificaMusica(string));
				fail(); // nao deve falhar

			} catch (Exception e) {
				assertEquals("Musica nao pode ser null", e.getMessage());
			}

			try {
				
				Musica musica = null;
				
				assertTrue(eletro.verificaMusica(musica));

			} catch (Exception e) {
				assertEquals("Musica nao pode ser null", e.getMessage());

			}
			
		} catch(Exception e){

			fail(); // nao deve falhar

		}
		
	}

	@Test
	public void testProcuraIndiceMusica() {

		try {

			Playlist pop = new Playlist("pop");
			Playlist eletro = new Playlist("eletro");

			pop.addMusica(this.musica);
			pop.addMusica(this.musica3);
			eletro.addMusica(this.musica2);
		
			try{
				
				assertEquals(0, pop.procuraIndiceMusica("Chandelier"));
				assertEquals(1, pop.procuraIndiceMusica("Cellophane"));
				assertEquals(0, eletro.procuraIndiceMusica("Elastic Heart"));
				
			}catch(Exception e){

				fail(); // nao deve falhar

			}
			try{
				
				assertEquals(-1, eletro.procuraIndiceMusica("Chandelier"));
				assertEquals(-1, eletro.procuraIndiceMusica("Cellophane"));
				assertEquals(-1, pop.procuraIndiceMusica("Elastic Heart"));
				
			}catch(Exception e){
				fail(); // nao deve falhar

			}
			
		} catch(Exception e){
		
			fail(); // nao deve falhar
		}
	
	}

	@Test
	public void testProcuraIndiceMusicaInvalida(){
		try{
			
			Playlist pop = new Playlist("pop");
			Playlist eletro = new Playlist("eletro");

			pop.addMusica(this.musica);
			pop.addMusica(this.musica3);
			eletro.addMusica(this.musica2);
			
			try{
				
				assertEquals(0, pop.procuraIndiceMusica(""));
				assertEquals(0, eletro.procuraIndiceMusica(""));

				
			}catch(Exception e){
				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());
			}
			
			try{
				
				assertEquals(0, pop.procuraIndiceMusica(" "));
				assertEquals(0, eletro.procuraIndiceMusica("  "));

				
			}catch(Exception e){
				
				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());

			}

			try{
				
				assertEquals(0, pop.procuraIndiceMusica(null));
				assertEquals(0, eletro.procuraIndiceMusica(null));

				
			}catch(Exception e){
				
				assertEquals("Titulo da musica nao pode ser nulo ou vazio.", e.getMessage());

			}
			
		}catch(Exception e){
			fail(); // nao deve falhar

		}

	}
		
	@Test
	public void testGetMusica() {
		
		try{
			
			Playlist pop = new Playlist("pop");
			Playlist eletro = new Playlist("eletro");

			pop.addMusica(this.musica);
			pop.addMusica(this.musica3);
			eletro.addMusica(this.musica2);

			try{
				assertEquals(musica, pop.getMusica(0));
				assertEquals(musica3, pop.getMusica(1));
				assertEquals(musica2, eletro.getMusica(0));
							
			}catch(Exception e){
				fail(); // nao deve falhar
			}
			
		}catch(Exception e){
			
			fail(); // nao deve falhar

		}
		
	}

	@Test
	public void testGetMusicaInvalida(){
		
		
		try{

			Playlist pop = new Playlist("pop");

			pop.addMusica(this.musica);
			pop.addMusica(this.musica3);
			
			try{

				assertEquals(musica, pop.getMusica(-1));
				
				
			}catch(Exception e){
				
				assertEquals("Faixa da musica nao pode ser negativa", e.getMessage());
			}
			try{
				
				assertEquals(musica3, pop.getMusica(10));

			}catch(Exception e){
				
				assertEquals("Faixa da musica nao pode ultrapassar o numero limite do album", e.getMessage());				
			}

			try{
				
				assertEquals(musica2, pop.getMusica(2));

			}catch(Exception e){
				
				assertEquals("Faixa da musica nao pode ultrapassar o numero limite do album", e.getMessage());
				
			}
			
		}catch(Exception e){}

	}
		
	@Test
	public void testRmMusica() {

	try{
		
		Playlist pop = new Playlist("pop");

		pop.addMusica(this.musica);
		pop.addMusica(this.musica2);
		pop.addMusica(this.musica3);
		
		try{
			
		}catch(Exception e){}
		try{}catch(Exception e){}
		try{}catch(Exception e){}

		
	}catch(Exception e){
		fail(); // nao deve falhar
	}
	
	
	}

	@Test
	public void testRmMusicaInvalida() {

		try{
			
		Playlist pop = new Playlist("pop");

		pop.addMusica(this.musica);
		pop.addMusica(this.musica2);
		pop.addMusica(this.musica3);
		
		try{
			
		}catch(Exception e){}
		try{}catch(Exception e){}
		try{}catch(Exception e){}

		
	}catch(Exception e){
		fail(); // nao deve falhar
	}

}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
