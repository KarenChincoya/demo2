package mx.edu.ulsaoaxaca.demo2.model;

public class Opcion {
	
	private int idPregunta;
	private String opcion;
	
	public Opcion(int idPregunta, String opcion) {
		super();
		this.idPregunta = idPregunta;
		this.opcion = opcion;
	}
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	
	

}
