package edu.unlam.paradigmas.colecciones.ej03;

public class Main {
	public static void main(String[] arg) {
		ContadorDePalabras contador = new ContadorDePalabras();
		
		String texto = "Lorem ipsum dolor sit amet consectetur, adipisicing elit. "
				+ "Quia omnis dolores mollitia assumenda hic laboriosam! "
				+ "Velit corporis suscipit minima recusandae asperiores officia dolor! "
				+ "  Facere dolorem esse deleniti, at commodi quasi.";
		
		String[] palabras = texto.split("\\s|\\,|\\.");
		
		for(String palabra : palabras) {			
			contador.agregarPalabra(palabra.trim());
		}

		contador.agregarPalabra("LOREM");
		contador.agregarPalabra("Lorem");
		System.out.println(contador.contar());
	}
}
