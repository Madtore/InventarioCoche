package inventariocoche;

import java.nio.file.Path;
import java.nio.file.Paths;



public class App {
	public static void main(String[] args) {
		
		Path rutaInventario = Paths.get("Inventario", "coche.txt");
		Path rutaOferta = Paths.get("Inventario","Oferta","ofertas.txt");
		
		Inventario inventario = new Inventario(rutaInventario, rutaOferta);
		
		inventario.anadirCoche(new Coche("rx4354xx", "Ford", 10000, 20000.00));
		inventario.anadirCoche(new Coche("rx1354xx", "Fiat", 140000, 14000.00));
		inventario.anadirCoche(new Coche("rx2354xx", "Lancia", 60000, 6030.00));
		inventario.anadirCoche(new Coche("rx3354xx", "Alfa Romeo", 12100, 30.00));
		inventario.anadirCoche(new Coche("rx5354xx", "Seat", 1000000, 2030.00));
		System.out.println("------");
		inventario.listarCoches();
		System.out.println("------");
		inventario.anadirCoche(new Coche("rx4354xx", "Mazda", 100, 20000.00));
		inventario.anadirCoche(new Coche("ax4354cx", "Mazda", 100, 20000.00));
		inventario.eliminarCoche("rx4354xx");
		System.out.println("------");
		inventario.listarCoches();
		System.out.println("------");
		inventario.anadirCoche(new Coche("rx4354xx", "Ford", 10000, 20000.00));
		System.out.println("------");
		inventario.listarCoches();
		System.out.println("------");
		System.out.println("------");
		System.out.println("------");
		inventario.listarCocheOferta();
	}

}
