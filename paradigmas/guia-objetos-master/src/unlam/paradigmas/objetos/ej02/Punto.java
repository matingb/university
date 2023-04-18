package unlam.paradigmas.objetos.ej02;

public class Punto {

	Double x;
	Double y;

	public Punto(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double obtenerX() {
		return this.x;
	}

	public Double obtenerY() {
		return this.y;
	}

	public void cambiarX(double nuevoX) {
		this.x = nuevoX;
	}
	
	public void cambiarY(double nuevoY) {
		this.y = nuevoY;
	}

	public Boolean estaSobreElEjeX() {
		return this.x == 0;
	}

	public Boolean estaSobreElEjeY() {
		return this.y == 0;
	}

	public Boolean esElOrigen() {
		return this.estaSobreElEjeX() && this.estaSobreElEjeY();
	}
}
