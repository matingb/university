package unlam.paradigmas.objetos.ej02;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
Implementar la clase Punto. Un Punto en el plano posee coordenada X y coordenada Y. Proporcionar métodos para:
1.obtener y cambiar cada una de sus coordenadas: `java public double obtenerX() public double obtenerY() public void cambiarX(double nuevoX) public void cambiarY(double nuevoY) `
2.saber si el punto está sobre el eje de las X: `java public boolean estaSobreEjeX() `
3.saber si el punto está sobre el eje de las Y: `java public boolean estaSobreEjeY() `
4.saber si el punto es el origen de coordenadas: `java public boolean esElOrigen() { } `
5.calcular la distancia al origen y a otro punto: `java public double distanciaAlOrigen() { } public double distanciaAotroPunto(Punto otro) { } `
*/


public class PuntoTests {

	
	@Test
	public void DadoUnPuntoDeCoordenadaXIgualA2_AlObtenerCoordenadasDeX_Devuelve2() {
		Punto punto = new Punto(2.0,3.0);
		
		Double coordenadaEnX = punto.obtenerX();
		
		assertEquals(2.0, coordenadaEnX);
	}
	
	@Test
	public void DadoUnPuntoDeCoordenadaYIgualA3_AlObtenerCoordenadasDeX_Devuelve3() {
		Punto punto = new Punto(2.0,3.0);
		
		Double coordenadaEnY = punto.obtenerY();
		
		assertEquals(3.0, coordenadaEnY);
	}
	
	@Test
	public void DadoUnPuntoDeCoordenadaXIgualA2_AlCambiarLaCoordenadaAMenos3_XPasaASerMenos3() {
		Punto punto = new Punto(2.0,3.0);
		
		punto.cambiarX(-3.0);
		
		Double coordenadaEnX = punto.obtenerX();
		assertEquals(-3.0, coordenadaEnX);
	}
	
	@Test
	public void DadoUnPuntoDeCoordenadaYIgualA3_AlCambiarLaCoordenadaA7_XPasaASer7() {
		Punto punto = new Punto(2.0,3.0);

		punto.cambiarY(7.0);
		
		Double coordenadaEnY = punto.obtenerY();
		assertEquals(7.0, coordenadaEnY);
	}
	
	@Test
	public void DadoUnPuntoDeCoordenadaXIgualA0_AlPreguntarSiEstaEnElEjeX_DevuelveTrue() {
		Punto punto = new Punto(0.0,3.0);

		Boolean estaSobreElEjeX = punto.estaSobreElEjeX();
		
		assertTrue(estaSobreElEjeX);
	}
	
	@ParameterizedTest
    @ValueSource(doubles = {1, 0.01, -0.01, -4, Double.MIN_VALUE, Double.MAX_VALUE})
	public void DadoUnPuntoDeCoordenadaXDistintoDe0_AlPreguntarSiEstaEnElEjeX_DevuelveFalse(Double coordenadaEnX) {
		Punto punto = new Punto(coordenadaEnX,3.0);

		Boolean estaSobreElEjeX = punto.estaSobreElEjeX();
		
		assertFalse(estaSobreElEjeX);
	}
	
	public void DadoUnPuntoDeCoordenadaYIgualA0_AlPreguntarSiEstaEnElEjeY_DevuelveTrue() {
		Punto punto = new Punto(0.5,0.0);

		Boolean estaSobreElEjeY = punto.estaSobreElEjeY();
		
		assertTrue(estaSobreElEjeY);
	}
	
	@ParameterizedTest
    @ValueSource(doubles = {1, 0.01, -0.01, -4, Double.MIN_VALUE, Double.MAX_VALUE})
	public void DadoUnPuntoDeCoordenadaYDistintaDe0_AlPreguntarSiEstaEnElEjeY_DevuelveFalse(Double coordenadaEnY) {
		Punto punto = new Punto(0.5,coordenadaEnY);

		Boolean estaSobreElEjeY = punto.estaSobreElEjeY();
		
		assertFalse(estaSobreElEjeY);
	}
	
	@Test
	public void DadoUnPuntoConCoordenadas0y0_AlPreguntarSiEstaEnElOrigen_DevuelveTrue() {
		Punto punto = new Punto(0.0, 0.0);

		Boolean esElOrigen = punto.esElOrigen();
		
		assertTrue(esElOrigen);
	}
	
	@ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 0",
        "1, 1",
        "0.1, 1",
        "1, 0.1",
        "0.1, 0.1",
        "-0.1, 1",
    })
	public void DadoUnPuntoConCoordenadasDistintasDe0y0_AlPreguntarSiEstaEnElOrigen_DevuelveFalse(Double coordenadaEnX, Double coordenadaEnY) {
		Punto punto = new Punto(coordenadaEnX, coordenadaEnY);

		Boolean esElOrigen = punto.esElOrigen();
		
		assertFalse(esElOrigen);
	}
}
