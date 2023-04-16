 package unlam.paradigmas.objetos.ej01;

public class Nota {
	
	private Integer valor;
	
    /**
     * pre : valorInicial está comprendido entre 0 y 10.
     * post: inicializa la Nota con el valor indicado.
     * @throws Exception 
     */
    public Nota(int valorInicial) throws Exception {
    	if(valorValido(valorInicial)) {
    		this.valor = valorInicial;
    	} else {    		
    		throw new Exception("El valor inicial debe estar comprendido entre 0 y 10");
    	}
    	
    }
    
    /**
     * post: devuelve el valor numérico de la Nota,
     *       comprendido entre 0 y 10.
     */
    public int obtenerValor() {
    	return this.valor;
    }
    
    /**
     * post: indica si la Nota permite o no la aprobación.
     */
    public boolean aprobado() {
    	return this.valor >= 7;
    }
    
    /**
     * post: indica si la Nota implica desaprobación.
     */
    public boolean desaprobado() {
    	return this.valor < 7;
    }
    
    /**
     * pre : nuevoValor está comprendido entre 0 y 10.
     * post: modifica el valor numérico de la Nota, cambiándolo
     *       por nuevoValor, siempre y cuando nuevoValor sea superior al
     *       valor numérico actual de la Nota.
     * @throws Exception 
     */
    public void recuperar(int nuevoValor) throws Exception { 
    	if(valorValido(nuevoValor)) {
        	if(nuevoValor > this.valor) {    		
        		this.valor = nuevoValor;
        	}
    	} else {
    		throw new Exception("El nuevo valor debe estar comprendido entre 0 y 10");
    	}

    }
    
    private boolean valorValido(Integer valor) {
    	return valor > 0 && valor < 10;
    }
}
