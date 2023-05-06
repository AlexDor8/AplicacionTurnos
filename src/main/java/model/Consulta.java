package model;

public class Consulta {
	private int id;
	private String nombre;
	private boolean marcado;
	
	public Consulta(int id, String nombre, boolean marcado) {
		this.id = id;
		this.nombre = nombre;
		this.marcado = marcado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", nombre=" + nombre + ", marcado=" + marcado + "]";
	}
	
	
}
