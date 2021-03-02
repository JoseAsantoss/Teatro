package com.itt.arte;


public interface Sala {
	
	public String verProgramación();
	public String verLocalidades();
	public String verLocalidadesOcupadas();
	public String venderLocalidad(int fila, int butaca, Espectador e);
	public String cancelarLocalidad(int fila, int butaca);
	public String consultarLocalidad(int fila, int butaca);
	double calcualrRecaudacion();
}
