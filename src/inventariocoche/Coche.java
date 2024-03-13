package inventariocoche;

public class Coche {
	private String matrícula;
	private String marca;
	private int kilometraje;
	private double precio;
	
	public Coche(String matrícula, String marca, int kilometraje, double precio) {
		this.matrícula = matrícula;
		this.marca = marca;
		this.kilometraje = kilometraje;
		this.precio = precio;
	}

	public String getMatrícula() {
		return matrícula;
	}

	public String getMarca() {
		return marca;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return matrícula + "," + marca + "," + kilometraje + ","+ precio;
	}
	
}
