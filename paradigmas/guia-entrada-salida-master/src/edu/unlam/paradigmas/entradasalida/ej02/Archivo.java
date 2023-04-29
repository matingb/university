package edu.unlam.paradigmas.entradasalida.ej02;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {
	
	public static void escribir(String nombreDeArchivo, List<?> datos) {
		FileWriter file = null;
		PrintWriter printWriter = null;
		
		try {
			file = new FileWriter(nombreDeArchivo);
			printWriter = new PrintWriter(file);
			
			for(Object dato : datos) {
				printWriter.print(dato + "\n");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(file != null) {
				try	{
					file.close();					
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					
				}
			}
		}
	}

	public static List<Integer> leer(String nombreArchivo) {
		List<Integer> datos = new ArrayList<Integer>();
		Scanner scanner = null;
		
		try {
			File file = new File(nombreArchivo);
			scanner = new Scanner(file);	
			
			while(scanner.hasNextInt()) {
				datos.add(scanner.nextInt());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		return datos;
	}

}
