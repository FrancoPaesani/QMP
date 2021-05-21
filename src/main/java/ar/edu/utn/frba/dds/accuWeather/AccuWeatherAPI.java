package ar.edu.utn.frba.dds.accuWeather;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AccuWeatherAPI {
	private int llamadasEnDia = 0;
	private LocalDate fechaUltimaLlamada = LocalDate.now();

    private final List<Map<String, Object>> getWeather(String ciudad) {
		return Arrays.asList(new HashMap<String, Object>(){{
			put("DateTime", "2019-05-03T01:00:00-03:00");
			put("EpochDateTime", 1556856000);
			put("WeatherIcon", 33);
			put("IconPhrase", "Clear");
			put("IsDaylight", false);
			put("PrecipitationProbability", 0);
			put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
			put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
			put("Temperature", new HashMap<String, Object>(){{
				put("Value", 57);
				put("Unit", "F");
				put("UnitType", 18);
			}});
		}});
	}

	public final List<Map<String, Object>> getBsAsWeather() {
		if (validarCantLlamads())
			return this.getWeather("Buenos Aires");
		else throw new CantLlamadasAccuWeather("Se llegó al límite de llamadas gratis diarias.");
    }

	private boolean validarCantLlamads() {
		if(fechaUltimaLlamada.equals(LocalDate.now()))
			llamadasEnDia += 1;
		else
			fechaUltimaLlamada = LocalDate.now();
		return llamadasEnDia < 10;
	}
}
