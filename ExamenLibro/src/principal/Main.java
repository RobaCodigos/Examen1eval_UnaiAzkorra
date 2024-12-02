package principal;

import java.util.Scanner;

import clases.Libro;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Libro[] libros = new Libro[250];

		int opc,numLibros = 0;
	
		do {
			
			menu();
		
			System.out.println("Que desea hacer:");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				numLibros=introducirLibros(sc,libros, numLibros);
				break;
			case 2:
				mostrarLibrosAurtor(sc,libros,numLibros);
				break;
			case 3:
				ordenarLibroSuperVentas(sc,libros,numLibros);
				break;
			case 4:
				eliminarLibro(sc,libros,numLibros);
				break;
			case 5:
				mostrar(numLibros, libros);
				break;
			case 6:
				System.out.println("Agur");
				break;

			default:
				System.out.println("Error,opc incorrecta");
				break;
			}

		} while (opc != 6);
		sc.close();
	}

	private static void ordenarLibroSuperVentas(Scanner sc, Libro[] libros, int numLibros) {
		int inter;
		for (int i = 0; i < numLibros; i++) {
			for (int j = i + 1; j < numLibros; j++) {
				if (libros[j].getEjemplaresVendidos()> libros[i].getEjemplaresVendidos()) {
					inter = libros[i].getEjemplaresVendidos();
					libros[i] = libros[j];
					libros[j].getEjemplaresVendidos();
				}
			}
			if(libros[i].getEjemplaresVendidos()>=20000) {
			System.out.println(libros[i]);
			}
		}
	}
		
	

	private static void eliminarLibro(Scanner sc, Libro[] libros, int numLibros) {
		String resp,isbn;
		int libroaeliminar=0;
		System.out.println("Introduzca el ISBN del libro que desea elimenar");
		isbn= sc.next();
		System.out.println("¿Desae eliminar el libro con el ISBN: "+ isbn+"? si/no");
		resp=sc.next();
		
		if(resp.equalsIgnoreCase("si")) {
			for(int i=0; i < numLibros; i++) {
				if(isbn.equalsIgnoreCase(libros[i].getIsbn())) {
					libroaeliminar= i;
				}
			}
			for(int j= libroaeliminar; j < numLibros-1; j++) {
				libros[j]= libros[j+1];
			}
			numLibros -= numLibros;
			
		}
		
		
	}

	private static void mostrarLibrosAurtor(Scanner sc, Libro[] libros, int numLibros) {
		String autor;
		
		System.out.println("Escriba el nombre del autor");
		autor=sc.next();
		
		for(int i=0;i < numLibros;i++) {
			if(autor.equalsIgnoreCase(libros[i].getAutor())) {
				System.out.println(libros[i].toString());
			}
		}
		
	}

	private static void mostrar(int numLibros, Libro[] libros) {
		for (int i = 0; i < numLibros; i++) {
			libros[i].toString();
		}
	}

	private static int introducirLibros(Scanner sc, Libro[] libros,int numLibros) {
		// TODO Auto-generated method stub
		Libro lib;
		String continuar="si" ;
		

		for (; numLibros < libros.length && continuar.equalsIgnoreCase("si");) {
			System.out.println("Entrar");
			lib = new Libro();
			lib.setDatos();
			libros[numLibros++] = lib;

			
			System.out.println("¿Quieres Seguir Introduciendo?");
			continuar = sc.next();
		}

		if (numLibros >= libros.length) {
			System.out.println("Has Alcanzado El Limite De Asignaturas");

		}
		return numLibros;
	}
	

	private static void menu() {
		System.out.println("*****MENU*****");
		System.out.println("1-Introducir libros");
		System.out.println("2-Mostrar los libros de un autor en concreto.");
		System.out.println("3-Ordenar los libros SuperVentas por número de ejemplares vendidos.");
		System.out.println("4-Eliminar un libro concreto");
		System.out.println("5-Mostrar todos los libros que se han introducido.");
		System.out.println("6-Salir");
	}

}
