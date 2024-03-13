package inventariocoche;


public interface ICrudInventario {
	
	void eliminarCoche(String matricula);
	
	void anadirCoche(Coche coche);
	
	void listarCocheOferta();

	void listarCoches();
	
}
