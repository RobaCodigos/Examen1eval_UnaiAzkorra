package clases;

import java.util.Scanner;

public class Libro {
	//atributos
	private String isbn;
	private String titulo;
	private String autor;
	private int ejemplaresVendidos;
	private float precio;
	//scanner
	Scanner sc = new Scanner(System.in);
	//constante
	private final int SUPER_VENTAS=18000;
	//constructores
	public Libro() {
		
	}
	public Libro(String isbn, String titulo, String autor, int ejemplaresVendidos, float precio) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplaresVendidos = ejemplaresVendidos;
		this.precio = precio;
	}
	//getters and setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getEjemplaresVendidos() {
		return ejemplaresVendidos;
	}
	public void setEjemplaresVendidos(int ejemplaresVendidos) {
		this.ejemplaresVendidos = ejemplaresVendidos;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	//metodos
	public boolean esSuperVentas() {
		boolean superVenta=false;
		if(ejemplaresVendidos> SUPER_VENTAS) {
			superVenta=true;
		}
		return superVenta;
	}
	public float obtenerBeneficioTotal() {
		float beneficio;
		beneficio=ejemplaresVendidos*precio;
		beneficio= beneficio*1.04f;
		
		return beneficio;
	}
	//toString
	@Override
	public String toString() {
		return "[El libro con el título "+ titulo+ "e ISBN "+isbn+", creado por el autor "+autor+" ha vendido "+ejemplaresVendidos+" ejemplares a un precio de "+precio+" €”]";
	}
	
	public void setDatos() {
		System.out.println("Introduce el nombre de la nave");
		isbn=sc.next();
		System.out.println("Introduce el año de creacion");
		titulo=sc.next();
		System.out.println("Introduce el año de lanzamiento");
		autor=sc.next();
		System.out.println("Introduce la capacidad total de la nave");
		ejemplaresVendidos=sc.nextInt();
		System.out.println("Introduce el numero de tripulantes necesario para controlar la nave");
		precio=sc.nextInt();
	
	
	}
}
