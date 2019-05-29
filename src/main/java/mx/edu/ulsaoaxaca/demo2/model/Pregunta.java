package mx.edu.ulsaoaxaca.demo2.model;

import java.util.List;

public class Pregunta {

	private int id;
	private int materiaId;
	private String pregunta;
	private List<String> opciones;
	private int respuestaCorrecta;
	
	
	public Pregunta(int id, int materiaId, String pregunta, List<String> opciones, int respuestaCorrecta) {
		super();
		this.id = id;
		this.materiaId = materiaId;
		this.pregunta = pregunta;
		this.opciones = opciones;
		this.respuestaCorrecta = respuestaCorrecta;
	}


	public Pregunta(int materiaId, String pregunta, List<String> opciones, int respuestaCorrecta) {
		super();
		this.materiaId = materiaId;
		this.pregunta = pregunta;
		this.opciones = opciones;
		this.respuestaCorrecta = respuestaCorrecta;
	}
	
	
	
	
	public Pregunta(int materiaId, String pregunta, int respuestaCorrecta) {
		super();
		this.materiaId = materiaId;
		this.pregunta = pregunta;
		this.respuestaCorrecta = respuestaCorrecta;
	}


	public int getMateriaId() {
		return materiaId;
	}
	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public List<String> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}
	public int getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	public void setRespuestaCorrecta(int respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	
}
