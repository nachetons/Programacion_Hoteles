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
		// para poder leer variables y hacer saltos de linea, tambi�n esta la variable Hotel, el boolean "seguir" para poder 
		// seguir utilizando el programa o pararlo y una variable "lista", para poder leer los datos que tengamos en el XML.
		
		ArrayList<Hotel> lista = new ArrayList<Hotel>();
		Scanner sc = new Scanner(System.in);
		Hotel hotel = new Hotel();
		lista = hotel.leer();
		boolean seguir = true;
		while (seguir) {
			// Aqu� se nos imprimira el men�.
			System.out.println("�Que deseas hacer?\n1. A�adir Hotel\n2. Modificar"
					+ " Hotel\n3. Eliminar Hotel\n4. Imprimir los Hoteles existentes"
					+ "\n5. Buscar un hotel\n6. Log out");
			// Variable entera, en la cual podemos indicar la opci�n que queramos del men�
			int opcion = 0;
			do {
				try {
					opcion = sc.nextInt();

					// Si se introduce alg�n car�cter que no sea entero. Saltar� esta excepci�n
				} catch (InputMismatchException e) {
					System.err.println("Introduzca n�meros");
					sc.nextLine();
				}
				
				// Se crea un Switch, y en cada caso estar� su m�todo correspondiente.
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
				// Y si se introduce cualquier n�mero que no este entre el 1 y el 6. Saltar� el default, en la cual
				// saltar�a el mensaje de opci�n incorrecto, y se volver� a repetir el men� (con el While).
				default:
					System.out.println("Opci�n incorrecta. Del 1 al 6");
					break;
				}
			} while (opcion > 6 || opcion < 1);
		}

	}

	// Clase privada, en la cual se har� la funcionalidad de a�adir hoteles al XML.
	private static void anadirHotel(ArrayList<Hotel> lista, Scanner sc) {
		
		// Para poder a�adir un hotel , se deber� responder a las siguientes preguntas, que dependiendo de la pregunta,
		// se contestar� con un entero (un n�mero), un texto o una cadena de textos.
		
		//Primero se declarar�n las variables "String".
		System.out.println("");
		System.out.println("Dime el nombre del hotel");
		sc.nextLine();
		String nombre = sc.nextLine();
		
		System.out.println("Dime la foto, con su extensi�n correspondiente");
		String foto = sc.next();
		
		System.out.println("Dime la direcci�n del hotel");
		sc.nextLine();
		String direccion = sc.nextLine();
		
		System.out.println("Dime el nombre de la ciudad");
		String ciudad = sc.nextLine();
		
		System.out.println("Dime el nombre del pa�s");
		String pais = sc.next();
		sc.nextLine();
		
		//Y despu�s la declaraci�n de variables enteros.
		
		int telefono = 0;
		int numestrellas = 0;
		int hab_indi = 0;
		int hab_dobles = 0;
		int hab_triples = 0;
		int suites = 0;
		boolean seguir = false;

		do {
			// Se hace un do, en el caso de que se equivoque en la pregunta, se volver� a preguntar (esto pasa cuando 
			// se introduce un String, en vez de un int), esto pasa en el catch, en cada una de las preguntas..
			// Esto se hace en todas las preguntas con variable int. 
			try {
				System.out.println("Dime el tel�fono");
				telefono = sc.nextInt();
				seguir = true;

			} catch (InputMismatchException e) {
				System.err.println("Introduzca n�meros");
				System.out.println("");
				sc.nextLine();
			}
		}while (seguir == false);
		
		seguir = false;

		do {
			try {
				System.out.println("�Cuantas estrellas tiene tu hotel?");
				numestrellas = sc.nextInt();
				seguir = true;

			} catch (InputMismatchException e) {
				System.err.println("Introduzca n�meros");
				sc.nextLine();
			}
		}while (seguir == false);
		
		seguir = false;
		
		do {
			try {
				System.out.println("�Cuantas habitaciones individuales tiene tu hotel?");
				hab_indi = sc.nextInt();
				seguir = true;

			} catch (InputMismatchException e) {
				System.err.println("Introduzca n�meros");
				sc.nextLine();
			}
		}while (seguir == false);
		
		seguir = false;
		
		do{
			try {
				System.out.println("�Cuantas habitaciones dobles tiene tu hotel?");
				hab_dobles = sc.nextInt();
				seguir=true;
	
			} catch (InputMismatchException e) {
				System.err.println("Introduzca n�meros");
				sc.nextLine();
			}
		}while (seguir == false);
		
		seguir = false;
		
		do{
			try {
				System.out.println("�Cuantas habitaciones triples tiene tu hotel?");
				hab_triples = sc.nextInt();
				seguir=true;
	
			} catch (InputMismatchException e) {
				System.err.println("Introduzca n�meros");
				sc.nextLine();
			}
		}while(seguir == false);
		
		seguir = false;
		
		do{
			try {
				System.out.println("�Cuantas suites tiene tu hotel?");
				suites = sc.nextInt();
				seguir = true;
	
			} catch (InputMismatchException e) {
				System.err.println("Introduzca n�meros");
				sc.nextLine();
			}
		}while(seguir == false);

		// Si se han respondido todas las preguntas correctamente, nos saltar� un mensaje, indicando
		//  de que el hotel se ha a�adido con �xito y se nos modificar� el XML, a�adiendo el nuevo hotel que hayamos indicado.
		Hotel newHotel = new Hotel(nombre, foto, telefono, direccion, ciudad, pais, numestrellas, hab_indi, hab_dobles,
				hab_triples, suites);
		lista.add(newHotel);
		System.out.println("Hotel a�adido con �xito");

		newHotel.escribir(lista);

	}

	// Clase privada, en la cual se har� la funcionalidad de modificar hoteles que est�n dentro del XML.
	private static void modificarHotel(ArrayList<Hotel> lista, Scanner sc) {
		
		// Nos indicar� previamente, que hotel deseamos modificar. Y se nos imprimir� los hoteles que tenemos 
		// en el XML. Para modificar un hotel, debemos escribir el hotel. Si nos equivocamos, nos dir� que no existe 
		// ning�n hotel con ese nombre, y volver� al man�.
		
		// Tambi�n tenemos las variables declaradas en este factor.
		String nombre1 = "";
		System.out.println("\n�Que hotel deseas modificar?. Indique el hotel poniendo el nombre.");
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
			
			// En el caso de que exista el nombre, nos saltar� un nuevo men�. En la que se indicar� que es los que queremos 
			// modificar.
			if (lista.get(j).getNombre().equals(nombre1)) {
				existe = true;
				do {

					boolean seguir = false;
					do {
						
						// Para responder a la secci�n que queremos, se debe introducir el n�mero que este al lado de la opci�n
						// que queramos seleccionar. Si introducirmos un n�mero mayor o un texto, saltara una excepci�n, indicando
						// que solo se debe introducir n�meros, y que est�n relacionados con opci�n que queramos. Y se nos volver�
						// a repetir el men� de modificar hoteles.
						try {
							System.out.println(
									"\n�Que deseas modificar?\n1. Nombre\n2. Foto\n3. Tel�fono\n4. Direcci�n\n5. Ciudad\n6. Pa�s\n7. N�mero de estrellas\n8. Habitaciones Individuales\n9. Habitaciones Dobles\n10. Habitaciones Triples\n11. Suites");
							opcion = sc.nextInt();
							seguir = true;
						} catch (InputMismatchException e) {
							System.err.println("Introduzca n�meros");
							sc.nextLine();
						}
					} while (seguir == false);
					switch (opcion) {

					// En el caso de qeu hayamos seleccionado un n�mero correcto, nos saltar� la pregunta que este relacionada
					// con la opci�n que hayamos indicado, para que lo podamos modificar. Esta desarrollado mediante un Switch
					// para que podamos seleccionar la opci�n correspondiente.
					
					// Desde el caso 1, hasta el 6, se podr� introducir cadenas de texto.
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
						// Se ha realizado correctamente, y se modificar� el hotel que estuvo previamente. Y saltar� un mensaje
						// "Modificado con �xito". Si se ha introducido el mismo nombre, se nos volver� a repetir el men� de mo-
						// dificar
						if (encontrado == false) {
							lista.get(j).setNombre(nombre);
							// a�adir al XML
							lista.get(j).escribir(lista);
							System.out.println("Modificado con exito");
						}

						break;

					case 2:
						// Variables y funcionalidad del caso 2 (foto).
						seguir = false;
						System.out.println("Introduce la nueva foto, con su extensi�n correspondiente.");
						String foto = sc.next();
						lista.get(j).setFoto(foto);
						//Cuando ya hayamos escrito la foto, se nos modificar� la foto del hotel que hayamos seleccionado.
						lista.get(j).escribir(lista);
						System.out.println("Modificado con exito");

						break;

					case 3:
						// Variables y funcionalidad del caso 3 (tel�fono).
						seguir = false;
						do {
							try {
								System.out.println("Introduce el tel�fono");
								int telefono = sc.nextInt();
								lista.get(j).setTelefono(telefono);
								;
								//Cuando ya hayamos escrito el tel�fono, se nos modificar� el tel�fono del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
								// Si en vez de escribir un n�mero hemos escrito una cadena de caracteres, nos saldr� esta excepci�n, in-
								// dicandonos de que tenemos que introducir n�meros, y nos volver� a preguntar el n�mero de tel�fono.
							} catch (InputMismatchException e) {
								System.err.println("Introduzca n�meros");
								sc.nextLine();
							}
							// Despu�s de haber introducido el n�mero, nos mandar� al men� principal del programa.
						} while (seguir == false);

						break;

					case 4:
						// Variables y funcionalidad del caso 4 (direcci�n).
						seguir = false;
						System.out.println("Introduce la nueva direcci�n");
						sc.nextLine();
						String direccion = sc.nextLine();
						lista.get(j).setDireccion(direccion);
						//Cuando ya hayamos escrito la direcci�n, se nos modificar� la direcci�n del hotel que hayamos seleccionado.
						lista.get(j).escribir(lista);
						System.out.println("Modificado con exito");

						break;

					case 5:
						// Variables y funcionalidad del caso 5 (ciudad).
						System.out.println("Introduce la nueva ciudad");
						sc.nextLine();
						String ciudad = sc.nextLine();
						lista.get(j).setCiudad(ciudad);
						//Cuando ya hayamos escrito la ciudad, se nos modificar� la ciudad del hotel que hayamos seleccionado.
						lista.get(j).escribir(lista);
						System.out.println("Modificado con exito");

						break;

					case 6:
						// Variables y funcionalidad del caso 6 (pa�s).
						System.out.println("Introduce un nuevo Pa�s");
						sc.nextLine();
						String pais = sc.nextLine();
						lista.get(j).setPais(pais);
						//Cuando ya hayamos escrito el pa�s, se nos modificar� el pa�s del hotel que hayamos seleccionado.
						lista.get(j).escribir(lista);
						System.out.println("Modificado con exito");

						break;

					case 7:
						// Variables y funcionalidad del caso 7 (N�mero de estrellas).
						seguir = false;
						do {
							try {
								System.out.println("Introduce el n�mero de estrellas que tiene tu hotel");
								int numestrellas = sc.nextInt();
								lista.get(j).setNumestrellas(numestrellas);
								//Cuando ya hayamos escrito el n�mero de estrellas, se nos modificar� el n�mero de estrellas 
								//del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
								// Si en vez de escribir un n�mero hemos escrito una cadena de caracteres, nos saldr� esta excepci�n, in-
								// dicandonos de que tenemos que introducir n�meros, y nos volver� a preguntar el n�mero de estrellas.
							} catch (InputMismatchException e) {
								System.err.println("Introduzca n�meros");
								sc.nextLine();
							}
							// Despu�s de haber introducido el n�mero, nos mandar� al men� principal del programa.
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
								//Cuando ya hayamos escrito el n�mero de habitaciones dobles, se nos modificar� el n�mero de habitaciones
								//individuales del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
							} catch (InputMismatchException e) {
								System.err.println("Introduzca n�meros");
								sc.nextLine();
							}
							// Despu�s de haber introducido el n�mero, nos mandar� al men� principal del programa.
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
								//Cuando ya hayamos escrito el n�mero de habitaciones dobles, se nos modificar� el n�mero de habitaciones
								//dobles del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
							} catch (InputMismatchException e) {
								System.err.println("Introduzca n�meros");
								sc.nextLine();
							}
							// Despu�s de haber introducido el n�mero, nos mandar� al men� principal del programa.
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
								//Cuando ya hayamos escrito el n�mero de habitaciones triples, se nos modificar� el n�mero de habitaciones 
								//triples del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
							} catch (InputMismatchException e) {
								System.err.println("Introduzca n�meros");
								sc.nextLine();
							}
							// Despu�s de haber introducido el n�mero, nos mandar� al men� principal del programa.
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
								//Cuando ya hayamos escrito el n�mero de suites, se nos modificar� el n�mero de suites 
								//del hotel que hayamos seleccionado.
								lista.get(j).escribir(lista);
								System.out.println("Modificado con exito");
								seguir = true;
							} catch (InputMismatchException e) {
								System.err.println("Introduzca n�meros");
								sc.nextLine();
							}
							// Despu�s de haber introducido el n�mero, nos mandar� al men� principal del programa.
						} while (seguir == false);

						break;
					}
					//Se ha creado este while, para que funcione las opciones que hayamos indicado, sino nos pondr� de nuevo el men� de
					//modificaci�n
				} while ( opcion <1 || opcion>11 );
			}
		}
		// En el caso de que no hayamos puesto el nombre correcto del hotel, nos saltar� a este if, en la cual nos indicar� que el hotel
		// que hab�amos indicado, no esta en el archivo XML.
		if (existe == false) {
			System.out.println();
			System.out.println("No existe el hotel con el nombre " + nombre1);
			System.out.println();

		}

	}

	// Clase privada, en la cual se har� la funcionalidad de eliminar hoteles que est�n dentro del XML.
	private static void eliminarHotel(ArrayList<Hotel> lista, Scanner sc) {
		// Se declar�n las variables necesarias, para su funcionamiento. Primero debemos indicar el hotel que queremos eliminar, y se nos im
		// imprimir� los hoteles que est�n en el archivo XML. Para seleccionar un hotel, debemos escribir su nombre.
		String nombre = "";
		System.out.println();
		System.out.println("\n�Que hotel deseas eliminar?. Indique el nombre para poder eliminar el hotel seleccionado.");
		System.out.println();
		leerHotelesLista(lista);
		sc.nextLine();
		nombre = sc.nextLine();
		boolean existe = false;
		
		
		// Se recorre la lista, para encontrar el resultado que hemos puesto anteriormente.
		for (int j = 0; j < lista.size(); j++) {
			
			// Si el nombre que hemos puesto est�, se borrara aplicandole un "Remove" a este hotel, y despu�s nos dir� que el hotel se ha eliminado
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
		// En el caso contrario, si no se ha encontrado ning�n hotel que coincida con el nombre que hayamos puesto, nos indicar� el programa+
		// de que no existe el hotel con el nombre escrito anteriormente.
		if (existe == false) {
			System.out.println();
			System.out.println("No existe el hotel con el nombre " + nombre);
			System.out.println();
		}
	}

	// Clase privada, en la cual se har� la funcionalidad de imprimir todos hoteles que est�n dentro del XML.
	private static void leerHotelesLista(ArrayList<Hotel> lista) {
		// Con un for, recorremos la lista enter� que tengamos en el XML
		for (int i = 0; i < lista.size(); i++) {
			//Se nos imprimir� todos los hoteles que est�n dentro del XML.
			System.out.println(lista.get(i).toString());
		}

	}

	// Clase privada, en la cual se har� la funcionalidad de buscar hoteles que est�n dentro del XML.
	private static void buscarHotel(ArrayList<Hotel> lista, Scanner sc) {
		//Declaraci�n de variables.
		int opcion = 0;

		// Dentro del do, vamos a crear un men� para poder buscar el hotel que queramos. Para ello se tiene que indicar por donde lo tenemos que buscar, para
		// ello hay once opciones, en las cuales lo podemos buscar de manera m�s sencilla. Para seleccionar una opci�n, tendremos que ingresar el n�mero que
		// este al lado de la opci�n indicada.
		do {
			boolean seguir = false;
			do {
				try {
					System.out.println(
							"\n�Por qu� deseas filtrar\n1. Nombre\n2. Foto\n3. Tel�fono\n4. Direcci�n\n5. Ciudad\n6. Pa�s\n7. N�mero de estrellas\n8. Habitaciones Individuales\n9. Habitaciones Dobles\n10. Habitaciones Triples\n11. Suites");
					opcion = sc.nextInt();
					seguir = true;
					// En caso de poner un texto o una cadena de car�cteres, nos saldr� esta excepci�n, indicando de que solo se debe ingresar n�meros.
					// Si hemos puesto un n�mero que no coincida con ninguna de las opciones, nos volver� a mostrar el men� de buscar hoteles.
				} catch (InputMismatchException e) {
					System.err.println("Introduzca n�meros");
					sc.nextLine();
				}
			} while (seguir == false);

			// Declaraci�n de variables.
			boolean encontrado = false;
			int j = 0;

			//Se crea un Switch. para poner los casos que haya en el men�
			switch (opcion) {

			// Variables y funcionalidad del caso 1 (Nombre).
			case 1:
				System.out.println("Introduce un nombre");
				String nombre = sc.next();
				// Se recorre la lista.
				for (int i = 0; i < lista.size(); i++) {
					// Si ha encontrado el hotel por el nombre, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
					if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
						encontrado = true;
						j = i;
					}
				}
				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe nigun nombre de hotel llamado  " + nombre);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;
				
			// Variables y funcionalidad del caso 2 (Foto).
			case 2:
				System.out.println("Introduce una foto (Con su extensi�n correspondiente)");
				String foto = sc.next();
				// Si ha encontrado el hotel por la foto, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getFoto().equalsIgnoreCase(foto)) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
				
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe niguna foto llamada " + foto);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;

			// Variables y funcionalidad del caso 3 (Tel�fono).
			case 3:
				seguir = false;
				int telefono = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce un tel�fono");
						telefono = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca n�meros".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca n�meros");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ning�n valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por el tel�fono, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getTelefono() == telefono) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe ningun ning�n telefeno llamado" + telefono);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;

			// Variables y funcionalidad del caso 4 (Direcci�n).
			case 4:
				System.out.println("Introduce una direcci�n");
				String direccion = sc.next();
				
				// Si ha encontrado el hotel por la direcci�n, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getDireccion().equalsIgnoreCase(direccion)) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe niguna direcci�n llamada " + direccion);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;
								
			// Variables y funcionalidad del caso 5 (Ciudad).
			case 5:
				System.out.println("Introduce una ciudad");
				String ciudad = sc.next();
				
				// Si ha encontrado el hotel por la ciudad, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getCiudad().equalsIgnoreCase(ciudad)) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe niguna ciudad llamada " + ciudad);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;

			// Variables y funcionalidad del caso 6 (Pa�s).
			case 6:
				System.out.println("Introduce un pa�s");
				String pais = sc.next();
				
				// Si ha encontrado el hotel por el pa�s, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getPais().equalsIgnoreCase(pais)) {
						encontrado = true;
						j =i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.err.println("No existe nigun pa�s llamado " + pais);
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;

			// Variables y funcionalidad del caso 7 (N�mero de estrellas).
			case 7:
				seguir = false;
				int numestrellas = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce el n�mero de estrellas");
						numestrellas = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca n�meros".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca n�meros");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ning�n valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por el n�mero de estrellas, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getNumestrellas() == numestrellas) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No hay ning�n hotel que tenga " + numestrellas + " estrellas");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;

			// Variables y funcionalidad del caso 8 (Habitaciones individuales).
			case 8:
				seguir = false;
				int hab_indi = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce un n�mero de habitaciones individuales");
						hab_indi = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca n�meros".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca n�meros");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ning�n valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por las habitaciones individuales, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getHab_indi() == hab_indi) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe ninguna habitaci�n que tenga " + hab_indi + " habitaciones individuales");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;

			// Variables y funcionalidad del caso 9 (Habitaciones dobles).
			case 9:
				seguir = false;
				int hab_dobles = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce el n�mero de habitaciones dobles");
						hab_dobles = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca n�meros".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca n�meros");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ning�n valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por las habitaciones dobles, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getHab_dobles() == hab_dobles) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe ninguna habitaci�n que tenga " + hab_dobles + " habitaciones dobles");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;

			// Variables y funcionalidad del caso 10 (Habitaciones tr�ples).
			case 10:
				seguir = false;
				int hab_triples = 0;
				do {
					//Se crea un try y un catch, ya que es un valor entero lo que se debe introducir.
					try {
						System.out.println("Introduce el n�mero de habitaciones triples");
						hab_triples = sc.nextInt();
						seguir = true;
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca n�meros".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca n�meros");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ning�n valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por las habitacionesd triples, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getHab_triples() == hab_triples) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe ninguna habitaci�n que tenga " + hab_triples + " habitaciones triples");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
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
					//Si no hemos introducido un valor entero, salta el catch, y nos muestra el mensaje de "Introduzca n�meros".
					} catch (InputMismatchException e) {
						System.err.println("Introduzca n�meros");
						sc.nextLine();
					}
				//Se repite la pregunta, en el caso de no haber escrito ning�n valor entero.
				} while (seguir == false);

				// Si ha encontrado el hotel por las suites, el boolean "encontrado" pasar� a true. Y nos pasar� al siguiente if.
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getSuites() == suites) {
						encontrado = true;
						j = i;
					}
				}

				// Si lo ha encontrado, se imprimir� el hotel con todos los datos. Donde estar� la palabra que hayamos ingresado anteriormente.
				if (encontrado) {
					System.out.print(lista.get(j).toString());
					
					//En caso contrario, se nos mostrar� un mensaje, indicando que la palabr� que se ha puesto no corresponde a ning�n hotel.
				} else {
					System.out.println();
					System.out.println("No existe ningun hotel que tenga " + suites + " suites");
					System.out.println();
				}
				
				// Al finalizar, regresaremos al men� principal.
				break;
			}
		//Mientras las opciones que est�n el programa no sean seleccionadas, se volver� a aparecer el men� del programa principal.
		} while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6 && opcion != 7
				&& opcion != 8 && opcion != 9 && opcion != 10 && opcion != 11);
	}
}
