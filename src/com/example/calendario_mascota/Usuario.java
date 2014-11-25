package com.example.calendario_mascota;

import android.R.bool;

public class Usuario {

		int id_usuario;
		String user, pass,nombre ,aPaterno ,aMaterno ,email,fNacimiento ,direccion ;
		bool logueado;
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
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getaPaterno() {
			return aPaterno;
		}
		public void setaPaterno(String aPaterno) {
			this.aPaterno = aPaterno;
		}
		public String getaMaterno() {
			return aMaterno;
		}
		public void setaMaterno(String aMaterno) {
			this.aMaterno = aMaterno;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getfNacimiento() {
			return fNacimiento;
		}
		public void setfNacimiento(String fNacimiento) {
			this.fNacimiento = fNacimiento;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public bool getLogueado() {
			return logueado;
		}
		public void setLogueado(bool logueado) {
			this.logueado = logueado;
		}
		
		
		
}
