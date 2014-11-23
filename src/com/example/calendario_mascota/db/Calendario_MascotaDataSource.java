package com.example.calendario_mascota.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.calendario_mascota.Evento;
import com.example.calendario_mascota.db.Calendario_MascotasDBOpenHelper;

public class Calendario_MascotaDataSource {
	
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
}
