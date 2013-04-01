package com.alberovalley.geografiaspain;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.alberovalley.utils.data.GeographySpain;

public class GeographySelector extends DialogFragment 
	implements OnItemSelectedListener, OnClickListener {
	
	private static GeographySpain geography;
	
	private GeographyListener gListener;
	
	private Activity mActivity;
	private Context context;
	private Spinner  spRegion;
	private Spinner  spProvincia;
	private Spinner  spMunicipio;
	private Button   btSearch;
	
	private ArrayAdapter<String> aaMunicipios;
	private ArrayAdapter<String> aaProvincias;
	private ArrayAdapter<String> aaRegiones;
	
	private String region;
	private String provincia = "";
	private String municipio = "";
	
	public void setOnGeograpySelectedListener(GeographyListener lis){
		this.gListener = lis;
	}
	
	public GeographySelector(Context context){
		this.context = context;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mActivity = getActivity();
		
		geography = GeographySpain.getInstance(mActivity);
		
		View view = inflater.inflate(R.layout.fragment_geography_selector, container);
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		btSearch   = (Button) view.findViewById(R.id.ts_bt_search);

		spMunicipio = (Spinner) view.findViewById(R.id.ts_sp_municipios) ;
		spProvincia = (Spinner) view.findViewById(R.id.ts_sp_provincias) ;
		spRegion    = (Spinner) view.findViewById(R.id.ts_sp_regiones) ;

		

		aaRegiones = geography.putStringArrayIntoAdapter(
				geography.getRegiones(geography.regionLabel)
						, context
						);
		aaProvincias= new ArrayAdapter<String>( 
				context, 
				android.R.layout.simple_spinner_item
				);
		aaMunicipios= new ArrayAdapter<String>(
				context, 
				android.R.layout.simple_spinner_item
				);


		aaRegiones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		aaProvincias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		aaMunicipios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



		spRegion.setAdapter(aaRegiones);
		spProvincia.setAdapter(aaProvincias);
		spMunicipio.setAdapter(aaMunicipios);

		spRegion.setOnItemSelectedListener(this);
		spProvincia.setOnItemSelectedListener(this);
		spMunicipio.setOnItemSelectedListener(this);



		btSearch.setOnClickListener(this);
		return view;
	}


	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		int viewId = parent.getId();
		if (viewId == R.id.ts_sp_regiones){
			region = aaRegiones.getItem(position);
			if(region != null 
					&& !region.equalsIgnoreCase(geography.regionLabel) 
					&& !region.equalsIgnoreCase("")){
				aaProvincias= geography.putStringArrayIntoAdapter( 
						geography.getProvincias(
								region, geography.provinciaLabel)
								, mActivity
						);
			}else{ // ha elegido la etiqueta
				aaProvincias= geography.putStringArrayIntoAdapter( 
						geography.getProvincias(
								region,geography.provinciaSinRegionLabel )
								, mActivity
						);
			}
			spProvincia.setAdapter(aaProvincias);
			aaProvincias.notifyDataSetChanged();
		}else if(viewId == R.id.ts_sp_provincias){
			provincia = aaProvincias.getItem(position);
			if(provincia !=null 
					&& 
					!provincia.equalsIgnoreCase(geography.provinciaLabel)
					&& 
					!provincia.equalsIgnoreCase(geography.provinciaSinRegionLabel)
					&& !provincia.equalsIgnoreCase("")
					){
				aaMunicipios= geography.putStringArrayIntoAdapter(
						geography.getMunicipios(
								provincia, geography.municipioLabel )
								, mActivity
						);
			}else{
				aaMunicipios = geography.putStringArrayIntoAdapter(
						geography.getMunicipios(
								provincia, geography.municipioSinProvinciaLabel )
								, mActivity
						);
			}
			spMunicipio.setAdapter(aaMunicipios);
			aaMunicipios.notifyDataSetChanged();
		}else if(viewId == R.id.ts_sp_municipios){
			municipio = aaMunicipios.getItem(position) ;
		}else{
			Log.wtf("", "RegisterFragment.onItemSelected descontrolado");
		}
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.ts_bt_search){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(GeographySpain.MUNICIPIO,municipio);
			map.put(GeographySpain.PROVINCIA,provincia);
			map.put(GeographySpain.REGION,region);
			this.gListener.onGeographySelected(map);
			this.dismiss();
		}
		
	}
	
}
