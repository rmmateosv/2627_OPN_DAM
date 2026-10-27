package s3;

import java.io.File;
import java.util.ArrayList;
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
				case 2:
					mostrarEstanterías();
					break;
				case 3:
					borrarEstantería();
					break;
				case 4:
					colocarLibro();
					break;
				case 7:
					crearNota();
					break;
				}
			}while(opcion!=0);
		}
		else {
			System.err.println("No se ha conectado con S3");
		}
	}

	private static void crearNota() {
		// TODO Auto-generated method stub
		mostrarEstanterías();
		System.out.println("Introduce el nombre de la estantería");
		String nombreE = t.nextLine();
		System.out.println("Introduce nota");
		String nota = t.nextLine();
		if(ad.crearNota(nombreE,nota)) {
			System.out.println("Nota creada");
		}
		else {
			System.err.println("Error al crear la nota");
		}
	}

	private static void colocarLibro() {
		// TODO Auto-generated method stub
		mostrarEstanterías();
		System.out.println("Introduce el nombre de la estantería");
		String nombreE = t.nextLine();
		//Mostrar carpeta libros
		System.out.println("Introduce el nombre del libro que quieres colocar");
		mostrarCarpetaLocal();
		String nombreL = t.nextLine();
		if(ad.subirLibro(nombreE, "libros"+File.separator+nombreL)) {
			System.out.println("Libro colocado");
		}
		else {
			System.err.println("Error al colocar el libro");
		}
		
	}

	private static void mostrarCarpetaLocal() {
		// TODO Auto-generated method stub
		File carpeta = new File("libros");
		File[] ficheros = carpeta.listFiles();
		for(int i=0;i<ficheros.length;i++) {
			System.out.println(ficheros[i].getName());
		}
	}

	private static void borrarEstantería() {
		// TODO Auto-generated method stub
		mostrarEstanterías();
		System.out.println("Introduce el nombre de la estantería a borrar");
		String nombre = t.nextLine();
		//Comprobamos si tiene libros. Si tiene libros, no se puede borrar
		//Primero hay que borrar los libros
		ArrayList<String> libros = ad.obtenerLibros(nombre);
		if(libros.size()>0) {
			System.err.println("No se puede borrar porque hay libros");
		}
		else {
			if(ad.borrarEstantería(nombre)) {
				System.out.println("Estantería borrada");
			}
			else {
				System.err.println("Estantería no borrada");
			}
		}		
	}

	private static void mostrarEstanterías() {
		// TODO Auto-generated method stub
		ArrayList<String> estanterías = ad.obtenerEstanterías();
		System.out.println("Estantería de la Biblioteca");
		for(String e : estanterías) {
			System.out.println(e);
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
