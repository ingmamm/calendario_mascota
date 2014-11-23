package com.example.calendario_mascota.db;


import java.util.ArrayList;
import java.util.List;

import android.R.bool;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.calendario_mascota.Evento;
import com.example.calendario_mascota.db.Calendario_MascotasDBOpenHelper;

public class Calendario_MascotaDataSource {
	
	private static final String LOGTAG = "DB";
	private static final String LOG = null;
	SQLiteOpenHelper dbhelper; 
	SQLiteDatabase database;
	
	public Calendario_MascotaDataSource(Context context){
		dbhelper = new Calendario_MascotasDBOpenHelper(context);
	}
	
	public void agregarEvento(int id_mascota, String tipo, String descripcion, String fecha){
		
		List<Evento> eventos = new ArrayList<Evento>();
		
		
		String query = ("INSERT INTO evento" +
			"(id_mascota, tipo, descripcion , fecha) VALUES ('" +
			id_mascota + "','"+ tipo +"', '"+ descripcion +"', '"+ fecha +")");
		
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
		Log.i(LOGTAG, "DB open");
		database = dbhelper.getWritableDatabase();
	}

	public void closeDB(){
		Log.i(LOGTAG, "DB close");
		dbhelper.close();
	}
	
	public int contarEventos(){
		
	
	String query = "SELECT * FROM evento";
	Cursor cursor = database.rawQuery(query, null);
		if(cursor.getCount() > 0){
			return cursor.getCount();
		}
		else
			return 0;
	}
	public boolean autenticar(String user,String pass){
	
		String query = "SELECT * FROM usuario WHEN user="+user+" AND pass="+pass+";";
				
		Cursor cursor = database.rawQuery(query, null);
		
		if (cursor.getCount() == 1) {
			
			modificarUsuario((cursor.getInt(cursor.getColumnIndex("id_usuario"))), "true");
			return true;
		} else {
			return false;
		}	}
	
	public boolean registrarUsuario(String nombre,String aPaterno, String aMaterno,String user, String pass,String email,String fNacimiento){
		
		ContentValues valores = new ContentValues();
		valores.put("nombre", nombre);
		valores.put("aPaterno", aPaterno);
		valores.put("aMaterno", aMaterno);
		valores.put("user", user);
		valores.put("pass", pass);
		valores.put("fNacimiento", fNacimiento);
		
		database.insert("usuario", null, valores);
		Log.i(LOG, "usuario "+ user + " creado");
				
		return true;
		
	}
	
	public void modificarUsuario(int id, String estado){
	  
	    ContentValues valores = new ContentValues();
	    valores.put("id_usuario", id);
	    valores.put("logueado", estado);
	    
	    database.update("usuario", valores, "id_usuario=" + id, null);
	      
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
}
