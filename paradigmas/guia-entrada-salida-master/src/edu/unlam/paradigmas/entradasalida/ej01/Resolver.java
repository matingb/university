package edu.unlam.paradigmas.entradasalida.ej01;

import java.util.List;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;

public class Resolver {

	public void accion(String ejercicio) throws IOException {
		Archivo archivo = new Archivo(ejercicio);
		List<Integer> datos = archivo.leer();
		List<Integer> imprimir = new ArrayList<Integer>();
		
		Collections.sort(datos);
		
		Integer actual = null;
		Integer total = 0;
		for(Integer dato : datos) {
			if(dato != actual) {
				total++;
				actual = dato;
				imprimir.add(dato);
			}
		}
		
		imprimir.add(0, total);
		
		archivo.guardarArchivo(imprimir);
		
	}

}
