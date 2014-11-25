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
import android.widget.EditText;

public class PerfilActivity extends Activity {
	
	private static final String LOG = "PerfilAct";
	
	Calendario_MascotaDataSource datasource;
	String user; 
	Usuario perfil =new Usuario(); 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		
		datasource =new Calendario_MascotaDataSource(this);
		Log.i(LOG, " perfil");
		Intent intent = getIntent();
		Log.i(LOG, " perfil intent");
		user = intent.getStringExtra("user");
		Log.i(LOG, " recibiendo intent " + user);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Log.i(LOG, " recibiendo");
		datasource.openDB();
		perfil = datasource.obtenerPerfil(user);
		
		Log.i(LOG, " recibiendo perfil");
		
		datasource.closeDB();
		
		
		EditText etUsuario = (EditText)findViewById(R.id.etUsuario);
		etUsuario.setHint(perfil.getUser());
		Log.i(LOG, "1");
		EditText etNombre = (EditText)findViewById(R.id.etNombre);
		etNombre.setHint(perfil.getNombre());
		Log.i(LOG, "2");
		EditText etApellido = (EditText)findViewById(R.id.etApellido);
		etApellido.setHint(perfil.getaPaterno()+" "+perfil.getaMaterno());
		Log.i(LOG, "3");
		EditText etEmail = (EditText)findViewById(R.id.etMail);
		etEmail.setHint(perfil.getEmail());
		Log.i(LOG, "4");
		EditText etTelefono = (EditText)findViewById(R.id.etTelefono);
		etTelefono.setHint(String.valueOf( perfil.getTelefono()));
		Log.i(LOG, "5");
		EditText etFNacimiento = (EditText)findViewById(R.id.etFechaNac);
		etFNacimiento.setHint(perfil.getfNacimiento());
		Log.i(LOG, "6");
		EditText etDireccion = (EditText)findViewById(R.id.etDireccion);
		etDireccion.setHint(perfil.getDireccion());
		
		Log.i(LOG, "hola");
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
