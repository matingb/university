package edu.unlam.paradigmas.entradasalida.ej01;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {
	
	private String nombre;
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Integer> leer() {
		List<Integer> datos = null;
		Scanner scanner = null;
		
		try {
			File file = new File("./casos/in/" + nombre + ".in");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			
			if(scanner.hasNextInt()) {
				int cant = scanner.nextInt();
				datos = new ArrayList<Integer>();
				for(int i = 0 ; i < cant; i++) {
					datos.add(scanner.nextInt());
				} 
			}
			else {
				return new ArrayList<Integer>();
			}

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		return datos;
	}
	
	public void guardarArchivo(List<Integer> datos) throws IOException {
		FileWriter file = null;
		PrintWriter printerWriter = null;
		
		try {
			file = new FileWriter("./casos/out/" + nombre + ".out");
			printerWriter = new PrintWriter(file);
			
			for(Integer dato : datos) {
				printerWriter.print(dato + "\n");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		} finally {
			if(file != null) {
				file.close();
			}
		}
	}
}
