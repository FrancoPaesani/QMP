package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.accuWeather.AccuWeatherAPI;
import ar.edu.utn.frba.dds.accuWeather.CantLlamadasAccuWeather;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AccuApiTest {

    @Test
    public void apiObtieneTemperaturaDeBuenosAires() {
        AccuWeatherAPI api = Mockito.mock(AccuWeatherAPI.class);
        api.getBsAsWeather();
        Mockito.verify(api,Mockito.only()).getBsAsWeather();
    }

    @Test
    public void noPuedoLlamarAPIMasDe10Veces() {
        AccuWeatherAPI api = Mockito.mock(AccuWeatherAPI.class);
        try {
            for (int i = 0; i < 10 ; i++) {
                api.getBsAsWeather();
            }
        }
        catch (CantLlamadasAccuWeather excep) {
            assertEquals(excep.getMessage(),"Se llegó al límite de llamadas gratis diarias.");
        }
    }

    @Test
    public void puedoLlamarAPIMenosDe10Veces() {
        AccuWeatherAPI api = Mockito.mock(AccuWeatherAPI.class);
        try {
            for (int i = 0; i < 9 ; i++) {
                api.getBsAsWeather();
            }
        }
        catch (CantLlamadasAccuWeather excep) {
            assertNotEquals(excep.getMessage(),"Se llegó al límite de llamadas gratis diarias.");
        }
    }
}
