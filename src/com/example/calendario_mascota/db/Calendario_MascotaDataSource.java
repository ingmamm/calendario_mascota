package com.example.calendario_mascota.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.calendario_mascota.db.Calendario_MascotasDBOpenHelper;
import com.exemple.calendario_mascota.tablas.Evento;
import com.exemple.calendario_mascota.tablas.Usuario;

public class Calendario_MascotaDataSource {
	
	private static final String LOG = "dataSource";
	SQLiteOpenHelper dbhelper; 
	SQLiteDatabase database;
	
	public Calendario_MascotaDataSource(Context context){
		dbhelper = new Calendario_MascotasDBOpenHelper(context);
	}
	
	public void agregarEvento(int id_mascota, String tipo, String descripcion, String fecha, String nombre_mascota){
		
		List<Evento> eventos = new ArrayList<Evento>();
		
		
		String query = ("INSERT INTO evento" +
			"(id_mascota, tipo, descripcion ,fecha, nombre_mascota) VALUES ('" +
			id_mascota + "','"+ tipo +"', '"+ descripcion +"', '"+ fecha +"','"+ nombre_mascota +"')");
		
		Cursor cursor = database.rawQuery(query, null);
		
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Evento evento = new Evento();
				evento.setId_evento(cursor.getInt(cursor.getColumnIndex("id_evento")));
				evento.setId_mascota(cursor.getInt(cursor.getColumnIndex("id_mascota")));
				evento.setTipo(cursor.getString(cursor.getColumnIndex("tipo")));
				evento.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
				evento.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
				evento.setNombre_mascota(cursor.getString(cursor.getColumnIndex("nombre_mascota")));
				eventos.add(evento);
			}
			
		}
	}
	
	public void openDB(){
		database = dbhelper.getWritableDatabase();
	}

	public void closeDB(){
		dbhelper.close();
	}
	
	public List<Evento> obtenerEventos(){
		List<Evento> eventos = new ArrayList<Evento>();
		
		String query = "SELECT * FROM evento";
		Cursor cursor = database.rawQuery(query, null);
		
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Evento evento = new Evento();
				evento.setId_evento(cursor.getInt(cursor.getColumnIndex("id_evento")));
				evento.setId_mascota(cursor.getInt(cursor.getColumnIndex("id_mascota")));
				evento.setTipo(cursor.getString(cursor.getColumnIndex("tipo")));
				evento.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
				evento.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
				evento.setNombre_mascota(cursor.getString(cursor.getColumnIndex("nombre_mascota")));	
				eventos.add(evento);
			}
			
		}
		return eventos;
	}
	
	public List<Usuario> obtenerUsuario(){
		List<Usuario> usuarios = new ArrayList<Usuario>();

		String query = "SELECT * FROM usuario";
		Cursor cursor = database.rawQuery(query, null);
		
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
				usuario.setApellido(cursor.getString(cursor.getColumnIndex("apellido")));
				usuario.setUser(cursor.getString(cursor.getColumnIndex("user")));
				usuario.setMail(cursor.getString(cursor.getColumnIndex("mail")));
				usuario.setTelefono(cursor.getInt(cursor.getColumnIndex("telefono")));
				usuario.setDireccion(cursor.getString(cursor.getColumnIndex("direccion")));	
				usuarios.add(usuario);
			}
			
		}
		return usuarios;
	}
	
	//funciones para el login
	
		public boolean autenticar(String user,String pass){
			
			
			String query = "SELECT * FROM usuario where user='"+user+"' and pass='"+pass+"';";
			Log.i(LOG, " creando consulta " +query);		
			Cursor cursor = database.rawQuery(query, null);
			Log.i(LOG, " creando  cursor " );
			cursor.moveToNext();
			int id = cursor.getInt(cursor.getColumnIndex("id_usuario"));
			if (cursor.getCount() == 1) {
				Log.i(LOG, " cursor "+ cursor.getCount()+" ");
				
				
				modificarUsuario(id, true);
//				Log.i(LOG, " cursor2 " + cursor.getString(cursor.getColumnIndex("logueado")));
				return true;
			} else {
				return false;
				}	
			}
		public void registrarUsuario(String nombre,String aPaterno, String aMaterno,String email,String user, String pass,String fNacimiento){
			
			
			Log.i(LOG, " creando usuario ");
			
			ContentValues valores = new ContentValues();
			valores.put("nombre", nombre);
			valores.put("aPaterno", aPaterno);
			valores.put("aMaterno", aMaterno);
			valores.put("user", user);
			valores.put("pass", pass);
			valores.put("fNacimiento", fNacimiento);
			
		    database.insert("usuario", null, valores);
			Log.i(LOG, "usuario "+ user + " creado");
					
			
			
		}
		
		public void modificarUsuario(int id, Boolean estado){
			Log.i(LOG, " M usuarior " );
		    ContentValues valores = new ContentValues();
		    valores.put("id_usuario", id);
		    valores.put("logueado", estado);
		    
		    database.update("usuario", valores, "id_usuario=" + id, null);
		      
		}
		
		public Boolean existeUsuario(String user){
			
			Log.i(LOG, "Eusuario "+ user + " ");
			
			String query = "SELECT * FROM usuario where user='"+user+"';";
			Log.i(LOG, "Eusuario query "+ query);
			
			Cursor cursor = database.rawQuery(query, null);
			Log.i(LOG, "Eusuario cursor");
			if (cursor.getCount() > 0) {
				
				Log.i(LOG, "Eusuario numero de filas" + " ");		
				
				return true;
				} 
			else
				{
				return false;
				}	
			}
			
		
}
