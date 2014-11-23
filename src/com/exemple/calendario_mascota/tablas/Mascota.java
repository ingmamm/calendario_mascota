package com.exemple.calendario_mascota.tablas;

public class Mascota {
	private int  id_mascota, id_usuario;
	private String nombre, tipo, raza, fecha_nac;
	public int getId_mascota() {
		return id_mascota;
	}
	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	
	
}
