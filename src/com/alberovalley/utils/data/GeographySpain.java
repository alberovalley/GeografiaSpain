package com.alberovalley.utils.data;

import java.util.HashMap;

import com.alberovalley.geografiaspain.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

public class GeographySpain {
	
	private static HashMap <String, String[]> regionesProvincias;
	private static HashMap <String, String[]> provinciasMunicipios;
	private static HashMap <String, String> municipiosProvincia;
	private static HashMap <String, String> provinciasRegion;
	private static String[] regiones;
	
	private static GeographySpain instance = null;
	
	public static GeographySpain getInstance(Context context){
		if(instance== null){
			instance = new GeographySpain(context);
		}
		return instance;
	}
	
	
	public GeographySpain(Context context){
		Resources res = context.getResources();
		regiones = res.getStringArray(R.array.regiones);

		regionesProvincias = new HashMap<String, String[]>();
		//Andalucía
		regionesProvincias.put(regiones[0], res.getStringArray(R.array.Andalucia));
		//Aragón
		regionesProvincias.put(regiones[1], res.getStringArray(R.array.Aragon));
		//Cantabria
		regionesProvincias.put(regiones[2], res.getStringArray(R.array.Cantabria));
		//Castilla y León
		regionesProvincias.put(regiones[3], res.getStringArray(R.array.CastillaLeon));
		//Castilla-La Mancha
		regionesProvincias.put(regiones[4], res.getStringArray(R.array.CastillaLaMancha));
		//Cataluña
		regionesProvincias.put(regiones[5], res.getStringArray(R.array.Cataluna));
		
		//Ceuta
		regionesProvincias.put(regiones[6], res.getStringArray(R.array.MunicipiosCeuta));
		
		//Comunidad de Madrid
		regionesProvincias.put(regiones[7], res.getStringArray(R.array.ComMadrid));
				
		//Comunidad Foral de Navarra
		regionesProvincias.put(regiones[8], res.getStringArray(R.array.ComNavarra));
		//Comunidad Valenciana
		regionesProvincias.put(regiones[9], res.getStringArray(R.array.ComValenciana));
		//Extremadura
		regionesProvincias.put(regiones[10], res.getStringArray(R.array.Extremadura));
		//Galicia
		regionesProvincias.put(regiones[11], res.getStringArray(R.array.Galicia));
		//Islas Baleares
		regionesProvincias.put(regiones[12], res.getStringArray(R.array.IslasBaleares));
		//Islas Canarias
		regionesProvincias.put(regiones[13], res.getStringArray(R.array.IslasCanarias));
		//La Rioja
		regionesProvincias.put(regiones[14], res.getStringArray(R.array.LaRioja));
		//Melilla
		regionesProvincias.put(regiones[15], res.getStringArray(R.array.MunicipiosMelilla));
		//País Vasco
		regionesProvincias.put(regiones[16], res.getStringArray(R.array.PaisVasco));
		
		//Principado de Asturias
		regionesProvincias.put(regiones[17], res.getStringArray(R.array.PrincipadoAsturias));
		//Regioń de Murcia
		regionesProvincias.put(regiones[18], res.getStringArray(R.array.RegionMurcia));
		
		
		//provincias-municipios
		String[] provincias = res.getStringArray(R.array.Provincias);
		
		provinciasMunicipios = new HashMap<String, String[]>();
		//Albacete
		provinciasMunicipios.put(provincias[0], res.getStringArray(R.array.MunicipiosAlbacete));
		//Álava
		provinciasMunicipios.put(provincias[1], res.getStringArray(R.array.MunicipiosAlava));
		//Alicante
		provinciasMunicipios.put(provincias[2], res.getStringArray(R.array.MunicipiosAlicante));
		//Almería
		provinciasMunicipios.put(provincias[3], res.getStringArray(R.array.MunicipiosAlmeria));
		//Asturias
		provinciasMunicipios.put(provincias[4], res.getStringArray(R.array.MunicipiosAsturias));
		//Ávila
		provinciasMunicipios.put(provincias[5], res.getStringArray(R.array.MunicipiosAvila));
		//Badajoz
		provinciasMunicipios.put(provincias[6], res.getStringArray(R.array.MunicipiosBadajoz));
		//Barcelona
		provinciasMunicipios.put(provincias[7], res.getStringArray(R.array.MunicipiosBarcelona));
		//Burgos
		provinciasMunicipios.put(provincias[8], res.getStringArray(R.array.MunicipiosBurgos));
		//Cáceres
		provinciasMunicipios.put(provincias[9], res.getStringArray(R.array.MunicipiosCaceres));
		//Cádiz
		provinciasMunicipios.put(provincias[10], res.getStringArray(R.array.MunicipiosCadiz));
		//Cantabria
		provinciasMunicipios.put(provincias[11], res.getStringArray(R.array.MunicipiosCantabria));
		//Castellón
		provinciasMunicipios.put(provincias[12], res.getStringArray(R.array.MunicipiosCastellon));
		//Ceuta
		provinciasMunicipios.put(provincias[13], res.getStringArray(R.array.MunicipiosCeuta));
		//Ciudad Real
		provinciasMunicipios.put(provincias[14], res.getStringArray(R.array.MunicipiosCiudadReal));
		//Córdoba
		provinciasMunicipios.put(provincias[15], res.getStringArray(R.array.MunicipiosCordoba));
		//Cuenca
		provinciasMunicipios.put(provincias[16], res.getStringArray(R.array.MunicipiosCuenca));
		//Gerona
		provinciasMunicipios.put(provincias[17], res.getStringArray(R.array.MunicipiosGerona));
		//Granada
		provinciasMunicipios.put(provincias[18], res.getStringArray(R.array.MunicipiosGranada));
		//Guadalajara
		provinciasMunicipios.put(provincias[19], res.getStringArray(R.array.MunicipiosGuadalajara));
		//Guipúzcoa
		provinciasMunicipios.put(provincias[20], res.getStringArray(R.array.MunicipiosGuipuzcoa));
		//Huelva
		provinciasMunicipios.put(provincias[21], res.getStringArray(R.array.MunicipiosHuelva));
		//Huesca
		provinciasMunicipios.put(provincias[22], res.getStringArray(R.array.MunicipiosHuesca));
		//Islas Baleares
		provinciasMunicipios.put(provincias[23], res.getStringArray(R.array.MunicipiosBaleares));
		//Jaén
		provinciasMunicipios.put(provincias[24], res.getStringArray(R.array.MunicipiosJaen));
		//La Coruña
		provinciasMunicipios.put(provincias[25], res.getStringArray(R.array.MunicipiosCoruna));
		//La Rioja
		provinciasMunicipios.put(provincias[26], res.getStringArray(R.array.MunicipiosLaRioja));
		//Las Palmas de Gran Canaria
		provinciasMunicipios.put(provincias[27], res.getStringArray(R.array.MunicipiosLasPalmas));
		//Lérida
		provinciasMunicipios.put(provincias[28], res.getStringArray(R.array.MunicipiosLerida));
		//León
		provinciasMunicipios.put(provincias[29], res.getStringArray(R.array.MunicipiosLeon));
		//Lugo
		provinciasMunicipios.put(provincias[30], res.getStringArray(R.array.MunicipiosLugo));
		//Madrid
		provinciasMunicipios.put(provincias[31], res.getStringArray(R.array.MunicipiosMadrid));
		//Málaga
		provinciasMunicipios.put(provincias[32], res.getStringArray(R.array.MunicipiosMalaga));
		//Melilla
		provinciasMunicipios.put(provincias[33], res.getStringArray(R.array.MunicipiosMelilla));
		//Murcia
		provinciasMunicipios.put(provincias[34], res.getStringArray(R.array.MunicipiosMurcia));
		//Navarra
		provinciasMunicipios.put(provincias[35], res.getStringArray(R.array.MunicipiosNavarra));
		//Orense
		provinciasMunicipios.put(provincias[36], res.getStringArray(R.array.MunicipiosOrense));
		//Palencia
		provinciasMunicipios.put(provincias[37], res.getStringArray(R.array.MunicipiosPalencia));
		//Pontevedra
		provinciasMunicipios.put(provincias[38], res.getStringArray(R.array.MunicipiosPontevedra));
		//Salamanca
		provinciasMunicipios.put(provincias[39], res.getStringArray(R.array.MunicipiosSalamanca));
		//Santa Cruz de Tenerife
		provinciasMunicipios.put(provincias[40], res.getStringArray(R.array.MunicipiosTenerife));
		//Segovia
		provinciasMunicipios.put(provincias[41], res.getStringArray(R.array.MunicipiosSegovia));
		//Sevilla
		provinciasMunicipios.put(provincias[42], res.getStringArray(R.array.MunicipiosSevilla));
		//Soria
		provinciasMunicipios.put(provincias[43], res.getStringArray(R.array.MunicipiosSoria));
		//Tarragona
		provinciasMunicipios.put(provincias[44], res.getStringArray(R.array.MunicipiosTarragona));
		//Teruel
		provinciasMunicipios.put(provincias[45], res.getStringArray(R.array.MunicipiosTeruel));
		//Toledo
		provinciasMunicipios.put(provincias[46], res.getStringArray(R.array.MunicipiosToledo));
		//Valencia
		provinciasMunicipios.put(provincias[47], res.getStringArray(R.array.MunicipiosValencia));
		//Valladolid
		provinciasMunicipios.put(provincias[48], res.getStringArray(R.array.MunicipiosValladolid));
		//Vizcaya
		provinciasMunicipios.put(provincias[49], res.getStringArray(R.array.MunicipiosVizcaya));
		//Zamora
		provinciasMunicipios.put(provincias[50], res.getStringArray(R.array.MunicipiosZamora));
		//Zaragoza
		provinciasMunicipios.put(provincias[51], res.getStringArray(R.array.MunicipiosZaragoza));

		
		
		// búsqueda inversa
		Log.d("GeographySpain", "GeographySpain instanciando" );
		municipiosProvincia = new HashMap<String, String>();
		provinciasRegion = new HashMap<String, String>();
		String[] regiones = res.getStringArray(R.array.regiones);
		Log.d("GeographySpain", "GeographySpain regiones nº " + regiones.length );
		for (int i = 0; i < regiones.length; i ++){
			Log.d("GeographySpain", "GeographySpain region nº " + i );
			String region = regiones[i];
			Log.d("GeographySpain", "GeographySpain region nº " + i + " => " + region);
			String[] provincias2 = getProvincias(region);
			Log.d("GeographySpain", "GeographySpain provincias de " + region + " total " + provincias2.length);
			int j = 0;
			while(j < provincias2.length){
				Log.d("GeographySpain", "GeographySpain provincia nº " + j );
				String provincia = provincias2[j];
				Log.d("GeographySpain", "GeographySpain provincia nº " + j + " => " + provincia);
				provinciasRegion.put(provincia, region);
				
				String[] municipios = getMunicipios(provincia);
				Log.d("GeographySpain", "GeographySpain municipios de " + provincia + " total " + municipios.length);
				int k = 0;
				while(k < municipios.length){
					Log.d("GeographySpain", "GeographySpain municipio nº " +k);
					String municipio = municipios[k];
					Log.d("GeographySpain", "GeographySpain municipio nº " + k + " => " + municipio);
					municipiosProvincia.put(municipio, provincia);
					 k++;
				}
				j++;
			}
		
			Log.d("GeographySpain", "GeographySpain siguiente region " + (regiones.length - i));
		}
	}
	
	public String[] getProvincias(String region){
		String[] provincias = regionesProvincias.get(region);
		return provincias;
	}
	public  String[] getRegiones(){ 
		return regiones;
	}

	public  String[] getMunicipios(String provincia){
		return provinciasMunicipios.get(provincia);
	}
	
	public String getRegionDeProvincia(String provincia){
		String region = provinciasRegion.get(provincia);
		return region;
	}
	public String getProvinciaDeMunicipio(String municipio){
		String provincia= municipiosProvincia.get(municipio);
		return provincia;
	}
}
