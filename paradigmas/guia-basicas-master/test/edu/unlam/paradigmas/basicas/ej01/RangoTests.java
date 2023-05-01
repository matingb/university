package edu.unlam.paradigmas.basicas.ej01;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangoTests {
	
	@Test
	public void validarSiEstaDentroDeRango() {
		Rango rango = Rango.rangoAbierto(1.0, 3.2);
		
		Boolean estaDentroDeRango = rango.dentroDeRango(2.0);
		
		Assert.assertTrue(estaDentroDeRango);
	}
	
	@Test
	public void validarSiEstaDentroDeRangoUnRangoAbierto() {
		Rango rango = Rango.rangoAbierto(1.0, 3.2);
		
		
		Boolean estaDentroDeRango = rango.dentroDeRango(Rango.rangoAbierto(1.0, 3.2));
		
		Assert.assertFalse(estaDentroDeRango);
	}
	
	@Test
	public void validarSiEstaDentroDeRangoUnRangoCerrado() {
		Rango rango = Rango.rangoCerrado(1.0, 3.2);
		
		
		Boolean estaDentroDeRango = rango.dentroDeRango(Rango.rangoAbierto(1.0, 3.2));
		
		Assert.assertTrue(estaDentroDeRango);
	}
	
	@Test
	public void validarSiDosRangosSonIguales() {
		Rango rango = Rango.rangoCerrado(1.0, 3.2);
		Rango rango2 = Rango.rangoCerrado(1.0, 3.2);
		
		Boolean sonIguales = rango.equals(rango2);
		
		Assert.assertTrue(sonIguales);
	}
	
	@Test
	public void validarSiDosRangosSonDistintos() {
		Rango rango = Rango.rangoCerrado(1.0, 3.2);
		Rango rango2 = Rango.rangoAbiertoCerrado(1.0, 3.2);
		
		Boolean sonIguales = rango.equals(rango2);
		
		Assert.assertFalse(sonIguales);
	}
	
	@Test
	public void DadoUnRangoDentroDeOtroValidarSiHayInterseccion() {
		Rango rango = Rango.rangoCerrado(1.0, 3.2);
		Rango rango2 = Rango.rangoAbiertoCerrado(1.5, 3.0);
		
		Boolean hayInterseccion = rango.interseccionDeRango(rango, rango2);
		
		Assert.assertTrue(hayInterseccion);
	}
	
	@Test
	public void DadoDosRangosValidarSiHayInterseccion() {
		Rango rango = Rango.rangoCerrado(1.0, 3.2);
		Rango rango2 = Rango.rangoAbiertoCerrado(-3.0, 3.0);
		
		Boolean hayInterseccion = rango.interseccionDeRango(rango, rango2);
		
		Assert.assertTrue(hayInterseccion);
	}
	
	@Test
	public void DadoDosRangosValidarSiNoHayInterseccion() {
		Rango rango = Rango.rangoCerrado(1.0, 3.2);
		Rango rango2 = Rango.rangoAbiertoCerrado(-3.0, 0.0);
		
		Boolean hayInterseccion = rango.interseccionDeRango(rango, rango2);
		
		Assert.assertFalse(hayInterseccion);
	}
	
	@Test
	public void DadoUnConjuntoDeRangosSeOrdenanCorrectamente() {
		Rango[] listaDeRangos = {
	      		Rango.rangoAbierto(1.0, 3.2),
	    		Rango.rangoCerrado(0.0, 5.2),
	    		Rango.rangoCerrado(1.0, 5.2),
	    		Rango.rangoCerrado(1.0, 3.2)                          
		};

		Arrays.sort(listaDeRangos);
		
		
		Rango[] listaEsperada = {
				Rango.rangoCerrado(0.0, 5.2),
				Rango.rangoCerrado(1.0, 3.2),                      
				Rango.rangoAbierto(1.0, 3.2),
	    		Rango.rangoCerrado(1.0, 5.2),
		};
		Assert.assertEquals(listaEsperada, listaDeRangos);
	}
}
