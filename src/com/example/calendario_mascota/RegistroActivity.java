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
	
	Calendario_MascotaDataSource registro;
	
	EditText nombre,aPaterno,aMaterno,user,pass,pass2,fNacimiento,email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
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
			
			if(!validarCampos() && validarPass(pass.getText().toString(), pass2.getText().toString())){
			
				
				if (registro.registrarUsuario(nombre.getText().toString(), aPaterno.getText().toString(), aMaterno.getText().toString(),
						user.getText().toString(), hashPass(pass.getText().toString()), email.getText().toString(), fNacimiento.getText().toString())) {
					Toast.makeText(getApplicationContext(), "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
				}
				else{
					Toast.makeText(getApplicationContext(), "intente nuevamente", Toast.LENGTH_SHORT).show();
				}
			}
			return true;	
		case R.id.login:
	
			startActivity(intent);
			
			return true;
			
			

		default:
			return super.onOptionsItemSelected(item);
		}
		
		
		
	}
}
