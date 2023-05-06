package edu.unlam.paradigmas.colecciones.ej03;

import java.util.HashSet;
import java.util.Set;

public class ContadorDePalabras {
	Set<String> set = new HashSet<String>();
	
	public void agregarPalabra(String palabra) {
		set.add(palabra);
	}
	
	public int contar() {
		return set.size();
	}
}
