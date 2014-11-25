package com.example.calendario_mascota.lib;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.calendario_mascota.R;
import com.exemple.calendario_mascota.tablas.Usuario;

public class UsuarioAdapter extends ArrayAdapter<Usuario>{
	
	private Context context;
	private List<Usuario> objects;

	public UsuarioAdapter(Context context, int textViewResourceId,
			List<Usuario> objects) {
		super(context, textViewResourceId, objects);
		
		this.context = context;
		this.objects = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Usuario usuario =objects.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_perfil, null);
		
		EditText etUsuario = (EditText)view.findViewById(R.id.etUsuario);
		etUsuario.setHint(usuario.getUser());
		
		EditText etNombre = (EditText)view.findViewById(R.id.etNombre);
		etNombre.setHint(usuario.getNombre());
		
		
		
		return view;
		
		}
}
