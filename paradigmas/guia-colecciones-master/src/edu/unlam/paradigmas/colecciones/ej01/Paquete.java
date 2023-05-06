package edu.unlam.paradigmas.colecciones.ej01;

public class Paquete {
	int numeroDeseguimiento = 0;
	double peso;
	
	public Paquete(int numeroDeSeguimiento, double peso) {
		this.numeroDeseguimiento = numeroDeSeguimiento;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Paquete [numeroDeseguimiento=" + numeroDeseguimiento + ", peso=" + peso + "]";
	}
}
