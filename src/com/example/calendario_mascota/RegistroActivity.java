package com.example.calendario_mascota;

import com.example.calendario_mascota.db.Calendario_MascotaDataSource;
import com.example.calendario_mascota.LoginActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends LoginActivity {

	private static final String LOG = "RegistroAct";
	
	Calendario_MascotaDataSource datasource;
	
	EditText nombre,aPaterno,aMaterno,user,pass,pass2,fNacimiento,email,direccion;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		datasource =  new Calendario_MascotaDataSource(this);
		
		Log.i(LOG, "iniciando variables " );
//		registro.openDB();
		Log.i(LOG, "iniciando variables " );
		nombre=(EditText)findViewById(R.id.editText1);
		Log.i(LOG, "iniciando variables editText1" );
		aPaterno=(EditText)findViewById(R.id.editText2);
		Log.i(LOG, "iniciando variables editText2" );
		aMaterno=(EditText)findViewById(R.id.editText3);
		Log.i(LOG, "iniciando variables editText3" );
		email=(EditText)findViewById(R.id.editText4);
		Log.i(LOG, "iniciando variables editText4" );
		user=(EditText)findViewById(R.id.editText5);
		Log.i(LOG, "iniciando variables editText5" );
		pass=(EditText)findViewById(R.id.editText6);
		Log.i(LOG, "iniciando variables editText6" );
		pass2=(EditText)findViewById(R.id.editText7);
		Log.i(LOG, "iniciando variables editText7" );
		fNacimiento=(EditText)findViewById(R.id.editText8);
		direccion=(EditText)findViewById(R.id.editText9);
		Log.i(LOG, "iniciando variables editText8" );
		Log.i(LOG, "listo " );
		
		
//		pass.setOnFocusChangeListener(new OnFocusChangeListener() {
//			
//			@Override
//			public void onFocusChange(View arg0, boolean arg1) {
//				// TODO Auto-generated method stub
//				if(pass.getText().toString().isEmpty() || pass.getText().length()<=8){
//					
//					Toast.makeText(getApplicationContext(), "Debe ingresar una contraseña con 8 caracteres.", Toast.LENGTH_SHORT).show();
//					//pass.requestFocus();
//				}
//			}
//		});
//		pass2.setOnFocusChangeListener(new OnFocusChangeListener() {
//			
//			@Override
//			public void onFocusChange(View v, boolean hasFocus) {
//				// TODO Auto-generated method stub
//				if (!pass.equals(pass2)){
//					Toast.makeText(getApplicationContext(), "La contraseña no coinciden", Toast.LENGTH_SHORT).show();
//					//pass2.requestFocus();
//				}
//			}
//		});
//		
//		registro.closeDB();
	}
	public Boolean validarCampos() {
	
		Boolean faltaDato = false;
		Log.i(LOG, "validando campos " );
		
		if (user.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un nombre de usuario", Toast.LENGTH_SHORT).show();
			
			user.requestFocus();
			faltaDato = true;
		}
		datasource.openDB();
		if (datasource.existeUsuario(user.getText().toString())) {
			Toast.makeText(getApplicationContext(), "error el usuario ya existe, intente con otro nombre de usuario ", Toast.LENGTH_SHORT).show();
			user.requestFocus();
			faltaDato = true;
		}
		datasource.closeDB();
		if (nombre.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un nombre", Toast.LENGTH_SHORT).show();
			nombre.requestFocus();
			faltaDato = true;
		}
		if (aPaterno.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un Apellido Paterno", Toast.LENGTH_SHORT).show();
			aPaterno.requestFocus();
			faltaDato = true;
		}
		if (aMaterno.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un Apellido Materno", Toast.LENGTH_SHORT).show();
			aMaterno.requestFocus();
			faltaDato = true;
		}
		if (email.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un Email", Toast.LENGTH_SHORT).show();
			email.requestFocus();
			faltaDato = true;
		}
		if (fNacimiento.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un fecha de nacimiento", Toast.LENGTH_SHORT).show();
			fNacimiento.requestFocus();
			faltaDato = true;
		}
		Log.i(LOG, "validando campos = "+ faltaDato );
		return faltaDato;
		
	}
	
	public boolean validarPass(String pass,String passVerificada) {
		boolean iguales = true;
		if (pass.equals("")){
			Toast.makeText(getApplicationContext(), "Debe ingresar una contraseña con 8 caracteres.", Toast.LENGTH_SHORT).show();
			iguales =false;
			
		}
		if (passVerificada.equals("")){
			Toast.makeText(getApplicationContext(), "Debe reingresar su contraseña", Toast.LENGTH_SHORT).show();
			iguales =false;
		}
		if(!pass.equals(passVerificada)){
			Toast.makeText(getApplicationContext(), "La contraseñas no coinciden, intente otra vez", Toast.LENGTH_SHORT).show();
			iguales =false;
		}
		Log.i(LOG, "validando pass = "+iguales );
		return iguales;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registro, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		Intent intent = new Intent(this,LoginActivity.class);

		switch (item.getItemId()) {
		case android.R.id.home:
			
		
			startActivity(intent);
			
			return true;
		case R.id.registro:
			Log.i(LOG, "btn registro " );
			if(!validarCampos() && validarPass(pass.getText().toString(), pass2.getText().toString())){
				datasource.openDB();
				Log.i(LOG, "if 1 registro  "+ nombre.getText().toString()+" "+ aPaterno.getText().toString()+" "+ aMaterno.getText().toString()+" "+
						user.getText().toString()+" "+ hashPass(pass.getText().toString())+" "+ email.getText().toString()+" "+ fNacimiento.getText().toString());
				
				Log.i(LOG, "registro() " );
				datasource.registrarUsuario(nombre.getText().toString(), aPaterno.getText().toString(), aMaterno.getText().toString(), email.getText().toString(), user.getText().toString(), hashPass(pass.getText().toString()), fNacimiento.getText().toString(),direccion.getText().toString()); 
					Toast.makeText(getApplicationContext(), "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
					Log.i(LOG, "\' registro() " );
					datasource.closeDB();
					startActivity(intent);
				
			}else{
				Toast.makeText(getApplicationContext(), "intente nuevamente", Toast.LENGTH_SHORT).show();
			}
			  datasource.closeDB();
			return true;	
		case R.id.login:
	
			startActivity(intent);
			
			return true;
			
			

		default:
			return super.onOptionsItemSelected(item);
		}
		
		
		
	}
}

