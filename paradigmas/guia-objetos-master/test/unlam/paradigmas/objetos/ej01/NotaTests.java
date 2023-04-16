package unlam.paradigmas.objetos.ej01;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class NotaTests {
	
	@Test
	public void DadoUnValorInicialMayorA10_CuandoCreoUnaNota_SeLanzaUnaExcepcion() {
		Integer notaMayorA10 = 15;
		
		Exception thrown = assertThrows(
				Exception.class,
		           () -> new Nota(notaMayorA10)
		    );

		assertEquals(thrown.getMessage(), "El valor inicial debe estar comprendido entre 0 y 10");
	}
	
	@Test
	public void DadoUnValorInicialMenorA0_CuandoCreoUnaNota_SeLanzaUnaExcepcion() {
		Integer notaMenorA0 = -5;
		
		Exception thrown = assertThrows(
				Exception.class,
		           () -> new Nota(notaMenorA0)
		    );

		assertEquals(thrown.getMessage(), "El valor inicial debe estar comprendido entre 0 y 10");
	}
	
	@Test
	public void DadoUnaNotaConValor5_CuandoSeObtieneElValor_SeRecibe5() throws Exception {
		Nota nota = new Nota(5);
		
		Integer valor = nota.obtenerValor();

		Integer valorEsperado = 5;
		assertEquals(valorEsperado, valor);
	}
	
	@Test
	public void DadoUnaNotaConValor7_AlRevisarSiEstaAprobado_SeRecibeTrue() throws Exception {
		Nota nota = new Nota(7);
		
		Boolean aprobado = nota.aprobado();

		assertTrue(aprobado);
	}
	
	@Test
	public void DadoUnaNotaConValor6_AlRevisarSiEstaAprobado_SeRecibeFalse() throws Exception {
		Nota nota = new Nota(6);
		
		Boolean aprobado = nota.aprobado();

		assertFalse(aprobado);
	}
	
	@Test
	public void DadoUnaNotaConValor7_AlRevisarSiEstaDesaprobado_SeRecibeFalse() throws Exception {
		Nota nota = new Nota(7);
		
		Boolean desaprobado = nota.desaprobado();

		assertFalse(desaprobado);
	}
	
	@Test
	public void DadoUnaNotaConValor6_AlRevisarSiEstaDesaprobado_SeRecibeTrue() throws Exception {
		Nota nota = new Nota(6);
		
		Boolean desaprobado = nota.desaprobado();

		assertTrue(desaprobado);
	}
	
	@Test
	public void DadaUnaNotaConValor5_CuandoSeRecuperaConUn7_EntoncesSeActualizaElValor() throws Exception {
		Nota nota = new Nota(5);
		
		nota.recuperar(7);

		int valorEsperado = 7;
		assertEquals(valorEsperado, nota.obtenerValor());
	}
	
	@Test
	public void DadaUnaNotaConValor5_CuandoSeRecuperaConUn4_EntoncesNoSeActualizaElValor() throws Exception {
		Nota nota = new Nota(5);
		
		nota.recuperar(4);

		int valorEsperado = 5;
		assertEquals(valorEsperado, nota.obtenerValor());
	}
	
	@Test
	public void DadaUnaNota_CuandoSeRecuperaConUnValorMayorA10_SeLanzaUnaExcepcion() throws Exception {
		Nota nota = new Nota(5);
		
		Exception thrown = assertThrows(
				Exception.class,
		           () -> nota.recuperar(15)
		    );

		assertEquals(thrown.getMessage(), "El nuevo valor debe estar comprendido entre 0 y 10");
	}
	
	@Test
	public void DadaUnaNota_CuandoSeRecuperaConUnValorMenorA0_SeLanzaUnaExcepcion() throws Exception {
		Nota nota = new Nota(5);
		
		Exception thrown = assertThrows(
				Exception.class,
		           () -> nota.recuperar(-5)
		    );

		assertEquals(thrown.getMessage(), "El nuevo valor debe estar comprendido entre 0 y 10");
	}
	
}
