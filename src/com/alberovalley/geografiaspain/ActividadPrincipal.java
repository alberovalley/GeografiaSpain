package com.alberovalley.geografiaspain;


import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.alberovalley.utils.data.GeographySpain;

public class ActividadPrincipal extends FragmentActivity 
	implements OnClickListener, GeographyListener {

	private TextView tvRegion;
	private TextView tvProvincia;
	private TextView tvMunicipio;
	
	private Button btProbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad_principal);
		
		btProbar = (Button) findViewById(R.id.btProbar);
		btProbar.setOnClickListener(this);
		
		tvRegion    = (TextView)findViewById(R.id.tvRegion);
		tvProvincia = (TextView)findViewById(R.id.tvProvincia);
		tvMunicipio = (TextView)findViewById(R.id.tvMunicipio);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad_principal, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.btProbar){
			GeographySelector gs = new GeographySelector(this);
			gs.setOnGeograpySelectedListener(this);
			FragmentManager fm = getSupportFragmentManager();
			gs.show(fm, "geographySelector");
		}
		
	}

	@Override
	public void onGeographySelected(Map<String, String> hm) {
		tvRegion.setText(hm.get(GeographySpain.REGION));
		tvProvincia.setText(hm.get(GeographySpain.PROVINCIA));
		tvMunicipio.setText(hm.get(GeographySpain.MUNICIPIO));
		
		
	}

			
}
