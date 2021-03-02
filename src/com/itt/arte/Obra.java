package com.itt.arte;

public class Obra {
	
	private String titulo;
	private String genero;
	private int minutosDuracion;
	
	//Zona constructores
	public Obra() {
		this.titulo = "";
		this.genero = "";
		this.minutosDuracion = 0;
	}
	
	public Obra(String titulo, String genero, int minutos) {
		this.titulo = titulo;
		this.genero = genero;
		this.minutosDuracion = minutos;
	}

	//Zona getter y setter
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getMinutosDuracion() {
		return minutosDuracion;
	}

	public void setMinutosDuracion(int minutosDuracion) {
		this.minutosDuracion = minutosDuracion;
	}

	//Zona metodos
	@Override
	public String toString() {
		return "Hoy representamos " + this.titulo + ", genero:" + this.genero + ", Duracion:" + this.minutosDuracion;
	}
	
	
	
	
	
}
