package edu.unlam.paradigmas.entradasalida.ej02;

import java.util.List;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Resolver {

	public void accion(String ejercicio) throws IOException {
		generarArchivoDeEntrada(ejercicio);
		
		List<Integer> datos = Archivo.leer("./casos/ejercicio2/in/" + ejercicio + ".in");
		
		Integer maximo = null;
		Integer minimo = null;
		Integer promedio = 0;
		
		if(!datos.isEmpty()) {
			maximo = datos.get(0);
			minimo = datos.get(0);
		
			for (Integer dato : datos) {
				if(dato > maximo) {
					maximo = dato;
				} 
				
				if(dato < minimo) {
					minimo = dato;
				}
				
				promedio+=dato;
			}
			
			promedio = promedio / datos.size();
		}
		
		FileWriter file = null;
		PrintWriter printWriter = null;
		
		try {
			file = new FileWriter("./casos/ejercicio2/out/" + ejercicio + ".out");
			printWriter = new PrintWriter(file);
			
			printWriter.print("Maximo: " + maximo + "\n");
			printWriter.print("Minimo : " + minimo + "\n");
			printWriter.print("Promedio: " + promedio + "\n");
		}
		catch (Exception e){
			e.printStackTrace();
		} finally {
			if(file != null) {
				file.close();
			}
		}
	}

	private void generarArchivoDeEntrada(String ejercicio) {
		List<Integer> datosDeEntrada = new ArrayList<Integer>();
		Random random = new Random();
		int randomEntre10000y20000 = (10000 + random.nextInt(10000));
		
		for(int i = 0; i < randomEntre10000y20000; i++) {
			datosDeEntrada.add(random.nextInt(12000));
		}
		
		Archivo.escribir("./casos/ejercicio2/in/" + ejercicio + ".in", datosDeEntrada);
	}

}
