package com.itt.arte;

public class Espectador {
	
	private String nombre;
	private String tlf;
	private int edad;
	
	//Zona constructores
	public Espectador(String nombre, String tfl, int edad){
		this.nombre = nombre;
		this.tlf = tfl;
		this.edad = edad;
	}
	
	public Espectador() {
		this.nombre = "";
		this.tlf = "";
		this.edad = 0;
	}

	//Zona getter y setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//Zona metodos
	public String rangoEdad() {
		String tipo ="";
		
		if(this.edad<13) {
			tipo = "INFANTIL";
		}else if(this.edad>=13 && this.edad <18) {
			tipo = "MENOR";
		}else if(this.edad>=18 && this.edad<65) {
			tipo = "MAYOR";
		}else if(this.edad>=65) {
			tipo = "JUBILADO";
		}
		
		return tipo;
	}
	
	@Override
	public String toString() {
		return (this.nombre + " tfn: " + this.tlf + " Tipo: " + this.rangoEdad());
	}
	
	
}
