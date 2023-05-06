package edu.unlam.paradigmas.colecciones.ej01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Registro {
	private List<Paquete> paquetes = new ArrayList<Paquete>();
	
	public void agregarPaquete(Paquete paquete ) {
		this.paquetes.add(paquete);
	}
	
	public Paquete consultarPaquete(int numeroDeSeguimiento) {
		return (Paquete) this.paquetes.stream()
				.filter(paquete -> paquete.numeroDeseguimiento == numeroDeSeguimiento)
				.findFirst().orElse(null);
	}
	
	public List<Paquete> paquetesConMayorPesoA(double peso) {
		return this.paquetes.stream()
				.filter(paquete -> paquete.peso > peso).collect(Collectors.toList());
	}
}