package com.example.calendario_mascota;

import com.example.calendario_mascota.db.Calendario_MascotaDataSource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends Activity {

	Calendario_MascotaDataSource registro;
	TextView nombre,aPaterno,aMaterno,user,pass,pass2,fNacimiento,email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		registro.openDB();
		
		nombre=(TextView)findViewById(R.id.editText1);
		aPaterno=(TextView)findViewById(R.id.editText2);
		aMaterno=(TextView)findViewById(R.id.editText3);
		email=(TextView)findViewById(R.id.editText4);
		user=(TextView)findViewById(R.id.editText5);
		pass=(TextView)findViewById(R.id.editText6);
		pass2=(TextView)findViewById(R.id.editText7);
		fNacimiento=(TextView)findViewById(R.id.editText8);
		
		pass.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(pass.getText().toString().isEmpty() || pass.getText().length()<=8){
					
					Toast.makeText(getApplicationContext(), "Debe ingresar una contraseña con 8 caracteres.", Toast.LENGTH_SHORT).show();
					pass.requestFocus();
				}
			}
		});
		pass2.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if (!pass.equals(pass2)){
					Toast.makeText(getApplicationContext(), "La contraseña no coinciden", Toast.LENGTH_SHORT).show();
					pass2.requestFocus();
				}
			}
		});
		
		registro.closeDB();
	}
	public void validarCampos() {
	
		if (nombre.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un nombre", Toast.LENGTH_SHORT).show();
			nombre.requestFocus();
		}
		if (aPaterno.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un Apellido Paterno", Toast.LENGTH_SHORT).show();
			aPaterno.requestFocus();
		}
		if (aMaterno.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un Apellido Materno", Toast.LENGTH_SHORT).show();
			aMaterno.requestFocus();
		}
		if (email.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un email", Toast.LENGTH_SHORT).show();
			email.requestFocus();
		}
		if (fNacimiento.getText().toString().isEmpty()) {
			Toast.makeText(getApplicationContext(), "Debe ingresar un fecha de nacimiento", Toast.LENGTH_SHORT).show();
			fNacimiento.requestFocus();
		}
		
		
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
			validarCampos();
			if (registro.registrarUsuario(nombre.getText().toString(), aPaterno.getText().toString(), aMaterno.getText().toString(),
					user.getText().toString(), pass.getText().toString(), email.getText().toString(), fNacimiento.getText().toString())) {
				Toast.makeText(getApplicationContext(), "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
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
