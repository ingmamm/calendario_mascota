package com.example.calendario_mascota.lib;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.calendario_mascota.R;
import com.exemple.calendario_mascota.tablas.Evento;

public class EventoAdapter extends ArrayAdapter<Evento>{
	
	private Context context;
	private List<Evento> objects;

	public EventoAdapter(Context context, int textViewResourceId,
			List<Evento> objects) {
		super(context, textViewResourceId, objects);
		
		this.context = context;
		this.objects = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Evento evento =objects.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.detalle_menu, null);
		
		TextView tvMascota = (TextView) view.findViewById(R.id.tvMascota);
		tvMascota.setText(evento.getNombre_mascota());
		
		TextView tvFecha = (TextView) view.findViewById(R.id.tvFecha);
		tvFecha.setText(evento.getFecha());
		
		TextView tvDescripcion = (TextView) view.findViewById(R.id.tvDescripcion);
		tvDescripcion.setText(evento.getDescripcion());
		
		return view;
		
		}
}
