package com.example.calendario_mascota;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AgregarEventoActivity extends Activity {

	Spinner spinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar_evento);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		spinner=(Spinner)findViewById(R.id.spinner1);
		
		ArrayAdapter adapter= ArrayAdapter.createFromResource(this,	R.array.tipoEvento, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.agregar_evento, menu);
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
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
