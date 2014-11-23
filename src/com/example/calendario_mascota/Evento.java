package com.example.calendario_mascota;


public class Evento {
	
	int id_evento, id_mascota;
	String  tipo, descripcion, fecha_string, fecha;
	
	@Override
	public String toString() {
		return "Evento [descripcion=" + descripcion + "]";
	}
	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public int getId_mascota() {
		return id_mascota;
	}
	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String date) {
		
		this.fecha = date;
	  }
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
