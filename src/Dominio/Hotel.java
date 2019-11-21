package Dominio;

import java.util.ArrayList;

import Persistencia.hotelPers;

// Clase hotel, donde se van a declarar todas las variables, constructores, getters y setters que tenga esta clase.
public class Hotel {
	// Declaración de variables, donde estarán todos los factores que tenga un hotel.
	private String nombre;
	private String foto;
	private int telefono;
	private String direccion;
	private String ciudad;
	private String pais;
	private int numestrellas;
	private int hab_indi;
	private int hab_dobles;
	private int hab_triples;
	private int suites;
	private hotelPers HotelPers;
	
	// Constructores que tiene un hotel, con las variables declaradas anteriormente.
	public Hotel(String nombres, String fotos, int telefono, String direccion, String ciudad, String pais, int numestrellas, int hab_indi,
			int hab_dobles, int hab_triples, int suites) {
		this.nombre = nombres;
		this.foto = fotos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
		this.numestrellas = numestrellas;
		this.hab_indi = hab_indi;
		this.hab_dobles = hab_dobles;
		this.hab_triples = hab_triples;
		this.suites = suites;
		hotelPers HotelPers = new hotelPers();
	}
	
	// Getters y Setter que tiene la clase "Hotel".
	
	public Hotel(){
		hotelPers HotelPers = new hotelPers();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getNumestrellas() {
		return numestrellas;
	}

	public void setNumestrellas(int numestrellas) {
		this.numestrellas = numestrellas;
	}

	public int getHab_indi() {
		return hab_indi;
	}

	public void setHab_indi(int hab_indi) {
		this.hab_indi = hab_indi;
	}

	public int getHab_dobles() {
		return hab_dobles;
	}

	public void setHab_dobles(int hab_dobles) {
		this.hab_dobles = hab_dobles;
	}

	public int getHab_triples() {
		return hab_triples;
	}

	public void setHab_triples(int hab_triples) {
		this.hab_triples = hab_triples;
	}

	public int getSuites() {
		return suites;
	}

	public void setSuites(int suites) {
		this.suites = suites;
	}
	
	// Declaración de la funcionalidad de leer los hoteles de la lista. Para ello se tiene que declarar una variable, y crear una clase para poder
	// realizar esta función. La variable relacionada se llama "HotelPers".
    public void escribir(ArrayList<Hotel> lista){
    	HotelPers.escribir(lista);
    }

    // Declaración de la funcionalidad de modificar, añadir y eliminar los hoteles de la lista. Para ello se tiene que declarar una variable, y
    // crear una clase para poder realizar esta función. La variable relacionada se llama "HotelPers".
    public ArrayList<Hotel>leer() {
    return HotelPers.leer();
    }

    // Declaración del toString de la clase "Hotel" (Como se va a visualizar los datos almacenados del programa.).
	@Override
	public String toString() {
		return "Nombre:" + nombre + ", Foto:" + foto + ", Telefono:" + telefono + ", Dirección:"
				+ direccion + ", Ciudad:" + ciudad + ", País:" + pais + ", Número de Estrellas:" + numestrellas + 
				", Habitaciones Individuales:"+ hab_indi + ", Habitaciones Dobles:" + hab_dobles + 
				", Habitaciones Triples:" + hab_triples + ", Suites:" + suites + "";
	}
}


