package edu.unlam.paradigmas.colecciones.ej05;

import java.util.HashMap;
import java.util.Map;

public class RegistroDeVentas {
	Map<Integer, Double> registro = new HashMap<Integer, Double>();
	
	public void agregarMonto(Integer mes, Double monto) {
		if (registro.containsKey(mes)) {
		    Double valorActual = registro.get(mes);
		    registro.put(mes, valorActual + monto);
		} else {
			registro.put(mes, monto);
		}
	}
}
