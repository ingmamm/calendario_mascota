package com.example.calendario_mascota;

import java.util.List;

import com.example.calendario_mascota.db.Calendario_MascotaDataSource;
import com.example.calendario_mascota.lib.UsuarioAdapter;
import com.exemple.calendario_mascota.tablas.Usuario;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class PerfilActivity extends Activity {
	
	List<Usuario> usuarios;
	Calendario_MascotaDataSource datasource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
//		Log.i(null, "hola");
//		
//		datasource = new Calendario_MascotaDataSource(this);
//		datasource.openDB();
//		usuarios = datasource.obtenerUsuario();
//		
//		UsuarioAdapter adapter = new UsuarioAdapter(this, R.layout.activity_perfil, usuarios);
//		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Intent intent_menu = new Intent(this, MenuActivity.class);
		Intent intent_login = new Intent(this, LoginActivity.class);
		
		switch (id) {
		case android.R.id.home:
			startActivity(intent_menu);
			break;
		case R.id.deslogueo:
			startActivity(intent_login);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
