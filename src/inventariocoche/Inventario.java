package inventariocoche;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;




public class Inventario implements ICrudInventario{
	
	private Path rutaInventario;
	private Path rutaOferta;
	
	 public Inventario(Path rutaInventario, Path rutaOferta) {
		this.rutaInventario = rutaInventario;
		this.rutaOferta = rutaOferta;
	}
	 
	 public void cocheExiste() {
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	 }

	@Override
	public void eliminarCoche(String matricula) {
		try {
			if(!existeCoche(matricula)) {
				throw new CocheExistenteException("El coche no se encontra");
			}
			List<String> listaCoche = Files.readAllLines(rutaInventario);	
			List<String> nuevaListaCoche = new ArrayList<String>();
			for(String coche: listaCoche) {
				String[] datos = coche.split(",");
				if(!datos[0].equalsIgnoreCase(matricula)) {
					nuevaListaCoche.add(coche);
				}
			}
			
			Files.write(rutaInventario, nuevaListaCoche);
			
			
		}catch (CocheExistenteException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void anadirCoche(Coche coche) {
		try {
		if(Files.notExists(rutaInventario.getParent())) {
			Files.createDirectories(rutaInventario.getParent());
		}
		if(Files.notExists(rutaInventario)) {
			 Files.createFile(rutaInventario);
		 }
		
		if(existeCoche(coche.getMatrícula())) {
			throw new CocheExistenteException("El coche ya esta registrado");
		}
		
		Files.writeString(rutaInventario, coche.toString()+ System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		}catch (CocheExistenteException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private boolean existeCoche(String matrícula) {
		try {
			List<String> listaCoche = Files.readAllLines(rutaInventario);	
			for(String registro : listaCoche) {
				String[] datos = registro.split(",");
				if(datos[0].equalsIgnoreCase(matrícula)) {
					return true;
				}
			}
			
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return false;
	}

	public void listarCoches() {
		listarArchivo(rutaInventario);
	}
	
	private void listarArchivo(Path ruta) {
		try {
			if(Files.notExists(ruta)) {
				throw new RuntimeException("El archivo no existe");
			}
			List<String> listaCoche = Files.readAllLines(ruta);
			listaCoche.forEach(System.out::println);
		} catch (RuntimeException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void listarCocheOferta() {
		try {
			if(Files.notExists(rutaOferta.getParent())) {
				Files.createDirectories(rutaOferta.getParent());
			}
			if(Files.notExists(rutaOferta)) {
				 Files.createFile(rutaOferta);
			 }
			List<String> listaCoche = Files.readAllLines(rutaInventario);
			List<String> listaCocheOferta = new ArrayList<String>();
			
			for(String coche: listaCoche) {
				String[] datos = coche.split(",");
				double km = Double.parseDouble(datos[2]);
				if(km > 100000){
					double precio = Double.parseDouble(datos[3]);
					listaCocheOferta.add(coche+","+ precio * 0.90);
				}
			}
			if(listaCocheOferta.isEmpty()) {
				throw new CocheExistenteException("No hay coche en oferta");
			}
			
			Files.write(rutaOferta, listaCocheOferta);
			listarArchivo(rutaOferta);
		
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());	
		} catch (CocheExistenteException e) {
			System.out.println(e.getMessage());	
		} catch (IOException e) {
			System.out.println(e.getMessage());	
		}
	}
}
