package principal;

import java.util.Scanner;

import com.itt.arte.*;

public class Principal {

	private static Scanner lector;
	
	private static Obra obra = new Obra("La cena de los idiotas", "Comedia", 95);
	private static Teatro teatro = new Teatro("C/Sol, 45", 300, 2, obra, 30);
	
	
	public static void main(String[] args) {
		
		lector = new Scanner(System.in);
		
		char opc;
		
		do {
			System.out.println();
			opc = mostrarMenu();
			int fila = 0;
			int butaca = 0;
			String nombre = "";
			String telefono = "";
			int edad = 0;
			
			switch(opc) {
				case '1':
					
					System.out.println(teatro.verProgramación());
					break;
					
				case '2':
					
					System.out.println(teatro.verLocalidades());
					break;
					
				case '3':
					
					System.out.println(teatro.verLocalidadesOcupadas());
					break;
					
				case '4':
					
					System.out.println("¿En qué fila quieres sentarte (0-4)?");
					fila = lector.nextInt();
					lector.nextLine();
					System.out.println("¿En qué butaca (0-9)?");
					butaca = lector.nextInt();
					lector.nextLine();
					System.out.println("Cómo se llama?");
					nombre = lector.nextLine();
					System.out.println("¿Su teléfono?");
					telefono = lector.nextLine();
					System.out.println("¿Cuántos años tiene?");
					edad = lector.nextInt();
					lector.nextLine();
					
					//Espectador e = new Espectador(nombre, telefono, edad);
					
					System.out.println(teatro.venderLocalidad(fila, butaca,new Espectador(nombre, telefono, edad)));
					break;
					
				case '5':
					
					System.out.println("¿Fila (0-4)?");
					fila = lector.nextInt();
					lector.nextLine();
					System.out.println("¿Butaca (0-9)?");
					butaca = lector.nextInt();
					lector.nextLine();
					
					System.out.println(teatro.cancelarLocalidad(fila, butaca));
					break;
					
				case '6':
					
					System.out.println("¿Fila (0-4)?");
					fila = lector.nextInt();
					lector.nextLine();
					System.out.println("¿Butaca (0-9)?");
					butaca = lector.nextInt();
					lector.nextLine();
					
					System.out.println(teatro.consultarLocalidad(fila, butaca));
					break;
					
				case '7':
					double taquilla = teatro.calcualrRecaudacion();
					System.out.printf("Recaudación: %.2f euros %n", taquilla);
					break;
				case '8':
					System.out.println("Hasta pronto");
					
					break;
				default:
					System.out.println("La opción marcada no es correcta");
					break;
			}
		}while(opc!='8');
		
		lector.close();
	}
	
	public static char mostrarMenu() {
		String opcion;
		
		System.out.println("TEATRO LA BOMBILLA DE DON BLAS");
		System.out.println("------------------------------");
		System.out.println("1. Ver la programación actual");
		System.out.println("2. Mostrar todas las localidades");
		System.out.println("3. Mostrar localidades ocupadas");
		System.out.println("4. Vender localidad");
		System.out.println("5. Cancelar localidad");
		System.out.println("6. Consultar localidad");
		System.out.println("7. Calcular recaudación");
		System.out.println("8. Terminar programa");
		System.out.println("------------------------------");
		System.out.println("¿Qué opción deseas?");
		
		opcion = lector.nextLine();
		
		return opcion.charAt(0); // Devuelvo el primer caracter tecleado.
	}

}
