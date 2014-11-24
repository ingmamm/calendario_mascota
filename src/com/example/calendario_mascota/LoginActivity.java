package com.example.calendario_mascota;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.example.calendario_mascota.db.Calendario_MascotaDataSource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private static final String SEGURIDA = "AIzaSyC_d-OLZeBhz-aOUvm25wz0Ds9jWogIqBM";
	Calendario_MascotaDataSource login;

	TextView usuario,  contraseña;
	String user,pass;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		btn = (Button)findViewById(R.id.button1);

		login = new Calendario_MascotaDataSource(this);
		
		
		TextView usuario = (TextView) findViewById(R.id.editText1);
		TextView contraseña = (TextView) findViewById(R.id.editText2);
		
		user = usuario.getText().toString();
		pass = contraseña.getText().toString();
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
				startActivity(intent);
			}
		});
		
	}
	 private Boolean ValidarDatos(){
		  if (user.isEmpty()&&pass.isEmpty()) {
			  Toast.makeText(getApplicationContext(), "Debe ingresar un nombre de usuario y/o contraseña", Toast.LENGTH_LONG).show();
			  return false;
		}else{
			return true;
		}
		  
	  }
	  private static String bytesToHexString(byte[] bytes) {
	      
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < bytes.length; i++) {
	            String hex = Integer.toHexString(0xFF & bytes[i]);
	            if (hex.length() == 1) {
	                sb.append('0');
	            }
	            sb.append(hex);
	        }
	        return sb.toString();
	    }
	  public String hashPass(String password){
		  Log.i("HASH", "Hasehando " );
		  password+=SEGURIDA; 
	    MessageDigest digest=null;
	    String hash;
	    try {
	        digest = MessageDigest.getInstance("SHA-256");
	        digest.update(password.getBytes());

	        hash = bytesToHexString(digest.digest());

	        Log.i("HASH", "hash completo " );
	        return hash;
	    } catch (NoSuchAlgorithmException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }
	    return password;
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		switch (item.getItemId()) {
		
		case R.id.ingresar:
			Log.i("Ingresar", "se presiono el boton " );
			login.openDB();
			
			if(ValidarDatos()&&login.autenticar(user, hashPass(pass))){
				Log.i("Ingresar", "entro al if " );
			Intent intentMenu = new Intent(getApplicationContext(), MenuActivity.class);
			startActivity(intentMenu);
			}else {
				Toast.makeText(getApplicationContext(), "Usuario y/o Contraseña incorrecto", Toast.LENGTH_SHORT);
			}
			Log.i("Ingresar", "salio del if " );
			login.closeDB();
			return true;	
		case R.id.registro:
			Log.i("Registro", "se presiono el boton " );
			Intent intentRegistro = new Intent(this,RegistroActivity.class);
			startActivity(intentRegistro);
			
			return true;
			
			

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
