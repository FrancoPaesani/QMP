package ar.edu.utn.frba.dds.QMP;

import ar.edu.utn.frba.dds.serviciosMeteorologicos.ServicioMeteorologicoAccuWeather;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

public class AccuApiTest {

    @Test
    public void apiObtieneTemperaturaDeBuenosAires() {
        ServicioMeteorologicoAccuWeather api = Mockito.mock(ServicioMeteorologicoAccuWeather.class);
        api.getTemperatura("Buenos Aires");
        Mockito.verify(api,Mockito.only()).getTemperatura(anyString());
    }

    @Test
    public void noPuedoLlamarAPIMasDe10Veces() {
        ServicioMeteorologicoAccuWeather api = Mockito.mock(ServicioMeteorologicoAccuWeather.class);
        for (int i = 0; i < 10 ; i++) {
            api.getTemperatura("Buenos Aires");
        }
        assertTrue(!api.validarCantLlamads());
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
