package edu.unlam.paradigmas.basicas.ej01;

import java.util.Objects;

public class Rango implements Comparable<Rango>{

	private final Double inicio;
	private final Double fin;
	private final TipoDeRango tipoDeRango;
	
	private Rango(Double inicio, Double fin, TipoDeRango tipoDeRango) {
		this.inicio = inicio;
		this.fin = fin;
		this.tipoDeRango = tipoDeRango;
	}
	
	private Double getInicio() {
		return inicio;
	}

	private Double getFin() {
		return fin;
	}
	
	private TipoDeRango getTipoDeRango() {
		return tipoDeRango;
	}
	
	public static Rango rangoAbierto(Double inicio, Double fin) {
		return new Rango(inicio, fin, TipoDeRango.ABIERTO);
	}
	
	public static Rango rangoCerrado(Double inicio, Double fin) {
		return new Rango(inicio, fin, TipoDeRango.CERRADO);
	}
	
	public static Rango rangoAbiertoCerrado(Double inicio, Double fin) {
		return new Rango(inicio, fin, TipoDeRango.ABIERTO_CERRADO);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fin, inicio, tipoDeRango);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rango other = (Rango) obj;
		return Objects.equals(fin, other.fin) && Objects.equals(inicio, other.inicio)
				&& tipoDeRango == other.tipoDeRango;
	}

	public static Rango rangoCerradoAbierto(Double inicio, Double fin) {
		return new Rango(inicio, fin, TipoDeRango.CERRADO_ABIERTO);
	}
	
	public Boolean dentroDeRango(Double numero) {
		return this.tipoDeRango.dentroDeRango(this, numero);
	}
	
	public Boolean dentroDeRango(Rango rango) {
		return this.tipoDeRango.dentroDeRango(this, rango);
	}
	
	public Boolean interseccionDeRango(Rango rango1, Rango rango2) {
		return this.tipoDeRango.interseccionDeRango(rango1, rango2);
	}
	
	private enum TipoDeRango {
		ABIERTO {
			@Override
			public Boolean dentroDeRango(Rango rango, Double numero) {
				return numero > rango.getInicio() && numero < rango.getFin();
			}
			
		}, CERRADO {
			@Override
			public Boolean dentroDeRango(Rango rango, Double numero) {
				return numero >= rango.getInicio() && numero <= rango.getFin();
			}
		}, ABIERTO_CERRADO {
			@Override
			public Boolean dentroDeRango(Rango rango, Double numero) {
				return numero > rango.getInicio() && numero <= rango.getFin();
			}
		}, CERRADO_ABIERTO {
			@Override
			public Boolean dentroDeRango(Rango rango, Double numero) {
				return numero >= rango.getInicio() && numero < rango.getFin();
			}
		};
		
		public abstract Boolean dentroDeRango(Rango rango, Double numero);
		
		public Boolean dentroDeRango(Rango rangoExterior, Rango rangoInterior) {
			return dentroDeRango(rangoExterior, rangoInterior.getInicio()) &&
					dentroDeRango(rangoExterior, rangoInterior.getFin());
		}
		
		public Boolean interseccionDeRango(Rango rango1, Rango rango2) {
			return dentroDeRango(rango1, rango2.getInicio()) ||
					dentroDeRango(rango1, rango2.getFin()) ||
					dentroDeRango(rango2, rango1.getInicio()) ||
					dentroDeRango(rango2, rango1.getFin());
		}
	}

	@Override
	public int compareTo(Rango o) {
		if(this.getInicio() < o.getInicio()) {
			return -1;
		} else if(this.getInicio() > o.getInicio()) {
			return 1;
		} else if(this.getFin() < o.getFin()) {
			return -1;
		} else if(this.getFin() > o.getFin()) {
			return 1;
		} else if(this.getTipoDeRango().equals(TipoDeRango.CERRADO)) {
			return -1;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Rango [inicio=" + inicio + ", fin=" + fin + ", tipoDeRango=" + tipoDeRango + "]";
	}
}