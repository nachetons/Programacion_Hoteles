package Presentacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import Dominio.Hotel;

public class XMLEnHoteles {

	public static void main(String[] args) {
		
		// Se declaran las variables necesarias, para que el programa funcione correctamente. Para ello se ha declarado un
		// array, que esta relacionado con la clase "Hotel", para poder imprimir los datos que tengamos en el XML. Un scanner
		// para poder leer variables y hacer saltos de linea, también esta la variable Hotel, el boolean "seguir" para poder 
		// seguir utilizando el programa o pararlo y una variable "lista", para poder leer los datos que tengamos en el XML.
		
		ArrayList<Hotel> lista = new ArrayList<Hotel>();
		Scanner sc = new Scanner(System.in);
		Hotel hotel = new Hotel();
		lista = hotel.leer();
		boolean seguir = true;
		while (seguir) {
			// Aquí se nos imprimira el menú.
			System.out.println("¿Que deseas hacer?\n1. Añadir Hotel\n2. Modificar"
					+ " Hotel\n3. Eliminar Hotel\n4. Imprimir los Hoteles existentes"
					+ "\n5. Buscar un hotel\n6. Log out");
			// Variable entera, en la cual podemos indicar la opción que queramos del menú
			int opcion = 0;
			do {
				try {
					opcion = sc.nextInt();

					// Si se introduce algún carácter que no sea entero. Saltará esta excepción
				} catch (InputMismatchException e) {
					System.err.println("Introduzca números");
					sc.nextLine();
				}
				
				// Se crea un Switch, y en cada caso estará su método correspondiente.
				switch (opcion) {
				case 1:
					anadirHotel(lista, sc);
					break;
				case 2:
					modificarHotel(lista, sc);
					break;
				case 3:
					eliminarHotel(lista, sc);
					break;
				case 4:
					leerHotelesLista(lista);
					break;
				case 5:
					buscarHotel(lista, sc);
					break;
				case 6:
					System.out.println("Hasta pronto");
					seguir = false;
					break;
				// Y si se introduce cualquier número que no este entre el 1 y el 6. Saltará el default, en la cual
				// saltaría el mensaje de opción incorrecto, y se volverá a repetir el menú (con el While).
				default:
					System.out.println("Opción incorrecta. Del 1 al 6");
					break;
				}
			} while (opcion > 6 || opcion < 1);
		}

	}

	// Clase privada, en la cual se hará la funcionalidad de añadir hoteles al XML.
	private static void anadirHotel(ArrayList<Hotel> lista, Scanner sc) {
		
		// Para poder añadir un hotel , se deberá responder a las siguientes preguntas, que dependiendo de la pregunta,
		// se contestará con un entero (un número), un texto o una cadena de textos.
		
		//Primero se declararán las variables "String".
		System.out.println("");
		System.out.println("Dime el nombre del hotel");
		sc.nextLine();
		String nombre = sc.nextLine();
		
		System.out.println("Dime la foto, con su extensión correspondiente");
		String foto = sc.next();
		
		System.out.println("Dime la dirección del hotel");
		sc.nextLine();
		String direccion = sc.nextLine();
		
		System.out.println("Dime el nombre de la ciudad");
		String ciudad = sc.nextLine();
		
		System.out.println("Dime el nombre del país");
		String pais = sc.next();
		sc.nextLine();
		
		//Y después la declaración de variables enteros.
		
		int telefono = 0;
		int numestrellas = 0;
		int hab_indi = 0;
		int hab_dobles = 0;
		int hab_triples = 0;
		int suites = 0;
		boolean seguir = false;

		do {
			// Se hace un do, en el caso de que se equivoque en la pregunta, se volverá a preguntar (esto pasa cuando 
			// se introduce un String, en vez de un int), esto pasa en el catch, en cada una de las preguntas..
			// Esto se hace en todas las preguntas con variable int. 
			try {
				System.out.println("Dime el teléfono");
				telefono = sc.nextInt();
				seguir = true;

			} catch (InputMismatchException e) {
				System.err.println("Introduzca números");
				System.out.println("");
				sc.nextLine();
			}
		}while (seguir == false);
		
		seguir = false;

		do {
			try {
				System.out.println("¿Cuantas estrellas tiene tu hotel?");
				numestrellas = sc.nextInt();
				seguir = true;

			} catch (InputMismatchException e) {
				System.err.println("Introduzca números");
				sc.nextLine();
			}
		}while (seguir == false);
		
		seguir = false;
		
		do {
			try {
				System.out.println("¿Cuantas habitaciones individuales tiene tu hotel?");
				hab_indi = sc.nextInt();
				seguir = true;

			} catch (InputMismatchException e) {
				System.err.println("Introduzca números");
				sc.nextLine();
			}
		}while (seguir == false);
		
		seguir = false;
		
		do{
			try {
				System.out.println("¿Cuantas habitaciones dobles tiene tu hotel?");
				hab_dobles = sc.nextInt();
				seguir=true;
	
			} catch (InputMismatchException e) {
				System.err.println("Introduzca números");
				sc.nextLine();
			}
		}while (seguir == false);
		
		seguir = false;
		
		do{
			try {
				System.out.println("¿Cuantas habitaciones triples tiene tu hotel?");
				hab_triples = sc.nextInt();
				seguir=true;
	
			} catch (InputMismatchException e) {
				System.err.println("Introduzca números");
				sc.nextLine();
			}
		}while(seguir == false);
		
		seguir = false;
		
		do{
			try {
				System.out.println("¿Cuantas suites tiene tu hotel?");
				suites = sc.nextInt();
				seguir = true;
	
			} catch (InputMismatchException e) {
				System.err.println("Introduzca números");
				sc.nextLine();
			}
		}while(seguir == false);

		// Si se han respondido todas las preguntas correctamente, nos saltará un mensaje, indicando
		//  de que el hotel se ha añadido con éxito y se nos modificará el XML, añadiendo el nuevo hotel que hayamos indicado.
		Hotel newHotel = new Hotel(nombre, foto, telefono, direccion, ciudad, pais, numestrellas, hab_indi, hab_dobles,
				hab_triples, suites);
		lista.add(newHotel);
		System.out.println("Hotel añadido con éxito");

		newHotel.escribir(lista);

	}

	// Clase privada, en la cual se hará la funcionalidad de modificar hoteles que estén dentro del XML.
	private static void modificarHotel(ArrayList<Hotel> lista, Scanner sc) {
		
		// Nos indicará previamente, que hotel deseamos modificar. Y se nos imprimirá los hoteles que tenemos 
		// en el XML. Para modificar un hotel, debemos escribir el hotel. Si nos equivocamos, nos dirá que no existe 
		// ningún hotel con ese nombre, y volverá al manú.
		
		// También tenemos las variables declaradas en este factor.
		String nombre1 = "";
		System.out.println("\n¿Que hotel deseas modificar?. Indique el hotel poniendo el nombre.");
		System.out.println();
		sc.nextLine();
		leerHotelesLista(lista);
		System.out.println();
		nombre1 = sc.nextLine();
		Hotel delHotel = new Hotel();
		delHotel.leer();
		boolean existe = false;
		int opcion = 0;
		
		// Se crea un for para recorrer la lista
		for (int j = 0; j < lista.size(); j++) {
			
			// En el caso de que exista el nombre, nos saltará un nuevo menú. En la que se indicará que es los que queremos 
			// modificar.
			if (lista.get(j).getNombre().equals(nombre1)) {
				existe = true;
				do {

					boolean seguir = false;
					do {
						
						// Para responder a la sección que queremos, se debe introducir el número que este al lado de la opción
						// que queramos seleccionar. Si introducirmos un número mayor o un texto, saltara una excepción, indicando
						// que solo se debe introducir números, y que estén relacionados con opción que queramos. Y se nos volverá
						// a repetir el menú de modificar hoteles.
						try {
							System.out.println(
									"\n¿Que deseas modificar?\n1. Nombre\n2. Foto\n3. Teléfono\n4. Dirección\n5. Ciudad\n6. País\n7. Número de estrellas\n8. Habitaciones Individuales\n9. Habitaciones Dobles\n10. Habitaciones Triples\n11. Suites");
							opcion = sc.nextInt();
							seguir = true;
						} catch (InputMismatchException e) {
							System.err.println("Introduzca números");
							sc.nextLine();
						}
					} while (seguir == false);
					switch (opcion) {

					// En el caso de qeu hayamos seleccionado un número correcto, nos saltará la pregunta que este relacionada
					// con la opción que hayamos indicado, para que lo podamos modificar. Esta desarrollado mediante un Switch
					// para que podamos seleccionar la opción correspondiente.
					
					// Desde el caso 1, hasta el 6, se podrá introducir cadenas de texto.
					case 1:
						
						// Variables y funcionalidad del caso 1 (nombre).
						seguir = false;
						System.out.println("Introduce un nuevo nombre");
						sc.nextLine();
						String nombre = sc.nextLine();
						boolean encontrado = false;
						for (int i = 0; i < lista.size(); i++) {
							if (lista.get(i).getNombre().equals(nombre)) {
								encontrado = true;
							}

						}
						// Se ha realizado correctamente, y se modificará el hotel que estuvo previamente. Y saltará un mensaje
						// "Modificado con éxito". Si se ha introducido el mismo nombre, se nos volverá a repetir el menú de mo-
						// dificar
						if (encontrado == false) {
							lista.get(j).setNombre(nombre);
							// añadir al XML
							lista.get(j).escribir(lista);
							System.out.println("Modificado con exito");
						}

						break;

					case 2:
						// Variables y funcionalidad del caso 2 (foto).
						seguir = false;
						System.out.println("Introduce la nueva foto, con su extensión correspondiente.");
						String foto = sc.next();
						lista.get(j).setFoto(foto);
						//Cuando ya hayamos escrito la foto, se nos modificará la foto del hotel que hayamos seleccionado.
						lista.get(j).escribir(lista);
						System.out.println("Modificado con exito");

						break;

					case 3:
						// Variables y funcionalidad del caso 3 (teléfono).
						seguir = false;
						do {
							try {
								System.out.println("Introduce el teléfono");
								int telefono = sc.nextInt();
								lista.get(j).setTelefono(telefono);
								;
								//Cuando ya hayamos escrito el teléfono, se nos modificará el teléfono del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
								// Si en vez de escribir un número hemos escrito una cadena de caracteres, nos saldrá esta excepción, in-
								// dicandonos de que tenemos que introducir números, y nos volverá a preguntar el número de teléfono.
							} catch (InputMismatchException e) {
								System.err.println("Introduzca números");
								sc.nextLine();
							}
							// Después de haber introducido el número, nos mandará al menú principal del programa.
						} while (seguir == false);

						break;

					case 4:
						// Variables y funcionalidad del caso 4 (dirección).
						seguir = false;
						System.out.println("Introduce la nueva dirección");
						sc.nextLine();
						String direccion = sc.nextLine();
						lista.get(j).setDireccion(direccion);
						//Cuando ya hayamos escrito la dirección, se nos modificará la dirección del hotel que hayamos seleccionado.
						lista.get(j).escribir(lista);
						System.out.println("Modificado con exito");

						break;

					case 5:
						// Variables y funcionalidad del caso 5 (ciudad).
						System.out.println("Introduce la nueva ciudad");
						sc.nextLine();
						String ciudad = sc.nextLine();
						lista.get(j).setCiudad(ciudad);
						//Cuando ya hayamos escrito la ciudad, se nos modificará la ciudad del hotel que hayamos seleccionado.
						lista.get(j).escribir(lista);
						System.out.println("Modificado con exito");

						break;

					case 6:
						// Variables y funcionalidad del caso 6 (país).
						System.out.println("Introduce un nuevo País");
						sc.nextLine();
						String pais = sc.nextLine();
						lista.get(j).setPais(pais);
						//Cuando ya hayamos escrito el país, se nos modificará el país del hotel que hayamos seleccionado.
						lista.get(j).escribir(lista);
						System.out.println("Modificado con exito");

						break;

					case 7:
						// Variables y funcionalidad del caso 7 (Número de estrellas).
						seguir = false;
						do {
							try {
								System.out.println("Introduce el número de estrellas que tiene tu hotel");
								int numestrellas = sc.nextInt();
								lista.get(j).setNumestrellas(numestrellas);
								//Cuando ya hayamos escrito el número de estrellas, se nos modificará el número de estrellas 
								//del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
								// Si en vez de escribir un número hemos escrito una cadena de caracteres, nos saldrá esta excepción, in-
								// dicandonos de que tenemos que introducir números, y nos volverá a preguntar el número de estrellas.
							} catch (InputMismatchException e) {
								System.err.println("Introduzca números");
								sc.nextLine();
							}
							// Después de haber introducido el número, nos mandará al menú principal del programa.
						} while (seguir == false);

						break;

					case 8:
						// Variables y funcionalidad del caso 8 (Habitaciones individuales).
						seguir = false;
						do {
							try {
								System.out.println("Introduce las habitaciones individuales que tiene tu hotel");
								int hab_indi = sc.nextInt();
								lista.get(j).setHab_indi(hab_indi);
								//Cuando ya hayamos escrito el número de habitaciones dobles, se nos modificará el número de habitaciones
								//individuales del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
							} catch (InputMismatchException e) {
								System.err.println("Introduzca números");
								sc.nextLine();
							}
							// Después de haber introducido el número, nos mandará al menú principal del programa.
						} while (seguir == false);

						break;

					case 9:
						// Variables y funcionalidad del caso 9 (Habitaciones dobles).
						seguir = false;
						do {
							try {
								System.out.println("Introduce las habitaciones dobles que tiene tu hotel");
								int hab_dobles = sc.nextInt();
								lista.get(j).setHab_dobles(hab_dobles);
								//Cuando ya hayamos escrito el número de habitaciones dobles, se nos modificará el número de habitaciones
								//dobles del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
							} catch (InputMismatchException e) {
								System.err.println("Introduzca números");
								sc.nextLine();
							}
							// Después de haber introducido el número, nos mandará al menú principal del programa.
						} while (seguir == false);

						break;

					case 10:
						// Variables y funcionalidad del caso 10 (Habitaciones triples).
						seguir = false;
						do {
							try {
								System.out.println("Introduce las habitaciones triples que tiene tu hotel");
								int hab_triples = sc.nextInt();
								lista.get(j).setHab_triples(hab_triples);
								//Cuando ya hayamos escrito el número de habitaciones triples, se nos modificará el número de habitaciones 
								//triples del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
							} catch (InputMismatchException e) {
								System.err.println("Introduzca números");
								sc.nextLine();
							}
							// Después de haber introducido el número, nos mandará al menú principal del programa.
						} while (seguir == false);

						break;

					case 11:
						// Variables y funcionalidad del caso 11 (Suites).
						seguir = false;
						do {
							try {
								System.out.println("Introduce las suites que tiene tu hotel");
								int suites = sc.nextInt();
								lista.get(j).setSuites(suites);
								//Cuando ya hayamos escrito el número de suites, se nos modificará el número de suites 
								//del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
							} catch (InputMismatchException e) {
								System.err.println("Introduzca números");
								sc.nextLine();
							}
							// Después de haber introducido el número, nos mandará al menú principal del programa.
						} while (seguir == false);

						break;
					}
					//Se ha creado este while, para que funcione las opciones que hayamos indicado, sino nos pondrá de nuevo el menú de
					//modificación
				} while ( opcion <1 || opcion>11 );
			}
		}
		// En el caso de que no hayamos puesto el nombre correcto del hotel, nos saltará a este if, en la cual nos indicará que el hotel
		// que habíamos indicado, no esta en el archivo XML.
		if (existe == false) {
			System.out.println();
			System.out.println("No existe el hotel con el nombre " + nombre1);
			System.out.println();

		}

	}

	// Clase privada, en la cual se hará la funcionalidad de eliminar hoteles que estén dentro del XML.
	private static void eliminarHotel(ArrayList<Hotel> lista, Scanner sc) {
		// Se declarán las variables necesarias, para su funcionamiento. Primero debemos indicar el hotel que queremos eliminar, y se nos im
		// imprimirá los hoteles que estén en el archivo XML. Para seleccionar un hotel, debemos escribir su nombre.
		String nombre = "";
		System.out.println();
		System.out.println("\n¿Que hotel deseas eliminar?. Indique el nombre para poder eliminar el hotel seleccionado.");
		System.out.println();
		leerHotelesLista(lista);
		sc.nextLine();
		nombre = sc.nextLine();
		boolean existe = false;
		
		
		// Se recorre la lista, para encontrar el resultado que hemos puesto anteriormente.
		for (int j = 0; j < lista.size(); j++) {
			
			// Si el nombre que hemos puesto está, se borrara aplicandole un "Remove" a este hotel, y después nos dirá que el hotel se ha eliminado
			// correctamente.
			if (lista.get(j).getNombre().equals(nombre)) {
				existe = true;
				lista.remove(j);
				Hotel delete = new Hotel();
				delete.escribir(lista);
				System.out.println();
				System.out.println("Se ha borrado correctamente el hotel seleccionado.");
				System.out.println();
			}
		}	
		// En el caso contrario, si no se ha encontrado ningún hotel que coincida con el nombre que hayamos puesto, nos indicará el programa+
		// de que no existe el hotel con el nombre escrito anteriormente.
		if (existe == false) {
			System.out.println();
			System.out.println("No existe el hotel con el nombre " + nombre);
			System.out.println();
		}
	}

	// Clase privada, en la cual se hará la funcionalidad de imprimir todos hoteles que estén dentro del XML.
	private static void leerHotelesLista(ArrayList<Hotel> lista) {
		// Con un for, recorremos la lista enterá que tengamos en el XML
		for (int i = 0; i < lista.size(); i++) {
			//Se nos imprimirá todos los hoteles que estén dentro del XML.
			System.out.println(lista.get(i).toString());
		}

	}

	// Clase privada, en la cual se hará la funcionalidad de buscar hoteles que estén dentro del XML.
	private static void buscarHotel(ArrayList<Hotel> lista, Scanner sc) {
		//Declaración de variables.
		int opcion = 0;

		// Dentro del do, vamos a crear un menú para poder buscar el hotel que queramos. Para ello se tiene que indicar por donde lo tenemos que buscar, para
		// ello hay once opciones, en las cuales lo podemos buscar de manera más sencilla. Para seleccionar una opción, tendremos que ingresar el número que
		// este al lado de la opción indicada.
		do {
			boolean seguir = false;
			do {
				try {
					System.out.println(
							"\n¿Por qué deseas filtrar\n1. Nombre\n2. Foto\n3. Teléfono\n4. Dirección\n5. Ciudad\n6. País\n7. Número de estrellas\n8. Habitaciones Individuales\n9. Habitaciones Dobles\n10. Habitaciones Triples\n11. Suites");
					opcion = sc.nextInt();
					seguir = true;
					// En caso de poner un texto o una cadena de carácteres, nos saldrá esta excepción, indicando de que solo se debe ingresar números.
					// Si hemos puesto un número que no coincida con ninguna de las opciones, nos volverá a mostrar el menú de buscar hoteles.
				} catch (InputMismatchException e) {
					System.err.println("Introduzca números");
					sc.nextLine();
				}
			} while (seguir == false);

			// Declaración de variables.
			boolean encontrado = false;
			int j = 0;

			//Se crea un Switch. para poner los casos que haya en el menú
			switch (opcion) {

			// Variables y funcionalidad del caso 1 (Nombre).
			case 1:
				System.out.println("Introduce un nombre");
				String nombre = sc.next();
				// Se recorre la lista.
				for (int i = 0; i < lista.size(); i++) {
					// Si ha encontrado el hotel por el nombre, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
					if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
						encontrado = true;
						j = i;
					}
				}
				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe nigun nombre de hotel llamado  " + nombre);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;
				
			// Variables y funcionalidad del caso 2 (Foto).
			case 2:
				System.out.println("Introduce una foto (Con su extensión correspondiente)");
				String foto = sc.next();
				// Si ha encontrado el hotel por la foto, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getFoto().equalsIgnoreCase(foto)) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
				
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe niguna foto llamada " + foto);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;

			// Variables y funcionalidad del caso 3 (Teléfono).
			case 3:
				seguir = false;
				int telefono = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce un teléfono");
						telefono = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca números".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca números");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ningún valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por el teléfono, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getTelefono() == telefono) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe ningun ningún telefeno llamado" + telefono);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;

			// Variables y funcionalidad del caso 4 (Dirección).
			case 4:
				System.out.println("Introduce una dirección");
				String direccion = sc.next();
				
				// Si ha encontrado el hotel por la dirección, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getDireccion().equalsIgnoreCase(direccion)) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe niguna dirección llamada " + direccion);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;
								
			// Variables y funcionalidad del caso 5 (Ciudad).
			case 5:
				System.out.println("Introduce una ciudad");
				String ciudad = sc.next();
				
				// Si ha encontrado el hotel por la ciudad, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getCiudad().equalsIgnoreCase(ciudad)) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe niguna ciudad llamada " + ciudad);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;

			// Variables y funcionalidad del caso 6 (País).
			case 6:
				System.out.println("Introduce un país");
				String pais = sc.next();
				
				// Si ha encontrado el hotel por el país, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getPais().equalsIgnoreCase(pais)) {
						encontrado = true;
						j =i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.err.println("No existe nigun país llamado " + pais);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;

			// Variables y funcionalidad del caso 7 (Número de estrellas).
			case 7:
				seguir = false;
				int numestrellas = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce el número de estrellas");
						numestrellas = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca números".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca números");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ningún valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por el número de estrellas, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getNumestrellas() == numestrellas) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No hay ningún hotel que tenga " + numestrellas + " estrellas");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;

			// Variables y funcionalidad del caso 8 (Habitaciones individuales).
			case 8:
				seguir = false;
				int hab_indi = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce un número de habitaciones individuales");
						hab_indi = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca números".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca números");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ningún valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por las habitaciones individuales, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getHab_indi() == hab_indi) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe ninguna habitación que tenga " + hab_indi + " habitaciones individuales");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;

			// Variables y funcionalidad del caso 9 (Habitaciones dobles).
			case 9:
				seguir = false;
				int hab_dobles = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce el número de habitaciones dobles");
						hab_dobles = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca números".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca números");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ningún valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por las habitaciones dobles, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getHab_dobles() == hab_dobles) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe ninguna habitación que tenga " + hab_dobles + " habitaciones dobles");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;

			// Variables y funcionalidad del caso 10 (Habitaciones tríples).
			case 10:
				seguir = false;
				int hab_triples = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce el número de habitaciones triples");
						hab_triples = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca números".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca números");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ningún valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por las habitacionesd triples, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getHab_triples() == hab_triples) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe ninguna habitación que tenga " + hab_triples + " habitaciones triples");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;

			// Variables y funcionalidad del caso 11 (Suites).
			case 11:
				seguir = false;
				int suites = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce las suites que tenga el hotel");
						suites = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca números".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca números");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ningún valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por las suites, el boolean "encontrado" pasará a true. Y nos pasará al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getSuites() == suites) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimirá el hotel con todos los datos. Donde estará la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrará un mensaje, indicando que la palabrá que se ha puesto no corresponde a ningún hotel.
				} else {
					System.out.println();
					System.out.println("No existe ningun hotel que tenga " + suites + " suites");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al menú principal.
				break;
			}
		//Mientras las opciones que estén el programa no sean seleccionadas, se volverá a aparecer el menú del programa principal.
		} while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6 && opcion != 7
				&& opcion != 8 && opcion != 9 && opcion != 10 && opcion != 11);
	}
}
