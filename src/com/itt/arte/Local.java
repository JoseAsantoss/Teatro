package com.itt.arte;

public class Local {
	
	private String domicilio;
	private int metros;
	private int accesos;
	
	//Zona constructores
	public Local(String domicilio, int metros, int accesos) {
		this.domicilio = domicilio;
		this.metros = metros;
		this.accesos = accesos;
	}
	
	public Local() {
		this.domicilio = "";
		this.metros = 0;
		this.accesos = 0;
	}
	
	//Zona getters y setters
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getMetros() {
		return metros;
	}

	public void setMetros(int metros) {
		this.metros = metros;
	}

	public int getAccesos() {
		return accesos;
	}

	public void setAccesos(int accesos) {
		this.accesos = accesos;
	}
	
	@Override
	public String toString() {
		
		return ("Local que situado en " + this.domicilio + ", que tiene " +
				this.metros + " metros y " + this.accesos + " accesos");
	}
	
	

}
