package edu.unlam.paradigmas.colecciones.ej08;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] arg) {
		InversorDeCola inversor = new InversorDeCola();
		Queue<Integer> cola= new LinkedList<Integer>();
		
		cola.add(1);
		cola.add(2);
		cola.add(3);
		cola.add(4);
		cola.add(5);
		
		System.out.println(cola);
		
		inversor.invertirCola(cola);
		
		System.out.println(cola);
		
	}
}
