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
import android.widget.Toast;

public class PerfilActivity extends Activity {
	
	private static final String LOG = "PerfilAct";
	
	Calendario_MascotaDataSource datasource;
	String user,nombre,aPaterno,aMaterno,email,fNacimiento,direccion;
	Usuario perfil =new Usuario(); 
	 EditText etUsuario, etNombre, etApellido, etEmail, etTelefono,etFNacimiento,etDireccion;
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
		
		
		 etUsuario = (EditText)findViewById(R.id.etUsuario);
		etUsuario.setHint(perfil.getUser());
		Log.i(LOG, "1");
		 etNombre = (EditText)findViewById(R.id.etNombre);
		etNombre.setHint(perfil.getNombre());
		Log.i(LOG, "2");
		 etApellido = (EditText)findViewById(R.id.etApellido);
		etApellido.setHint(perfil.getaPaterno()+" "+perfil.getaMaterno());
		Log.i(LOG, "3");
		 etEmail = (EditText)findViewById(R.id.etMail);
		etEmail.setHint(perfil.getEmail());
		Log.i(LOG, "4");
		 etTelefono = (EditText)findViewById(R.id.etTelefono);
		etTelefono.setHint(String.valueOf( perfil.getTelefono()));
		Log.i(LOG, "5");
		 etFNacimiento = (EditText)findViewById(R.id.etFechaNac);
		etFNacimiento.setHint(perfil.getfNacimiento());
		Log.i(LOG, "6");
		 etDireccion = (EditText)findViewById(R.id.etDireccion);
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
		case R.id.guardar:
			int telefono;
			Boolean cambios = false;
			if (etNombre.getText().toString().trim().equals("")) {
				 nombre = perfil.getNombre();
			}
			else{
				nombre = etNombre.getText().toString();
				cambios = true;
			}
			if (etApellido.getText().toString().trim().equals("")) {
				 aPaterno = perfil.getaPaterno();
				 aMaterno = perfil.getaMaterno();
			}
			else{
				// separa el estring en 2 y lo guarda
				String[] apellidosComoArray = etApellido.getText().toString().split(" ");
				 aPaterno = apellidosComoArray[0];
				 aMaterno = apellidosComoArray[1];
				 cambios = true;
			}
			if (etEmail.getText().toString().trim().equals("")) {
				 email = perfil.getEmail();
			}
			else{
				email = etEmail.getText().toString();
				cambios = true;
			}
			if (etFNacimiento.getText().toString().trim().equals("")) {
				fNacimiento = perfil.getfNacimiento();
			}
			else{
				fNacimiento = etFNacimiento.getText().toString();
				cambios = true;
			}
			if (etDireccion.getText().toString().trim().equals("")) {
				direccion = perfil.getDireccion();
			}
			else{
				fNacimiento = etDireccion.getText().toString();
				cambios = true;
			}
			if (etTelefono.getText().toString().trim().equals("")) {
				telefono = perfil.getTelefono();
			}
			else{
				telefono = Integer.parseInt(etTelefono.getText().toString());
				cambios = true;
			}
			Log.i(LOG, "datos = "+nombre+ aPaterno+ aMaterno+ email+ user+ fNacimiento+ direccion+ telefono);
			
			if(cambios){
				Log.i(LOG, " if cambios  ");
				datasource.openDB();
				datasource.mofificarUsuario(nombre, aPaterno, aMaterno, email, user, fNacimiento, direccion, telefono);
				datasource.closeDB();
				Toast.makeText(PerfilActivity.this.getApplicationContext(), "datos actualizados con exito", Toast.LENGTH_SHORT).show();
				}
				else{
					Toast.makeText(PerfilActivity.this.getApplicationContext(), "no se han realizado cambios", Toast.LENGTH_SHORT).show();
				}
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
