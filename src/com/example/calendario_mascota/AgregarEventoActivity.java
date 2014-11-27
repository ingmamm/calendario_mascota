package com.example.calendario_mascota;

import java.util.Calendar;

import android.R.string;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class AgregarEventoActivity extends Activity {

	protected static final String LOG = "agregar evento";
	Spinner spinner;
	String evento;
	EditText  descripcion, fecha;
	String fHoy, fSeleccionada;
	int mDay,mMonth,mYear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar_evento);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		spinner=(Spinner)findViewById(R.id.spinner1);
		descripcion = (EditText)findViewById(R.id.editText1);		
		fecha = (EditText)findViewById(R.id.editText2);
		
		ArrayAdapter adapter= ArrayAdapter.createFromResource(this,	R.array.tipoEvento, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
					int position, long id) {
				// TODO Auto-generated method stub
				evento = parentView.getItemAtPosition(position).toString();
						
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {
				// TODO Auto-generated method stub
				
			}
		});
		fecha.setOnClickListener(new OnClickListener() {

	        @Override
	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            //To show current date in the datepicker
	            Calendar mcurrentDate=Calendar.getInstance();
	            mYear=mcurrentDate.get(Calendar.YEAR);
	            mMonth=mcurrentDate.get(Calendar.MONTH);
	            mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);
	            fHoy= generarFecha(mDay, mMonth, mYear) ;
	        	Log.i(LOG, "listo "+fHoy );

	            DatePickerDialog mDatePicker=new DatePickerDialog(AgregarEventoActivity.this, new OnDateSetListener() {                  
	                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
	                    // TODO Auto-generated method stub                      
	                    /*      Your code   to get date and time    */
	                	fSeleccionada= generarFecha(mDay, mMonth, mYear) ;
	                	fecha.setText(fSeleccionada);
	                	
	                }
	                	
	            },mYear, mMonth, mDay);
	            mDatePicker.setTitle("Selecione una fecha");                
	            mDatePicker.show();  }
	    });
	}
	public String generarFecha(int selectedday,int selectedmonth,int selectedyear){
		
		return (String.valueOf(selectedday)+"-"+String.valueOf(selectedmonth)+"-"+String.valueOf(selectedyear));
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
		case R.id.guardar:
			
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
