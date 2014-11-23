package com.example.calendario_mascota;

import java.util.List;
import com.example.calendario_mascota.R;
import com.example.calendario_mascota.lib.EventoAdapter;
import com.example.calendario_mascota.db.Calendario_MascotaDataSource;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MenuActivity extends ListActivity {
	
	List<Evento> eventos;
	Calendario_MascotaDataSource datasource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		datasource = new Calendario_MascotaDataSource(this);
		datasource.openDB();
		eventos = datasource.obtenerEventos();
		
		EventoAdapter adapter = new EventoAdapter(this, R.layout.detalle_menu, eventos);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Evento evento = eventos.get(position);
		
		Intent intent = new Intent(this, DetalleEventoActivity.class);
		intent.putExtra("descripcion", evento.getDescripcion());
		
		startActivity(intent);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Intent intent_agregar_evento = new Intent(this, AgregarEventoActivity.class);
		
		switch (id) {
		case android.R.id.home:
			
			break;
		case R.id.agregar:
			
			startActivity(intent_agregar_evento);
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}