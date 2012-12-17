package com.alberovalley.geografiaspain;

import com.alberovalley.utils.data.GeographySpain;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ActividadPrincipal extends Activity implements OnItemSelectedListener {
	private Spinner regionesSpinner;
	private Spinner provinciasSpinner;
	private Spinner municipiosSpinner;
	
	private ArrayAdapter<String> regionesAdapter;
	private ArrayAdapter<String> provinciasAdapter;
	private ArrayAdapter<String> municipiosAdapter;

	private GeographySpain geografiaEspana;
	private String[] regiones;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad_principal);
		
		geografiaEspana = GeographySpain.getInstance(this);
		
		regionesSpinner   = (Spinner)findViewById(R.id.spregiones);
		provinciasSpinner = (Spinner)findViewById(R.id.spprovincias);
		municipiosSpinner = (Spinner)findViewById(R.id.spmunicipios);
		
		regiones = geografiaEspana.getRegiones();
		
		regionesAdapter = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_spinner_item
				, regiones
				);
		
		provinciasAdapter = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_spinner_item
				);
		municipiosAdapter = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_spinner_item
				);
		regionesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		provinciasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		municipiosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		regionesSpinner.setAdapter(regionesAdapter);
		provinciasSpinner.setAdapter(provinciasAdapter);
		municipiosSpinner.setAdapter(municipiosAdapter);
		
		regionesSpinner.setOnItemSelectedListener(this);
		provinciasSpinner.setOnItemSelectedListener(this);
		municipiosSpinner.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad_principal, menu);
		return true;
	}

	@SuppressLint("NewApi")
	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		
		int viewId = v.getId();
		Log.d("GeographySpain", "onItemSelected " + viewId);
		if(viewId == R.id.spregiones){
			String region = regionesAdapter.getItem(position);
			Log.d("GeographySpain", "elegida region " + region);
			provinciasAdapter.addAll(geografiaEspana.getProvinciass(region));
			provinciasAdapter.notifyDataSetChanged();
		}else if (viewId == R.id.spprovincias){
			String provincia = provinciasAdapter.getItem(position);
			Log.d("GeographySpain", "elegida provincia " + provincia);
			municipiosAdapter.addAll(geografiaEspana.getMunicipios(provincia ));
			municipiosAdapter.notifyDataSetChanged();
		}else if (viewId == R.id.spmunicipios){
			String municipio = municipiosAdapter.getItem(position) ;
			Log.d("GeographySpain", "elegida provincia " + municipio);
			Toast.makeText(this, "Municipio elegido: ["+municipio+ "]", Toast.LENGTH_SHORT).show();
		}else{
			Log.w("GeographySpain", "evento no controlado");
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
