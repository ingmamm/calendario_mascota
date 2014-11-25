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

public class Calendario_MascotaDataSource {
	
	private static final String LOG = "dataSource";
	SQLiteOpenHelper dbhelper; 
	SQLiteDatabase database;
	
	public Calendario_MascotaDataSource(Context context){
		dbhelper = new Calendario_MascotasDBOpenHelper(context);
	}
	
	public void agregarEvento(int id_mascota, String tipo, String descripcion, String fecha){
		
		List<Evento> eventos = new ArrayList<Evento>();
		
		
		String query = ("INSERT INTO evento" +
			"(id_mascota, tipo, descripcion ,fecha) VALUES ('" +
			id_mascota + "','"+ tipo +"', '"+ descripcion +"', '"+ fecha +"')");
		
		Cursor cursor = database.rawQuery(query, null);
		
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Evento evento = new Evento();
				evento.setId_evento(cursor.getInt(cursor.getColumnIndex("id_evento")));
				evento.setId_mascota(cursor.getInt(cursor.getColumnIndex("id_mascota")));
				evento.setTipo(cursor.getString(cursor.getColumnIndex("tipo")));
				evento.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
				evento.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
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
				eventos.add(evento);
			}
			
		}
		return eventos;
	}
	
	public String[] obtenerMascota(){
		
		String[] campos = new String[] {"nombre"};
		String[] nombre_mascota= new String[]{};
		int count = 0;
		Cursor c = database.query("mascota", campos, "nombre=?", null, null, null, null);
		 
		//Nos aseguramos de que existe al menos un registro
		if (c.moveToFirst()) {
		     //Recorremos el cursor hasta que no haya más registros
		     do {
		          nombre_mascota[count] = c.getString(count);
		     } while(c.moveToNext());
		}
		
		return nombre_mascota;
	}
	
	//funciones para el login
	
		public boolean autenticar(String user,String pass){
			
			
			String query = "SELECT * FROM usuario where user="+user+" and pass="+pass+";";
					
			Cursor cursor = database.rawQuery(query, null);
			
			if (cursor.getCount() == 1) {
				
				modificarUsuario((cursor.getInt(cursor.getColumnIndex("id_usuario"))), true);
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
		  
		    ContentValues valores = new ContentValues();
		    valores.put("id_usuario", id);
		    valores.put("logueado", estado);
		    
		    database.update("usuario", valores, "id_usuario=" + id, null);
		      
		}
}
