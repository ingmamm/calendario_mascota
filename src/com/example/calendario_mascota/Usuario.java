package com.example.calendario_mascota;

import android.R.bool;

public class Usuario {

		int id_usuario;
		String user, pass;
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
		public bool getLogueado() {
			return logueado;
		}
		public void setLogueado(bool logueado) {
			this.logueado = logueado;
		}
		
		
}
