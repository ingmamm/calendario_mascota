package com.exemple.calendario_mascota.tablas;

public class Usuario {
	private int id_usuario, telefono;
	private String user, pass, nombre, apellido, mail, fehca_nac, direccion;
	private boolean logueado;
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isLogueado() {
		return logueado;
	}
	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}
	
	
}
