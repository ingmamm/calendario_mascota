package com.example.calendario_mascota.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Calendario_MascotasDBOpenHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "mascota.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String CREAR_TABLA_USUARIO = "CREATE TABLE usuario (" +
			"id_usuario INTEGER PRIMARY KEY autoincrement, " +
			"user TEXT, " +
			"pass TEXT, " +
			"logueado BOOL)";
	
	private static final String CREAR_TABLA_MASCOTA = "CREATE TABLE mascota (" +
			"id_mascota INTEGER PRIMARY KEY autoincrement, " +
			"id_usuario INTEGER, " +
			"nombre TEXT, " +
			"tipo TEXT," +
			"raza TEXT," +
			"fecha_nac TEXT)";
	
	private static final String CREAR_TABLA_EVENTO = "CREATE TABLE evento (" +
			"id_evento INTEGER PRIMARY KEY autoincrement, " +
			"id_mascota INTEGER, " +
			"tipo TEXT, " +
			"descripcion TEXT," +
			"fecha TEXT)";
	
	private static final String INSERTAR_USUARIO1 = "INSERT INTO usuario" +
	"(user, pass, logueado) VALUES ('chango', '1234', 'false')";
	
	private static final String INSERTAR_MASCOTA1 = "INSERT INTO mascota" +
			"(id_usuario, nombre, tipo, raza, fecha_nac) VALUES (" +
			"'1', 'pushol', 'perro', 'siberiano', '13-13-13')";
	
	private static final String INSERTAR_MASCOTA2 = "INSERT INTO mascota" +
			"(id_usuario, nombre, tipo, raza, fecha_nac) VALUES (" +
			"'1', 'colita', 'perro', 'golden retriever', '13-13-13')";
	
	private static final String INSERTAR_EVENTO1 = "INSERT INTO evento " +
			"(id_mascota, tipo, descripcion, fecha) VALUES (" +
			"'1','chango', 'hola que tal esto es una prueba', '13-13-13')";
	
	private static final String INSERTAR_EVENTO2 = "INSERT INTO evento " +
			"(id_mascota, tipo, descripcion, fecha) VALUES (" +
			"'1','chango', 'hola que tal esto es una prueba', '13-13-13')";
	
	private static final String INSERTAR_EVENTO3 = "INSERT INTO evento " +
			"(id_mascota, tipo, descripcion, fecha) VALUES (" +
			"'1','chango', 'hola que tal esto es una prueba', '13-13-13')";
	
	private static final String INSERTAR_EVENTO4 = "INSERT INTO evento " +
			"(id_mascota, tipo, descripcion, fecha) VALUES (" +
			"'2','chango', 'hola que tal esto es una prueba', '13-13-13')";
	
	
	public Calendario_MascotasDBOpenHelper (Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREAR_TABLA_USUARIO);
		db.execSQL(CREAR_TABLA_MASCOTA);
		db.execSQL(CREAR_TABLA_EVENTO);
		db.execSQL(INSERTAR_EVENTO1);
		db.execSQL(INSERTAR_EVENTO2);
		db.execSQL(INSERTAR_EVENTO3);
		db.execSQL(INSERTAR_EVENTO4);
		db.execSQL(INSERTAR_MASCOTA1);
		db.execSQL(INSERTAR_MASCOTA2);
		db.execSQL(INSERTAR_USUARIO1);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
