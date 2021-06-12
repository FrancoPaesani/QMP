package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.AccuWeatherAPI;
import ar.edu.utn.frba.dds.serviciosMeteorologicos.ServicioMeteorologicoAccuWeather;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

public class AccuApiTest {

    @Test
    public void AccuApiObtieneLaTemperaturaDeBuenosAiresATravesDeLaInterfaz() {
        AccuWeatherAPI lowApi = Mockito.mock(AccuWeatherAPI.class);
        Mockito.when(lowApi.getWeather("Buenos Aires")).thenReturn(Arrays.asList(new HashMap<String, Object>(){{
            put("Temperature", new HashMap<String, Object>(){{
                put("Value", 57);
                put("Unit", "F");
                put("UnitType", 18);
            }});
        }}));

        ServicioMeteorologicoAccuWeather api = new ServicioMeteorologicoAccuWeather(lowApi);
        assertEquals(
            api.getTemperatura("Buenos Aires").getDigito(),
            57,0);
    }

    @Test
    public void accuApiGetWeatherSeEjecutaUnaVez() {
        AccuWeatherAPI api = Mockito.mock(AccuWeatherAPI.class);
        api.getWeather("Buenos Aires");
        Mockito.verify(api,Mockito.only()).getWeather(anyString());
    }

    @Test
    public void apiObtieneTemperaturaDeBuenosAires() {
        ServicioMeteorologicoAccuWeather api = Mockito.mock(ServicioMeteorologicoAccuWeather.class);
        api.getTemperatura("Buenos Aires");
        Mockito.verify(api,Mockito.only()).getTemperatura(anyString());
    }

    @Test
    public void puedoLlamarAPIMenosDe10Veces() {
        ServicioMeteorologicoAccuWeather api = Mockito.mock(ServicioMeteorologicoAccuWeather.class);
        for (int i = 0; i < 9 ; i++) {
            api.getTemperatura("Buenos Aires");
        }
        Mockito.verify(api,Mockito.times(9)).getTemperatura(anyString());
    }
}
