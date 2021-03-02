package com.itt.arte;

import java.text.DecimalFormat;

public class Teatro extends Local implements Sala {

	private Obra obra;
	private double precio;
	private Espectador[][] localidades;
	private DecimalFormat df = new DecimalFormat("#,##0.00");
	
	public Teatro() {
		this.obra = null;
		this.precio = 0.00;
		this.localidades = null;
	}

	
	public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio) {
		super(domicilio, metros, accesos);
		this.obra = obra;
		this.precio = precio;
		this.localidades = new Espectador[5][10];
		for(int i=0; i<this.localidades.length; i++) {
			for(int j=0; j<this.localidades[i].length; j++) {
				if(i==0 && j ==0) {
					this.localidades[i][j] = new Espectador("Carlos", "616664422", 35);
				}else if(i==1 && j == 2) {
					this.localidades[i][j] = new Espectador("Rosa", "664882222", 15);
				}else {
					this.localidades[i][j] = null;
				}
				
			}
		}
		
		
	}
	
	//Zona getter y setter
	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public double getPrecio() {
		
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Espectador[][] getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Espectador[][] localidades) {
		this.localidades = localidades;
	}

	//Zona metodos
	@Override
	public String verProgramación() {
		String peli = this.obra.toString();;
		String local = this.getDomicilio() + ", local de " + this.getMetros() + " metros, con  " 
				+ this.getAccesos() + " accesos"; 
		
		
		
		
		return (peli + "\nEn " + local);
	}

	@Override
	public String verLocalidades() {
		String butaca = "";
				
		for(int i=0; i<this.localidades.length; i++) {
			for(int j=0; j<this.localidades[i].length; j++) {
				if(j == this.localidades[i].length-1) {
					if(this.localidades[i][j] == null) {
						butaca = butaca + (i + "." + j + " Libre \n");
					}else {
						butaca = butaca + (i + "." + j + " Ocupada \n");
					}
				}else {
					if(this.localidades[i][j] == null) {
						butaca = butaca + (i + "." + j + " Libre   ");
					}else {
						butaca = butaca +  (i + "." + j + " Ocupada ");
					}
				}
			}
		}
		
		return butaca;
	}

	@Override
	public String verLocalidadesOcupadas() {
	String butaca = "";
	Espectador e;
		for(int i=0; i<this.localidades.length; i++) {
			for(int j=0; j<this.localidades[i].length; j++) {
				if(this.localidades[i][j] != null) {
					e = localidades[i][j];
					butaca = butaca + (i + "." + j + " " + e.getNombre().toUpperCase() + 
							", tlf: " + e.getTlf() + ", Tipo: " + e.rangoEdad() + "\n" +
							"Le ha costado la entrada: " + this.precioFinal(this.getPrecio(), 
									this.localidades[i][j].rangoEdad()) + " euros \n");
				}
			}
		}
		
		return butaca;
	}

	@Override
	public String venderLocalidad(int fila, int butaca, Espectador e) {
		String vacio="";
		double pvp = 0.00;
		
		if(this.localidades[fila][butaca] == null) {
			this.localidades[fila][butaca] = e;
			pvp = this.precioFinal(this.getPrecio(), e.rangoEdad());
			vacio = "Se ha vendido la localidad " + fila + "." + butaca + " a " +
					e.getNombre().toUpperCase() + " por " + df.format(pvp) + " euros \n";
		}else {
			vacio = ("La butaca está ocupada \n");
		}
		
		return vacio;		

	}

	@Override
	public String cancelarLocalidad(int fila, int butaca) {
		String vacio="";
				
			if(this.localidades[fila][butaca] != null) {
				vacio = this.localidades[fila][butaca].getNombre().toUpperCase() + " ha cancelado su butaca";
				this.localidades[fila][butaca] = null;
				
				
			}else {
				vacio = ("La butaca ya está libre");
			}
			
		return vacio;
	}

	@Override
	public String consultarLocalidad(int fila, int butaca) {
		Espectador esp = this.localidades[fila][butaca];
		if(esp != null) {
			return ("Localidad ocupada por " + esp.getNombre().toUpperCase() +
					", tlf: " + esp.getTlf() + ", tipo: " + esp.rangoEdad() +
					", Precio: " + df.format(this.precioFinal(this.precio, esp.rangoEdad()))) + " euros";
		}else {
			return ("La localidad está libre");
		}
		
		
	}

	@Override
	public double calcualrRecaudacion() {
		double taquilla = 0.00;		
		for(int i=0; i<this.localidades.length; i++) {
			for(int j=0; j<this.localidades[i].length; j++) {
				if(this.localidades[i][j] != null) {
					taquilla = taquilla + this.precioFinal(this.precio, this.localidades[i][j].rangoEdad());
				}else {
					
				}
			}
		}
	
		return taquilla;
	}
	
	private double precioFinal(double precio, String tipo) {
		double pvp = 0.0;
		
		switch(tipo) {
			case "INFANTIL":
				pvp = precio * 0.50;
				break;
			case "MENOR":
				pvp = precio * 0.80;
				break;
			case "JUBILADO":
				pvp = precio * 0.34;
				break;
			default:
				pvp = precio;
				break;
		}
		
		return pvp;
	}

}
