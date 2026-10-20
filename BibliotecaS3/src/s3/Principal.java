package s3;

import java.util.Scanner;

public class Principal {
	
	static Scanner t = new Scanner(System.in);
	static AccesoS3 ad = new AccesoS3();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(ad.getS3()!=null) {
			int opcion;
			do {
				System.out.println("Introduce opción:");
				System.out.println("0-Salir");
				System.out.println("1-Crear Estantería");
				System.out.println("2-Mostrar Estanterías");
				System.out.println("3-Borrar Estantería");
				System.out.println("4-Colocar libro en estantería");
				System.out.println("5-Ver libro");
				System.out.println("6-Borrar Libro");
				System.out.println("7-Crear nota en estantería");			
				opcion = t.nextInt(); t.nextLine();	
				
				switch (opcion) {
				case 1:
					crearEstanteria();
					break;

				
				}
			}while(opcion!=0);
		}
		else {
			System.err.println("No se ha conectado con S3");
		}
	}

	private static void crearEstanteria() {
		// TODO Auto-generated method stub
		System.out.println("Introduce el nombre de la estantería");
		String nombre = t.nextLine();
		if(ad.crearEstanteria(nombre)) {
			System.out.println("Estantería creada");
		}
		else {
			System.out.println("Error al crear la estantería");
		}
	}

}
