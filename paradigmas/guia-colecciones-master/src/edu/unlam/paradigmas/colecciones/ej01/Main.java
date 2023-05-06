package edu.unlam.paradigmas.colecciones.ej01;

public class Main {
	public static void main(String[] arg) {
		Registro registro = new Registro();
		
		registro.agregarPaquete(new Paquete(1, 2.5));
		registro.agregarPaquete(new Paquete(2, 4.5));
		registro.agregarPaquete(new Paquete(3, 1.5));
		registro.agregarPaquete(new Paquete(4, 6.5));
		registro.agregarPaquete(new Paquete(5, 2.5));
		
		System.out.println(registro.consultarPaquete(3).toString());
		
		System.out.println(registro.paquetesConMayorPesoA(3.0).toString());
		
	}
}
