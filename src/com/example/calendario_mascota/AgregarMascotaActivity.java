package com.example.calendario_mascota;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AgregarMascotaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar_mascota);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.agregar_mascota, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Intent intent_menu = new Intent(this, MenuActivity.class);
		Intent intent_login = new Intent (this, LoginActivity.class);
		
		switch (id) {
		case android.R.id.home:
			startActivity(intent_menu);
			break;
		case R.id.deslogueo:
			startActivity(intent_login);
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
